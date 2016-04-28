package controllers;
import com.avaje.ebean.*;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.*;
import play.libs.Json;
import play.mvc.*;

import java.util.*;

import static play.libs.Json.toJson;


public class Popularity extends Controller {

    public Result getCommentSum(int rootid) {
        List<Comment> comments = Comment.find.where().eq("rootid", rootid).findList();
        return ok(String.valueOf(comments.size()));
    }
    public Result getTagSum(Long pubid){
        List<Tagpub> tags = Tagpub.findwithpublication.where().eq("pub_id",pubid).findList();
        return ok(String.valueOf(tags.size()));
    }
    public void setHeaders(){
        System.out.println("Set Header");
        response().setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE");
        response().setHeader("Access-Control-Max-Age", "3600");
        response().setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content- Type, Accept, Authorization, X-Auth-Token");
        response().setHeader("Access-Control-Allow-Credentials", "true");
        response().setHeader("Access-Control-Allow-Origin", "*");

    }
    public Result getPopularityByYear(int year) {

        setHeaders();

        List<ObjectNode> results=new ArrayList<ObjectNode>();
        List<Publication> publications = Publication.find("byYear", year, null,null);
        System.out.println("There are " + publications.size() + " publication"+year);
        results=Publication.findPubDetails(publications,results,"getPopularityByYear");

        Collections.sort(results, new Comparator<ObjectNode>(){
            public int compare(ObjectNode o1, ObjectNode o2){
                String o1_pop=o1.get("popularity").toString();
                String o2_pop=o2.get("popularity").toString();
                return Integer.parseInt(o2_pop)-Integer.parseInt(o1_pop);
            }
        });
        return ok(Json.toJson(results));
    }

    public void findrootidandcounts(int year){
        String sql = "SELECT\n" +
                " rootid, \n" +
                " count(1) AS counts \n" +
                "FROM\n" +
                "comment\n" +
                "GROUP BY\n" +
                "rootid";

        List<SqlRow> sqlRows = Ebean.createSqlQuery(sql).findList();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < sqlRows.size(); i++) {
            SqlRow sqlRow = sqlRows.get(i);

            map.put(Integer.valueOf(sqlRow.getString("rootid")),Integer.valueOf(sqlRow.getString("counts")));
        }
        int value=0;
        String maxKey = null;
        List list=new ArrayList();

        Iterator ite=map.entrySet().iterator();
        while(ite.hasNext()){
            Map.Entry entry =(Map.Entry)ite.next();
            value = Integer.parseInt(entry.getValue().toString());
            list.add(entry.getValue());
            Collections.sort(list);

            if(value == Integer.parseInt(list.get(list.size()-1).toString())){
                maxKey = entry.getKey().toString();
            }
        }

    }

    public Result getMostPopularity(){
        String sql = "SELECT\n" +
                " rootid, \n" +
                " count(1) AS counts \n" +
                "FROM\n" +
                "comment\n" +
                "GROUP BY\n" +
                "rootid";

        List<SqlRow> sqlRows = Ebean.createSqlQuery(sql).findList();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < sqlRows.size(); i++) {
            SqlRow sqlRow = sqlRows.get(i);

            map.put(Integer.valueOf(sqlRow.getString("rootid")),Integer.valueOf(sqlRow.getString("counts")));
        }
        int value=0;
        String maxKey = null;
        List list=new ArrayList();

        Iterator ite=map.entrySet().iterator();
        while(ite.hasNext()){
            Map.Entry entry =(Map.Entry)ite.next();
            value = Integer.parseInt(entry.getValue().toString());
            list.add(entry.getValue());
            Collections.sort(list);

            if(value == Integer.parseInt(list.get(list.size()-1).toString())){
                maxKey = entry.getKey().toString();
            }
        }
        List<Publication> publications = Publication.find.where().eq("pub_id", maxKey).findList();
        String sql1 = "select * "+
                "from publication as p join" +
                " (select pa.publication_id, a.id, a.name from publication_author as pa join author as a where pa.author_id=a.id) as t" +
                " where p.pub_id=t.publication_id and p.pub_id=" + maxKey;
        //getPublicationWithAuthorsById(Integer.parseInt(maxKey));

        return ok(toJson(joinPublicationAndAuthor(sql1)));
    }

    public Result getPublicationWithAuthorsById(int id){
        String sql = "select * "+
                "from publication as p join" +
                " (select pa.publication_id, a.id, a.name from publication_author as pa join author as a where pa.author_id=a.id) as t" +
                " where p.pub_id=t.publication_id and p.pub_id=" + id;
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

    public Result getAuthorPopularity(String author){

        List<Publication> publications = Publication.find.where().eq("author", author).findList();
        return ok();
    }

}
