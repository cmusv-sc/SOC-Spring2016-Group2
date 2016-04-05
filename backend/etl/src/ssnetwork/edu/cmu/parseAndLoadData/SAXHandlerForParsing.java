package ssnetwork.edu.cmu.parseAndLoadData;

import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import ssnetwork.edu.cmu.article.Article;
import ssnetwork.edu.cmu.conferenceKey.ConferenceKey;
import ssnetwork.edu.cmu.insert.InsertArticle;
import ssnetwork.edu.cmu.insert.InsertArticleAuthor;
import ssnetwork.edu.cmu.insert.InsertAuthor;

/**
 * Author: Lunwen He
 * Date: 04/04/2016
 * */

/**
 * The Handler for SAX Events.
 */
public class SAXHandlerForParsing extends DefaultHandler {
  
  private Article article = null;
  private String content = null;
  
  /* insert article */
  private InsertArticle insertArticle = new InsertArticle();
  /* insert author */
  private InsertAuthor insertAuthor = new InsertAuthor();
  /* insert <article_id, author_id> */
  private InsertArticleAuthor insertArticleAuthor = new InsertArticleAuthor();
  
  
  @Override
  /* Triggered when the start tag <article> is found. */
  public void startElement(
		  String uri, 
		  String localName, 
		  String qName, 
		  Attributes attributes
		  ) throws SAXException {

      /* Create a new Article object when the start tag of <article> is found */
	  if(qName.equals("article")) {
	        article = new Article();
	        article.setMdate(attributes.getValue("mdate"));
	        article.setKey(attributes.getValue("key"));		  
	  }
  }

  @Override
  /* Triggered when an end tag is found. */
  public void endElement(
		  String uri, 
		  String localName, 
		  String qName
		  ) throws SAXException {
   switch(qName) {
   /* find an end tag of article
    * insert into database
    * */
   	   case "article":
   		   if(ConferenceKey.isWanted(article.getKey())){
   	   		   int article_id = insertArticle.insertArticle(article);
   	   		   if(article_id < 0) {
   	   			   System.out.println("insert article failed");
   	   			   System.out.println(article.toString());
   	   		   } else {
   	   			   List<String> authors = article.getAuthors();
   	   			   for(String author : authors) {
   	   				   int author_id = insertAuthor.insertAuthor(author);
   	   				   if(author_id < 0) {
   	   					   System.out.println("insert " + author + " failed");
   	   					   continue;
   	   				   }
   	   				   int articleAuthor_id = insertArticleAuthor.insertArticle(article_id, author_id);
   	   				   if(articleAuthor_id < 0) {
   	   					   System.out.println("insert <" + article_id + ", " + author_id + "> failed");
   	   				   }
   	   			   }
   	   		   }
   		   }
   		   break;
       case "title":
    	   article.setTitle(content);
    	   break;
       case "author":
    	   article.addAuthors(content);    
    	   break;
       case "pages":
    	   article.setPages(content);
    	   break;
       case "year":
    	   article.setYear(content);
    	   break;
       case "volume":
    	   article.setVolume(content);
    	   break;
       case "journal":
    	   article.setJournal(content);
    	   break;
       case "number":
    	   article.setNumber(content);
    	   break;
       case "url":
    	   article.setUrl(content);
    	   break;
       case "ee":
    	   article.setEe(content);
    	   break;
       default:
    	   break;
   }
 }

  @Override
  public void characters(char[] ch, int start, int length) 
          throws SAXException {
    content = String.copyValueOf(ch, start, length).trim();
  }
  
  /* close database related resources */
  public void closeResources() {
	  this.insertArticle.closeResources();
	  this.insertArticleAuthor.closeResources();
	  this.insertAuthor.closeResources();
  }
}