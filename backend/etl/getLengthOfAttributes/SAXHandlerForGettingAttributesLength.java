import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * The Handler for SAX Events.
 */
public class SAXHandlerForGettingAttributesLength extends DefaultHandler {
  
  private String content = null;
  private AttributeLength attributeLength = new AttributeLength();
  
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
	        attributeLength.setMdateLength(attributes.getValue("mdate").length());
	        attributeLength.setKeyLength(attributes.getValue("key").length());
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
    	 break;
     case "title":
    	 attributeLength.setTitleLength(content.length());
    	 break;
     case "author":
    	 attributeLength.setauthorLength(content.length());
    	 break;
     case "pages":
    	 attributeLength.setPagesLength(content.length());
    	 break;
     case "year":
    	 attributeLength.setYearLength(content.length());
    	 break;
     case "volume":
    	 attributeLength.setVolumeLength(content.length());
    	 break;
     case "journal":
    	 attributeLength.setJournalLength(content.length());
    	 break;
     case "number":
    	 attributeLength.setNumberLength(content.length());
    	 break;
     case "url":
    	 attributeLength.setUrlLength(content.length());
    	 break;
     case "ee":
    	 attributeLength.setEeLength(content.length());
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
  
  public String getAttributeLength() {
	  return this.attributeLength.toString();
  }
}