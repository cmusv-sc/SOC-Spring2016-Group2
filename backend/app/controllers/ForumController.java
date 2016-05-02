package controllers;

import models.*;
import play.mvc.*;

import play.mvc.Http.MultipartFormData;

import static play.data.Form.form;

import static play.libs.Json.toJson;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.io.File;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;

/**
 * Created by Cloud on 4/18/16.
 */
public class ForumController extends Controller{
    public Result addComment() {
        Comment comment = form(Comment.class).bindFromRequest().get();
        Long time = System.currentTimeMillis()/1000;
        comment.setTime(time);
        comment.save();
        HashMap<String, String> msg = new HashMap<String, String>();
        msg.put("message", "Insert succeeded!");
        return ok(toJson(comment));
    }

    public Result getCommentStatusByID(Long pub_id){
        boolean status;
        AccessComment accesscomment = AccessComment.find.byId(pub_id);
        if (accesscomment == null) {
          accesscomment = new AccessComment(pub_id, true);
        }
        status = accesscomment.isStatus();
        return ok(toJson(status));
    }

    public Result updateCommentStatus(Long pub_id, boolean status) {
      AccessComment accesscomment = AccessComment.find.byId(pub_id);
      if (accesscomment == null) {
        accesscomment = new AccessComment(pub_id, status);
      }

      accesscomment.setStatus(status);
      System.out.println("yuanyuan");
      System.out.println(status);
      accesscomment.save();
      HashMap<String, String> msg = new HashMap<String, String>();
      msg.put("message", "Update succeeded!");

      return ok(toJson(msg));
    }

    public Result getComments(int rootid, int categoryid, String userid) {
        return ok(toJson(getCommentsWithThumbs(rootid, categoryid, 0, userid)));
    }

    public Result updateComment() {
//        Map<String, String[]> params = request().body().asFormUrlEncoded();
//
//        int id = Integer.parseInt(params.get("id")[0]);
//        String content = params.get("content")[0];


        Comment oldcomment = form(Comment.class).bindFromRequest().get();

        Comment comment = Comment.find.byId(oldcomment.getId());
        comment.setContent(oldcomment.getContent());

        comment.save();

        HashMap<String, String> msg = new HashMap<String, String>();
        msg.put("message", "Update succeeded!");

        return ok(toJson(msg));
    }

    class NestedComment{
        public Comment comment;
        public int thumbup = 0;
        public int thumbdown = 0;
        public boolean thumbuped = false;
        public boolean thumbdowned = false;
        public ArrayList<NestedComment> children;
        public NestedComment(Comment comment, ArrayList<NestedComment> children){
            this.comment = comment;
            this.children = children;
        }
        public NestedComment(Comment comment, ArrayList<NestedComment> children, int thumbdown, int thumbup){
            this.comment = comment;
            this.children = children;
            this.thumbdown = thumbdown;
            this.thumbup = thumbup;
        }
    }


    public ArrayList<NestedComment> getCommentsRecursively(int rootid, int categoryid, int parentid){
        ArrayList<NestedComment> list = new ArrayList<NestedComment>();
        List<Comment> comments = Comment.find.where().eq("parentid", parentid).eq("rootid", rootid).eq("categoryid", categoryid).findList();
        for (int i = 0; i < comments.size(); i++){
            list.add(new NestedComment(comments.get(i), getCommentsRecursively(rootid, categoryid, comments.get(i).getId())));
        }
        return list;
    }

    public ArrayList<NestedComment> getCommentsWithThumbs(int rootid, int categoryid, int parentid, String userid){
        ArrayList<NestedComment> list = new ArrayList<NestedComment>();
        String sql = "select c.id, c.parentid, c.content, c.authorid, c.time, t.thumb_type, t.sender " +
        "from comment as c left join thumb as t on (c.id=t.receiver)" +
        " where c.rootid=" + rootid + " and c.categoryid=" + categoryid + " and c.parentid=" + parentid + " order by c.id";
        //System.out.println(sql);
        List<SqlRow> sqlRows = Ebean.createSqlQuery(sql).findList();
        Integer prev=null;
        for (int i = 0; i < sqlRows.size(); i++){
            SqlRow sqlRow = sqlRows.get(i);

            //System.out.println(sqlRow.getInteger("id") + ": " + prev);
            if (!sqlRow.getInteger("id").equals(prev)){
                prev = sqlRow.getInteger("id");
                Comment comment = new Comment(sqlRow.getInteger("id"), parentid, sqlRow.getString("authorid"), sqlRow.getString("content") , sqlRow.getLong("time"), rootid, categoryid);
                comment.setId(sqlRow.getInteger("id"));
                int thumbup = 0;
                int thumbdown = 0;
                boolean thumbuped = false;
                boolean thumbdowned = false;
                if (sqlRow.getBoolean("thumb_type") != null){
                    boolean thumb_type = sqlRow.getBoolean("thumb_type");
                    if (thumb_type == false){
                        thumbdown ++;
                    }else {
                        thumbup ++;
                    }

                    if (sqlRow.getString("sender").equals(userid)){
                        if (thumb_type == false){
                            thumbdowned = true;
                        }else {
                            thumbuped = true;
                        }
                    }
                }
                NestedComment nestedComment = new NestedComment(comment, getCommentsWithThumbs(rootid, categoryid, comment.getId(), userid), thumbdown, thumbup);
                nestedComment.thumbuped = thumbuped;
                nestedComment.thumbdowned = thumbdowned;
                list.add(nestedComment);
            }else {
                if (sqlRow.getBoolean("thumb_type") != null){
                    boolean thumb_type = sqlRow.getBoolean("thumb_type");
                    if (thumb_type == false){
                        list.get(list.size()-1).thumbdown ++;
                    }else {
                        list.get(list.size()-1).thumbup ++;
                    }

                    if (sqlRow.getString("sender").equals(userid)){
                        if (thumb_type == false){
                            list.get(list.size()-1).thumbdowned = true;
                        }else {
                            list.get(list.size()-1).thumbuped = true;
                        }
                    }
                }
            }

        }
        return list;
    }

    @BodyParser.Of(BodyParser.MultipartFormData.class)
    public Result uploadFile(){
        response().setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE");
        response().setHeader("Access-Control-Max-Age", "3600");
        response().setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-    Type, Accept, Authorization, X-Auth-Token");
        response().setHeader("Access-Control-Allow-Credentials", "true");
        response().setHeader("Access-Control-Allow-Origin", "*");
        MultipartFormData body = request().body().asMultipartFormData();
        MultipartFormData.FilePart uploadfile = body.getFile("file");
        if (uploadfile != null) {
            String fileName = System.currentTimeMillis() + uploadfile.getFilename();
            String contentType = uploadfile.getContentType();
            File file = (File) uploadfile.getFile();

            // added lines
            String myUploadPath = "./public/upload/";
            file.renameTo(new File(myUploadPath, fileName));

            return ok("/assets/upload/" + fileName);
        } else {
            flash("error", "Missing file");
            return badRequest();
        }
    }
}
