package ssnetwork.edu.cmu.getLengthOfAttributes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;

import org.xml.sax.SAXException;

import ssnetwork.edu.cmu.filepath.FilePath;



/**
 * Author: Lunwen He
 * Date: 04/02/2016
 * */

/**
 * This class gets the max length for each article's attributes. 
 * It uses SAX as the parser since it's an event based parser 
 * and doesn't need to load all dblp.xml into memory. In 
 * consideration of the volume of data set, we choose
 * SAX as parser instead of DOM.
 * Reference: 
 * https://www.javacodegeeks.com/2013/05/parsing-xml-using-dom-sax-and-stax-parser-in-java.html#sax
 * */

public class GetMaxLengthOfAttrributes {
	public static void main(String[] args) {
	    SAXParserFactory parserFactor = SAXParserFactory.newInstance();
	    SAXParser parser;
		try {
			parser = parserFactor.newSAXParser();
			org.apache.xerces.util.SecurityManager manager = new org.apache.xerces.util.SecurityManager();
            /* here we set the max entity expansion limit of sax parser to 5000000 */
            manager.setEntityExpansionLimit(5000000);
            parser.setProperty("http://apache.org/xml/properties/security-manager", manager);
			SAXHandlerForGettingAttributesLength handler = new SAXHandlerForGettingAttributesLength();
		    parser.parse(new FileInputStream(new File(FilePath.DATAFILEPATH)), handler);
		    System.out.println(handler.getAttributeLength());
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
}
