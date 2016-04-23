package controllers;

import java.io.File;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;

import models.Author;
import models.Publication;
import models.PublicationAuthor;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.*;

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
//        System.out.println(request().body().asText());
//        int year=Integer.parseInt(request().body().asText());
        System.out.println(year);
        List<ObjectNode> results=new ArrayList<ObjectNode>();
        List<Publication> publications = Publication.find("byYear", year, null);
        System.out.println("There are " + publications.size() + " publication"+year);
        for(Publication publication : publications) {
           // System.out.println(publication.toString());
            ObjectNode result = Json.newObject();
            List<PublicationAuthor> authorids=PublicationAuthor.find(publication.getId(),null);
            List<Author> authors=Author.find(authorids);
            StringBuilder sb=new StringBuilder();
            for(Author author: authors){
                sb.append(author+";");
            }
            result.put("authors",sb.toString());
            result.put("title", publication.getTitle());
            result.put("editor", publication.getEditor());
            result.put("booktitle",publication.getBooktitle());
            result.put("isbn", publication.getIsbn());
            result.put("year",publication.getYear());
            result.put("crossref",publication.getCrossref());
            result.put("ee",publication.getEe());
            result.put("url",publication.getUrl());
            result.put("series",publication.getSeries());
            result.put("volume",publication.getVolume());
            results.add(result);
        }
        return ok(Json.toJson(results));
    }

    public Result getPaperByTitle(String title){
//        String title=request().body().asText();
//        System.out.println(title);
        List<Publication> publications = Publication.find("byTitle", null, title);

        List<ObjectNode> results=new ArrayList<ObjectNode>();
        System.out.println("There are " + publications.size() );
        for(Publication publication : publications) {
            // System.out.println(publication.toString());
            ObjectNode result = Json.newObject();
            List<PublicationAuthor> authorids=PublicationAuthor.find(publication.getId(),null);
            System.out.println(authorids);
             List<Author> authors=Author.find(authorids);
            StringBuilder sb=new StringBuilder();
            for(Author author: authors){
                System.out.println(author);
                 sb.append(author+";");
            }
            result.put("authors",sb.toString());
            result.put("title", publication.getTitle());
            result.put("editor", publication.getEditor());
            result.put("booktitle",publication.getBooktitle());
            result.put("isbn", publication.getIsbn());
            result.put("year",publication.getYear());
            result.put("crossref",publication.getCrossref());
            result.put("ee",publication.getEe());
            result.put("url",publication.getUrl());
            result.put("series",publication.getSeries());
            result.put("volume",publication.getVolume());
            results.add(result);
        }
        return ok(Json.toJson(results));
    }
}
