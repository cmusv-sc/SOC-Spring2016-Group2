package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import org.junit.Test;

import models.*;

public class Application extends Controller {

	/* here we provide some simple methods
	 * to show how to use database model
	 * */
	private static void selectByYear() {
		List<Publication> publications = Publication.find("byYear", "2011").fetch();
		System.out.println("There are " + publications.size() + " publication in 2011");
		for(Publication publication : publications) {
			System.out.println(publication.toString());
		}
	}
	
	private static void selectByTitle() {
		Publication publication = Publication.find("byTitle", "SaaS Architecture and Pricing Models.").first();
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
    	selectByYear();
    	selectByTitle();
        render();
    }
}