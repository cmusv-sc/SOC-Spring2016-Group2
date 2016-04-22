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

    public Result getComments(int rootid, int categoryid) {
        return ok(toJson(getCommentsRecursively(rootid, categoryid, 0)));
    }

    public Result updateComment() {
        Map<String, String[]> params = request().body().asFormUrlEncoded();

        int id = Integer.parseInt(params.get("id")[0]);
        String content = params.get("content")[0];

        Comment comment = Comment.find.byId(id);
        comment.setContent(content);

        comment.save();

        HashMap<String, String> msg = new HashMap<String, String>();
        msg.put("message", "Update succeeded!");

        return ok(toJson(msg));
    }

    public class NestedComment{
        public Comment comment;
        public ArrayList<NestedComment> children;
        public NestedComment(Comment comment, ArrayList<NestedComment> children){
            this.comment = comment;
            this.children = children;
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

    @BodyParser.Of(BodyParser.MultipartFormData.class)
    public Result uploadFile(){
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
