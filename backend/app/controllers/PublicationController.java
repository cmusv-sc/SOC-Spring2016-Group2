package controllers;

import models.*;
import play.mvc.*;
import java.util.Map;
import play.api.Logger;
import static play.data.Form.form;
import static play.libs.Json.toJson;
import java.util.HashMap;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;

public class PublicationController extends Controller
{
  public  Result updatePublication(){
    Map<String,String[]> params = request().body().asFormUrlEncoded();
    Long id = Long.parseLong(params.get("pub_id")[0]);

    String title = params.get("title")[0];
    Publication publication = Publication.find.byId(id);
    publication.setTitle(title);
    publication.save();
    HashMap<String, String> msg = new HashMap<String, String>();
    msg.put("title", publication.title);

    return ok(toJson(msg));
  }
}
