package ssnetwork.edu.cmu.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ssnetwork.edu.cmu.article.Article;
import ssnetwork.edu.cmu.dbConfig.DBConfig;
import ssnetwork.edu.cmu.mysqlStatement.MySQLStatement;

/**
 * Author: Lunwen He
 * Date: 04/04/2016
 * */

/**
 * This class insert one article into article_table
 * */
public class InsertArticle {
	
	private static final String USER = DBConfig.USER;
	private static final String PASS = DBConfig.PASS;
	
	private static Connection conn = null;
	private static PreparedStatement statement = null;
	
	/**
	 * setup database connection and prepare insert statement
	 * */
	public InsertArticle() {
		try {
			Class.forName(DBConfig.JDBC_DRIVER);
			conn = DriverManager.getConnection(DBConfig.DB_URL, USER, PASS);
			statement = conn.prepareStatement(MySQLStatement.insertArticle);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Insert an article into article_table
	 * @param article	
	 * 		  the article to be inserted into database
	 * 
	 * @return the id of inserted article if insert successfully;
	 * 			otherwise, return -1
	 * */
	public int insertArticle(Article article) {
		try {
			statement.setString(1, article.getTitle());
			statement.setString(2, article.getMdate());
			statement.setString(3, article.getKey());
			statement.setString(4, article.getPages());
			statement.setString(5, article.getYear());
			statement.setString(6, article.getVolume());
			statement.setString(7, article.getJournal());
			statement.setString(8, article.getNumber());
			statement.setString(9, article.getUrl());
			statement.setString(10, article.getEe());
			statement.executeUpdate();
			ResultSet generatedKeys = statement.getGeneratedKeys();
			if(generatedKeys.next()) {
				return generatedKeys.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * This method close all database related resources. Please remember to call
	 * this function after using InsertArticle
	 * */
	public void closeResources() {
		if(statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/* this is for testing InsertArticle */
	/*public static void main(String[] args) {
		InsertArticle insertArticle = new InsertArticle();
		Article article = new Article();
		article.setTitle("title");
		article.setMdate("2011");
		article.setKey("key");
		article.setPages("pages");
		article.setYear("2011");
		article.setVolume("32");
		article.setJournal("journal");
		article.setNumber("32");
		article.setUrl("http://");
		article.setEe("ee");
		System.out.println(insertArticle.insertArticle(article));
		article = new Article();
		article.setTitle("title2");
		article.setMdate("2011");
		article.setKey("key");
		article.setPages("pages");
		article.setYear("2011");
		article.setVolume("32");
		article.setJournal("journal");
		article.setNumber("32");
		article.setUrl("http://");
		article.setEe("ee");
		System.out.println(insertArticle.insertArticle(article));
		insertArticle.closeResources();
	}*/
}
