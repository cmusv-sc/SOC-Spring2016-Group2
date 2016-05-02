package controllers;

/**
 * Created by guoqing on 16/4/21.
 */

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

    public Result getPopularityByYear(int year) {


        String sql = "SELECT\n" +
                " rootid, \n" +
                " count(1) AS counts \n" +
                "FROM\n" +
                "comment\n" +
                "GROUP BY\n" +
                "rootid";

        List<SqlRow> sqlRows1 = Ebean.createSqlQuery(sql).findList();
        // ArrayList<String> list = new ArrayList<String>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < sqlRows1.size(); i++) {
            SqlRow sqlRow = sqlRows1.get(i);
            map.put(Integer.valueOf(sqlRow.getString("rootid")),Integer.valueOf(sqlRow.getString("counts")));
        }

        String sqlyear = "SELECT pub_id FROM publication WHERE year="+year;
        HashMap<Integer, Integer> newmap = new HashMap<Integer, Integer>();
        List<SqlRow> sqlRows = Ebean.createSqlQuery(sqlyear).findList();
        for (int i = 0; i < sqlRows.size(); i++) {
            SqlRow sqlRow = sqlRows.get(i);
            for(int j=0;j < map.size();j++){
                if(map.containsKey(Integer.valueOf(sqlRow.getString("pub_id"))))
                    newmap.put(Integer.valueOf(sqlRow.getString("pub_id")),map.get(Integer.valueOf(sqlRow.getString("pub_id"))));
            }
        }
        int value=0;
        String maxKey = null;
        List list=new ArrayList();

        Iterator ite=newmap.entrySet().iterator();
        while(ite.hasNext()){
            Map.Entry entry =(Map.Entry)ite.next();
            value = Integer.parseInt(entry.getValue().toString());
            list.add(entry.getValue());
            Collections.sort(list);

            if(value == Integer.parseInt(list.get(list.size()-1).toString())){
                maxKey = entry.getKey().toString();
            }
        }

        String sql1 = "select * "+
                "from publication as p join" +
                " (select pa.publication_id, a.id, a.name from publication_author as pa join author as a where pa.author_id=a.id) as t" +
                " where p.pub_id=t.publication_id and p.pub_id=" + maxKey;
        //getPublicationWithAuthorsById(Integer.parseInt(maxKey));

        return ok(toJson(joinPublicationAndAuthor(sql1)));

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
        List list1=new ArrayList();

        Iterator ite=map.entrySet().iterator();
        while(ite.hasNext()){
            Map.Entry entry =(Map.Entry)ite.next();
            value = Integer.parseInt(entry.getValue().toString());
            System.out.print("");
            list1.add(entry.getValue());
            Collections.sort(list1);

            if(value == Integer.parseInt(list1.get(list1.size()-1).toString())){
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
            System.out.print("");
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

        String sql1 = "SELECT id FROM author WHERE name LIKE '"+author+"';";
        List<SqlRow> sqlRows1 = Ebean.createSqlQuery(sql1).findList();
        SqlRow sqlRow = sqlRows1.get(0);

        String sql2 = "SELECT publication_id FROM publication_author WHERE author_id="+Integer.valueOf(sqlRow.getString("id"))+";";
        List<SqlRow> sqlRows2 = Ebean.createSqlQuery(sql2).findList();
        HashMap<Integer, Integer> newmap = new HashMap<Integer, Integer>();

        for (int i = 0; i < sqlRows2.size(); i++) {
            SqlRow sqlRow2 = sqlRows2.get(i);
            for(int j=0;j < map.size();j++){
                if(map.containsKey(Integer.valueOf(sqlRow2.getString("publication_id"))))
                    newmap.put(Integer.valueOf(sqlRow2.getString("publication_id")),map.get(Integer.valueOf(sqlRow2.getString("publication_id"))));
            }
            //newmap.put(Integer.valueOf(sqlRow.getString("rootid")),Integer.valueOf(sqlRow.getString("counts")));
        }



        int value=0;
        String maxKey = null;
        List list=new ArrayList();

        Iterator ite=newmap.entrySet().iterator();
        while(ite.hasNext()){
            Map.Entry entry =(Map.Entry)ite.next();
            value = Integer.parseInt(entry.getValue().toString());
            list.add(entry.getValue());
            Collections.sort(list);
            System.out.print("");

            if(value == Integer.parseInt(list.get(list.size()-1).toString())){
                maxKey = entry.getKey().toString();
            }
        }

        String sql3 = "select * "+
                "from publication as p join" +
                " (select pa.publication_id, a.id, a.name from publication_author as pa join author as a where pa.author_id=a.id) as t" +
                " where p.pub_id=t.publication_id and p.pub_id=" + maxKey;
        //getPublicationWithAuthorsById(Integer.parseInt(maxKey));

        return ok(toJson(joinPublicationAndAuthor(sql3)));

    }

}
