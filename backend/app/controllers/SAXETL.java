package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;

import org.xml.sax.SAXException;

/**
 * Author: Lunwen He
 * Date: 04/02/2016
 * */

/**
 * This class extracts, transfers, and loads data from dblp.xml
 * into MySQL database. It uses SAX as the parser since it's an
 * event based parser and doesn't need to load all dblp.xml into
 * memory. In consideration of the volume of data set, we choose
 * SAX as parser instead of DOM.
 * Reference: 
 * https://www.javacodegeeks.com/2013/05/parsing-xml-using-dom-sax-and-stax-parser-in-java.html#sax
 * */

public class SAXETL {
	
	public static void loadData() {
	    SAXParserFactory parserFactor = SAXParserFactory.newInstance();
	    SAXParser parser;
		try {
			parser = parserFactor.newSAXParser();
			SAXHandlerForParsing handler = new SAXHandlerForParsing();
		    parser.parse(new FileInputStream(new File("./data/publications.xml")), handler);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
}