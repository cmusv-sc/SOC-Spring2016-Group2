package ssnetwork.edu.cmu.insert;

import java.sql.Connection;
import java.sql.PreparedStatement;

import ssnetwork.edu.cmu.dbConfig.DBConfig;

/**
 * Author: Lunwen He
 * Date: 04/04/2016
 * */

/**
 * This class insert one article into article_table
 * */
public class InsertArticle {

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	private static final String DB_URL = "jdbc:mysql://localhost/article";
	
	private static final String USER = DBConfig.USER;
	private static final String PASS = DBConfig.PASS;
	
	private static Connection conn = null;
	private static PreparedStatement stmtCoAuthor = null;
	private static PreparedStatement stmtArticle = null;
	private static PreparedStatement stmtArticleAuthor = null;
}
