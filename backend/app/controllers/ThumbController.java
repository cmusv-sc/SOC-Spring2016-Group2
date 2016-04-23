package controllers;


import com.avaje.ebean.Model;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import com.google.common.collect.ImmutableMap;
import models.*;
import org.w3c.dom.Document;
import play.data.Form;
import play.db.Database;
import play.db.Databases;
import play.libs.Json;
import play.libs.XPath;
import play.mvc.*;
import views.html.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static play.data.Form.form;
import static play.libs.Json.toJson;

public class ThumbController extends Controller {
    
    public Result addThumb(){
        /*--- thumb_type: like=1, dislike=0 ---*/
        Thumb thumb = form(Thumb.class).bindFromRequest().get();
        System.out.println("addLike is " + thumb);
        Form thumbForm= form(Thumb.class);
        //set existing value into the form
        thumb.save();
        return ok();
    }
    public Result deleteThumb(Long id){
        Thumb.find.byId(id).delete();
        return ok();
    }
    public Result getThumbSum(String user, String type){
        /*---receive thumb sum by "user" or "id"---*/
        List<Thumb> thumbs = type.equals("user") ? Thumb.find("user", user):Thumb.find("id", user);
        int likeSum = 0;
        int dislikeSum = 0;
        for (Thumb thumb: thumbs)
        {
            if (thumb.getThumb_type()==true)
                likeSum++;
            else //if (thumb.getThumb_type()==false)
                dislikeSum++;
        }
        ObjectNode result = Json.newObject();
        result.put("like", likeSum);
        result.put("disLike", dislikeSum);
        return ok(Json.toJson(result));
    }
    // /*---Start: Useless part ---*/
    // public Result addLike(){
    //     Thumb thumb = form(Thumb.class).bindFromRequest().get();
    //     System.out.println("addLike is " + thumb);
    //     Form thumbForm= form(Thumb.class);
    //     //set existing value into the form
    //     thumb.save();
    //     return ok();
    // }
    // public Result deleteLike(Long id){
    //     Thumb.find.byId(id).delete();
    //     return ok();
    // }
    // public Result addDislike(){
    //     Thumb thumb = form(Thumb.class).bindFromRequest().get();
    //     System.out.println("disLike is " + thumb);
    //     Form thumbForm= form(Thumb.class);
    //     //set existing value into the form
    //     thumb.save();
    //     return ok();
    // }
    // public Result deleteDislike(Long id){
    //     Thumb.find.byId(id).delete();
    //     return ok();
    // }
    // /*---End: Useless part ---*/
}
