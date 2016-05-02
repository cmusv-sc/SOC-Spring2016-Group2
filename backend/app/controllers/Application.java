package controllers;

import java.io.File;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import models.*;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;


import java.io.IOException;
import com.avaje.ebean.Ebean;
import com.avaje.ebean.Model;
import com.avaje.ebean.SqlRow;

import static controllers.keyWordSearch.search;
import static play.data.Form.form;
import static play.libs.Json.toJson;
import java.io.IOException;
import java.util.*;
import static controllers.keyWordSearch.search;

public class Application extends Controller {
    static{
        // // TEST
        // // (Long id, Long followerId, Long followeeId, String category, Date timestamp)
        // Subscription subscription=new Subscription(null,new Long(1),new Long(11),"user",new Date());
        // subscription.save();
        // subscription=new Subscription(null,new Long(1),new Long(12),"paper",new Date());
        // subscription.save();
        // subscription=new Subscription(null,new Long(1),new Long(13),"group",new Date());
        // subscription.save();
    }




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
     *=======================================================
     * Paper suggestion
     */
    public void setHeaders(){
        response().setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE");
        response().setHeader("Access-Control-Max-Age", "3600");
        response().setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content- Type, Accept, Authorization, X-Auth-Token");
        response().setHeader("Access-Control-Allow-Credentials", "true");
        response().setHeader("Access-Control-Allow-Origin", "*");
    }

    public Result getPaperByYear(int year) {

        setHeaders();

        System.out.println(year);
        List<ObjectNode> results=new ArrayList<ObjectNode>();
        List<Publication> publications = Publication.find("byYear", year, null,null);
        System.out.println("There are " + publications.size() + " publication"+year);
        results=Publication.findPubDetails(publications,results,"getPaperByYear");

        Collections.sort(results, new Comparator<ObjectNode>(){
            public int compare(ObjectNode o1, ObjectNode o2){
                     String o1_pop=o1.get("popularity").toString();
                     String o2_pop=o2.get("popularity").toString();
                    return Integer.parseInt(o2_pop)-Integer.parseInt(o1_pop);
            }
        });
        return ok(Json.toJson(results));
    }
    public Result getPaperByTitle(String title){

        setHeaders();
        List<Publication> publications = Publication.find("byTitle", null, title,null);

        List<ObjectNode> results=new ArrayList<ObjectNode>();
        System.out.println("There are " + publications.size() );
        results=Publication.findPubDetails(publications,results,"getPaperByTitle");
        return ok(Json.toJson(results));
    }




    public Result getPaperBykeyWord(String keyword) throws IOException {
        setHeaders();
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
        setHeaders();
        //get all publications details
        List<ObjectNode> results=new ArrayList<ObjectNode>();
        List<Publication> publications=Publication.find.all();
        results=Publication.findPubDetails(publications,results,"getAllPaper");
        JsonNode jsonNode=Json.toJson(results);
        return ok(jsonNode);
    }
    public Result getAuthors(String author){
        setHeaders();
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
        results=Publication.findPubDetails(publications,results, "getAuthors");
        JsonNode jsonpObject=Json.toJson(results);
        return ok(jsonpObject);
    }

    public Result getCoAuthors(String author){
        setHeaders();
        //1. get the author id by its name
        List<Long>  author_ids=Author.find_Author_Id(author);
        System.out.println(author_ids);
        //2. find publication id by author id
        List<Long> pubids=PublicationAuthor.find_pub_id(author_ids);
        System.out.println(pubids.toString());
        //3. find publications by its id
        List<Publication> publications=Publication.find("byId",null,null,pubids);
        System.out.println(publications);
        //4. find
        List<ObjectNode> results=new ArrayList<ObjectNode>();
        results=Publication.findPubDetails(publications,results, "getCoAuthors");
        //get 5 co authors
        List<String> coauthors=new ArrayList<String>();
        for(ObjectNode result:results){

            String authors= result.findValue("authors").toString();
            String[] res=authors.split("(;|\")");
            for(String r:res){
                coauthors.add(r);
            }
        }
        System.out.println(coauthors);
        ObjectNode result = Json.newObject();
        result.put("GsearchResultClass","getCoauthors");
        List<ObjectNode> result_json=new ArrayList<ObjectNode>();
        int index=coauthors.size();
        if(coauthors.size()>8){
            index=6;
        }
        for(int i=1;i<index;i++){
            result.put("a"+i,coauthors.get(i));

        }
        result_json.add(result);
        return ok(Json.toJson(result_json));
    }
    /***
     * paper suggestion
     * =========================================================================
     */

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
