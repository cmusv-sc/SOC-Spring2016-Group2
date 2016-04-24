package controllers;


import com.avaje.ebean.Model;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import com.fasterxml.jackson.databind.util.JSONPObject;
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static controllers.keyWordSearch.search;
import static play.data.Form.form;
import static play.libs.Json.toJson;

public class Application extends Controller {

    public Result index() {

        return ok(index.render());
    }

    public  Result getPersons() {
        Person person = form(Person.class).bindFromRequest().get();
         System.out.println("person"+person);
        Http.RequestBody requestBody=request().body();
        System.out.println(requestBody.asText());
        List<Person> persons = new Model.Finder(String.class, Person.class).all();
        persons.add(0,new Person((long)1,new Date(), "zhangs"));
        return ok(toJson(persons));
    }
    /***
     * This method is used to find the paper by year
     */

    public Result getPaperByYear(int year) {
        System.out.println(year);
        List<ObjectNode> results=new ArrayList<ObjectNode>();
        List<Publication> publications = Publication.find("byYear", year, null,null);
        System.out.println("There are " + publications.size() + " publication"+year);
        results=Publication.findPubDetails(publications,results,"getPaperByYear");
        return ok(Json.toJson(results));
    }
    public Result getPaperByTitle(String title){

        List<Publication> publications = Publication.find("byTitle", null, title,null);

        List<ObjectNode> results=new ArrayList<ObjectNode>();
        System.out.println("There are " + publications.size() );
        results=Publication.findPubDetails(publications,results,"getPaperByTitle");
        return ok(Json.toJson(results));
    }
     public Result getPaperBykeyWord(String keyword) throws IOException {
         System.out.println("call getPaperDetails....");
        List<ObjectNode> results=new ArrayList<ObjectNode>();
        try {
            results =new ArrayList<ObjectNode>();
            keyWordSearch.rebuildIndexes(keyWordSearch.getIndexWriter(true));
            search(keyword, 100,results);
        } catch (Exception e) {
            e.printStackTrace();
        }
         JsonNode jsonpObject=Json.toJson(results);
         return ok(jsonpObject);
    }


    public Result getAllPublications(){
        //get all publications details
        List<ObjectNode> results=new ArrayList<ObjectNode>();
        List<Publication> publications=Publication.find.all();
        results=Publication.findPubDetails(publications,results,"getAllPaper");
        JsonNode jsonNode=Json.toJson(results);
        return ok(jsonNode);
    }

    public Result getCoAuthors(String author){
        System.out.println("call get coauthors...");
        //1. get the author id by its name
        List<Long>  author_ids=Author.find_Author_Id(author);
        //2. find publication id by author id
        List<Long> pubids=PublicationAuthor.find_pub_id(author_ids);
        System.out.println(pubids.toString());
        //3. find publications by its id
        List<Publication> publications=Publication.find("byId",null,null,pubids);
        //4. find
        List<ObjectNode> results=new ArrayList<ObjectNode>();
        results=Publication.findPubDetails(publications,results, "getCoAuthors");
        JsonNode jsonpObject=Json.toJson(results);
        return ok(jsonpObject);
    }
    Publication Result getPaperByAuthor(String author){
      List<Long>  author_ids=Author.find_Author_Id(author);
      List<Long> pubids=PublicationAuthor.find_pub_id(author_ids);
      List<Publication> publications=Publication.find("byId",null,null,pubids);
      List<ObjectNode> results=new ArrayList<ObjectNode>();
      System.out.println("There are " + publications.size() );
      results=Publication.findPubDetails(publications,results,"getPaperByAuthor");
      return ok(Json.toJson(results));
    }
    }

}
