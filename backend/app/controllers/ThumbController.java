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

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;


public class ThumbController extends Controller {
    
    // @BodyParser.Of(BodyParser.Json.class)
    public Result addThumb(){
        /*--- thumb_type: like=1, dislike=0 ---*/
        /*--- with parameter: thumb_type, sender, receiver---*/
        Thumb thumb = form(Thumb.class).bindFromRequest().get();
        Boolean thumb_type = thumb.getThumb_type();
        String sender = thumb.getSender();
        int receiver = thumb.getReceiver();
        String sql = "select * from thumb where thumb_type=" + thumb_type + 
        " and sender='" + sender + "' and receiver=" + receiver;
        System.out.println(sql);
        List<SqlRow> sqlRows = Ebean.createSqlQuery(sql).findList();
        if (sqlRows.size()>0)
            return ok("Reject! thumb has already existed");
        Form thumbForm= form(Thumb.class);
        //set existing value into the form
        thumb.save();
        return ok("add thumb success");
    }
    public Result deleteThumb(int thumb_type, String sender, int receiver){
        String sql = "select id from thumb where thumb_type=" + thumb_type + 
        " and sender='" + sender + "' and receiver=" + receiver;
        System.out.println(sql);
        List<SqlRow> sqlRows = Ebean.createSqlQuery(sql).findList();
        for (SqlRow sqlRow: sqlRows)
        {
            Long id = Long.valueOf(sqlRow.getInteger("id"));
            Thumb.find.byId(id).delete();
        }
        return ok("delete thumb success");
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
}
