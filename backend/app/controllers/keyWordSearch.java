package controllers;

/**
 * Created by caoyi on 4/13/16.
 */

import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Author;
import models.Publication;
import models.PublicationAuthor;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;


import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static play.mvc.Results.ok;

/***
 * This class is used to search all results by keywords
 */
public class keyWordSearch extends Controller{

    private static IndexWriter indexWriter=null;
    private static Directory indexDir=null;
    public keyWordSearch(IndexWriter indexWriter,Directory indexDir){
        this.indexWriter=indexWriter;
        this.indexDir=indexDir;
    }
    public static IndexWriter getIndexWriter(boolean create) throws IOException {

        File files=new File("./indexFile");
        for(File file:files.listFiles()){
            file.delete();
        }
        indexDir= FSDirectory.open(files.toPath());
        Analyzer analyzer=new StandardAnalyzer();
        IndexWriterConfig iwc=new IndexWriterConfig(analyzer);
        indexWriter=new IndexWriter(indexDir,iwc);
        return indexWriter;
    }
    public static void closeIndexWriter() throws IOException{

        indexWriter.close();

    }
    public static void indexTitle(String title,IndexWriter writer) throws IOException{
        //System.out.println("Indexing title: "+title);
        Document document=new Document();
        document.add(new TextField("All",title,Field.Store.YES));
        writer.addDocument(document);
    }
    public static void indexAuthor(String author,IndexWriter writer) throws IOException{
        //System.out.println("Indexing author: "+author);
        Document document=new Document();
        document.add(new TextField("All",author, Field.Store.YES));
        writer.addDocument(document);
    }

    public static void rebuildIndexes(IndexWriter indexWriter) throws IOException {

        List<Publication> publications=Publication.findAll();
        List<String> titles=new ArrayList<String>();
        List<Author>  authors=new ArrayList<Author>();
        for(Publication publication:publications){
            titles.add(publication.getTitle());
        }
        authors=Author.findAll();
        for(Author author:authors){
            indexAuthor(author.getName(),indexWriter);
        }

        for(String title:titles){
            indexTitle(title,indexWriter);
        }
        closeIndexWriter();
    }

    public static void search(String queryStr,int num, List<ObjectNode> results) throws IOException, ParseException, ParseException {
        QueryParser parser=new QueryParser("All", new StandardAnalyzer());
        Directory directory=FSDirectory.open(Paths.get("./indexFile"));
        IndexReader reader= DirectoryReader.open(directory);
        IndexSearcher searcher=new IndexSearcher(reader);
        Query query=parser.parse(queryStr);
        TopDocs docs=searcher.search(query, num);
        System.out.println("the number of results: "+docs.totalHits);
        for (ScoreDoc scoreDoc : docs.scoreDocs)
        {
//            ObjectNode result = Json.newObject();
            Document document = searcher.doc(scoreDoc.doc);
            //1. if keyword is Title name
            List<Publication> publications=Publication.find(null,null,document.get("All"),null);
//            System.out.println("size:"+publications.size());
            List<ObjectNode> buffresults=new ArrayList<ObjectNode>();

            buffresults=Publication.findPubDetails(publications,buffresults,"getPaperByKeyWord");

            results.addAll(buffresults);
        }
        System.out.println("=====================================");
        List<String> keywords=new ArrayList<String>();
        for (ScoreDoc scoreDoc : docs.scoreDocs)
        {
            //if keyword is author name
            Document document = searcher.doc(scoreDoc.doc);
            if(!keywords.contains(document.get("All"))) {
                keywords.add(document.get("All"));
                System.out.println("score:"+scoreDoc.score);
                //1. get the author id by its name
                List<Long> author_ids = Author.find_Author_Id(document.get("All"));
                //2. find publication id by author id
                List<Long> pubids = PublicationAuthor.find_pub_id(author_ids);
                //3. find publications by its id
                List<Publication> publications = Publication.find("byId", null, null, pubids);
                List<ObjectNode> buffresults = new ArrayList<ObjectNode>();
                buffresults = Publication.findPubDetails(publications, buffresults,"getPaperByKeyWord");
                results.addAll(buffresults);
            }
        }

    }

}
