package controllers;
import models.*;
import play.mvc.*;
import java.util.List;

/**
 * Created by caoyi on 16/4/25.
 */
public class Popularity extends Controller {

    public Result getCommentSum(int rootid) {
        List<Comment> comments = Comment.find.where().eq("rootid", rootid).findList();
        return ok(String.valueOf(comments.size()));
    }
    public Result getTagSum(Long pubid){
        List<Tagpub> tags = Tagpub.findwithpublication.where().eq("pub_id",pubid).findList();
        return ok(String.valueOf(tags.size()));
    }

}
