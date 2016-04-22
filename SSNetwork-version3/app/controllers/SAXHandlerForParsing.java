package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Author;
import models.Publication;
import models.PublicationAuthor;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Author: Lunwen He
 * Date: 04/04/2016
 * */

/**
 * The Handler for SAX Events.
 */
public class SAXHandlerForParsing extends DefaultHandler {
  
  private String content = null;  
  private Publication publication;
  private List<Author> authors = new ArrayList<Author>();
 
  private int count = 1;
  
  @Override
  /* Triggered when the start tag <article> is found. */
  public void startElement(
		  String uri, 
		  String localName, 
		  String qName, 
		  Attributes attributes
		  ) throws SAXException {
	  
      /* Create a new Article object when the start tag of <article> is found */
	  if(qName.equals("proceedings") || qName.equals("inproceedings")) {
		  System.out.println("Inserting: " + count++);
		  this.publication = new Publication();
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
   case "proceedings":
   case "inproceedings":
	   publication.save();
	   Long publicationID = publication.id;
	   for(Author author : this.authors) {
		   new PublicationAuthor(publicationID, author.id).save();
	   }
	   this.authors.clear();
	   break;
   case "author":
	   Author author = new Author(content);
	   author.save();
	   this.authors.add(author);
	   break;
   case "key": 
	   publication.setPubkey(content);
	   break;
   case "title":
	   publication.setTitle(content);
	   break;
   case "editor":
	   publication.setEditor(content);
	   break;
   case "year":
	   publication.setYear(content);
	   break;
   case "isbn":
	   publication.setIsbn(content);
	   break;
   case "url":
	   publication.setUrl(content);
	   break;
   case "volume":
	   publication.setVolume(content);
	   break;
   case "pages":
	   publication.setPages(content);
	   break;
   case "mdate":
	   publication.setMdate(content);
	   break;
   case "series":
	   publication.setSeries(content);
	   break;
   case "publisher":
	   publication.setSeries(content);
	   break;
   case "booktitle":
	   publication.setPubkey(content);
	   break;
   case "crossref":
	   publication.setCrossref(content);
	   break;
   case "ee":
	   publication.setEe(content);
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
  
}