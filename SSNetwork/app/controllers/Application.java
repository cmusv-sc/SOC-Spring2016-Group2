package controllers;

import play.*;
import play.mvc.*;
import play.mvc.results.Result;

import java.util.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;

import models.*;

public class Application extends Controller {

	/* here we provide some simple methods
	 * to show how to use database model
	 * */
	
	private static Result selectByYear(String year) {
		
		List<Publication> publications = Publication.find("byYear",year).fetch();
		System.out.println("There are " + publications.size() + " publication in 2011");
		for(Publication publication : publications) {
			
			System.out.println(publication.toString());
			// ObjectNode result = Json.newObject();
		}
		return null;
	}
	
	private static void selectByTitle(String title) {
		Publication publication = Publication.find("byTitle", title).first();
		System.out.println(publication.toString());	
	}
	
    public static void index() {
    	/* 
    	 * from here we load data into database,
    	 * once we finish loading data, we don't 
    	 * need this anymore. Before running this,
    	 * please configure your database at application.conf
    	 * */
    	SAXETL.loadData();
    	System.out.println("Data load successfully!");
        render();
    }
}