package controllers;

import java.io.File;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;

import models.Author;
import models.Publication;
import models.PublicationAuthor;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.io.IOException;
import java.util.*;

import static controllers.keyWordSearch.search;

public class Application extends Controller {

    public Result index() {

        return ok(new Gson().toJson("welcome"));
    }

    /***
     * This method is used to upload a file
     */
    public  Result upload() {
        play.mvc.Http.MultipartFormData<File> body = request().body().asMultipartFormData();
        play.mvc.Http.MultipartFormData.FilePart<File> picture = body.getFile("picture");
        if (picture != null) {
            String fileName = picture.getFilename();
            String contentType = picture.getContentType();
            java.io.File file = picture.getFile();

            return ok(file).as("image/png");
        } else {
            flash("error", "Missing file");
            return badRequest();
        }
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
}
