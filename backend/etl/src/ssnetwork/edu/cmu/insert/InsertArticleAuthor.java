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
 * This class insert one <article_id, author_id> into article_author_table
 * */
public class InsertArticleAuthor {
	
	private static Connection conn = null;
	private static PreparedStatement statement = null;
	
	/**
	 * setup database connection and prepare insert statement
	 * */
	public InsertArticleAuthor() {
		try {
			Class.forName(DBConfig.JDBC_DRIVER);
			conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.USER, DBConfig.PASS);
			statement = conn.prepareStatement(MySQLStatement.insertArticleAuthor);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Insert an <article_id, author_id> into article_table
	 * @param article_id
	 * 		  the article_id to be inserted into database
	 * 
	 * @param author_id
	 * 		  the author_id to be inserted into database
	 * 
	 * @return the id of inserted <article_id, author_id> if insert successfully;
	 * 			otherwise, return -1
	 * */
	public int insertArticle(int article_id, int author_id) {
		try {
			statement.setInt(1, article_id);
			statement.setInt(2, author_id);
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

	/* this is for test InsertArticleAuthor */
	public static void main(String[] args) {
		InsertArticleAuthor insertArticleAuthor = new InsertArticleAuthor();
		System.out.println(insertArticleAuthor.insertArticle(1, 1));
		System.out.println(insertArticleAuthor.insertArticle(1, 2));
		insertArticleAuthor.closeResources();
	}
}
