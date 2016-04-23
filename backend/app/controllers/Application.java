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

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Model;
import com.avaje.ebean.SqlRow;

import static play.data.Form.form;
import static play.libs.Json.toJson;


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
    
    public Result getPublicationWithAuthorsById(int id){
        String sql = "select * "+
                "from publication as p join" +
                " (select pa.publication_id, a.id, a.name from publication_author as pa join author as a where pa.author_id=a.id) as t" +
                " where p.pub_id=t.publication_id and p.pub_id=" + id;
        return ok(toJson(joinPublicationAndAuthor(sql)));
    }

    public Result getPublicationWithAuthorsByYear(int year){
        String sql = "select * "+
                "from publication as p join" +
                " (select pa.publication_id, a.id, a.name from publication_author as pa join author as a where pa.author_id=a.id) as t" +
                " where p.pub_id=t.publication_id and year=" + year;
        return ok(toJson(joinPublicationAndAuthor(sql)));
    }

    public Result getPublicationWithAuthorsByTitle(String title){
        String sql = "select * "+
                "from publication as p join" +
                " (select pa.publication_id, a.id, a.name from publication_author as pa join author as a where pa.author_id=a.id) as t" +
                " where p.pub_id=t.publication_id and title like '%" + title + "%'";
        return ok(toJson(joinPublicationAndAuthor(sql)));
    }

    public ArrayList<PublicationWithAuthors> joinPublicationAndAuthor(String sql){
//        System.out.println(sql);
        List<SqlRow> sqlRows = Ebean.createSqlQuery(sql).findList();
        ArrayList<PublicationWithAuthors> results = new ArrayList<PublicationWithAuthors>();
        Long prev = 0L;
        for (int i = 0; i < sqlRows.size(); i++){
            SqlRow sqlRow = sqlRows.get(i);
            if (!sqlRow.getLong("publication_id").equals(prev)){
                prev = sqlRow.getLong("publication_id");
                Publication publication = new Publication();
                publication.setPubkey(sqlRow.getString("pubkey"));
                publication.setTitle(sqlRow.getString("title"));
                publication.setEditor(sqlRow.getString("editor"));
                publication.setYear(sqlRow.getString("year"));
                publication.setIsbn(sqlRow.getString("isbn"));
                publication.setUrl(sqlRow.getString("url"));
                publication.setVolume(sqlRow.getString("volume"));
                publication.setPages(sqlRow.getString("pages"));
                publication.setMdate(sqlRow.getString("mdate"));
                publication.setSeries(sqlRow.getString("series"));
                publication.setPublisher(sqlRow.getString("publisher"));
                publication.setBooktitle(sqlRow.getString("booktitle"));
                publication.setCrossref(sqlRow.getString("crossref"));
                publication.setEe(sqlRow.getString("ee"));
                publication.setId(sqlRow.getLong("publication_id"));
                ArrayList<Author> authors = new ArrayList<Author>();
                Author author = new Author(sqlRow.getString("name"));
                author.setId(sqlRow.getLong("id"));
                authors.add(author);
                PublicationWithAuthors pwa = new PublicationWithAuthors(publication, authors);
                results.add(pwa);
            }else {
                Author author = new Author(sqlRow.getString("name"));
                author.setId(sqlRow.getLong("id"));
                results.get(results.size()-1).authors.add(author);
            }

        }
        return results;
    }

    public class PublicationWithAuthors{
        private Publication publication;
        private ArrayList<Author> authors;
        public PublicationWithAuthors(){
            publication = new Publication();
            authors = new ArrayList<Author>();
        }

        public PublicationWithAuthors(Publication publication, ArrayList<Author> authors){
            this.publication = publication;
            this.authors = authors;
        }

        public ArrayList<Author> getAuthors() {
            return authors;
        }

        public void setAuthors(ArrayList<Author> authors) {
            this.authors = authors;
        }

        public Publication getPublication() {
            return publication;
        }

        public void setPublication(Publication publication) {
            this.publication = publication;
        }
    }
}
