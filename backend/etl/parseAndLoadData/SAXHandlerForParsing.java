import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * The Handler for SAX Events.
 */
public class SAXHandlerForParsing extends DefaultHandler {
  
  private Article article = null;
  private String content = null;
  
  @Override
  /* Triggered when the start tag <article> is found. */
  public void startElement(
		  String uri, 
		  String localName, 
		  String qName, 
		  Attributes attributes
		  ) throws SAXException {

      //Create a new Article object when the start tag of <article> is found
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
	  
   switch(qName){
     case "article":
       System.out.println(article.toString());       
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
}