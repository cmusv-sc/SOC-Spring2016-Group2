package ssnetwork.edu.cmu.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ssnetwork.edu.cmu.dbConfig.DBConfig;
import ssnetwork.edu.cmu.mysqlStatement.MySQLStatement;

/**
 * Author: Lunwen He
 * Date: 04/04/2016
 * */

/**
 * This class insert one author into author_table
 * */

public class InsertAuthor {
	
	private static Connection conn = null;
	/* statement for inserting an author */
	private static PreparedStatement insertStatement = null;
	/* statement for selecting an author*/
	private static PreparedStatement selectStatement = null;
	
	/**
	 * setup database connection and prepare statements
	 * */
	public InsertAuthor() {
		try {
			Class.forName(DBConfig.JDBC_DRIVER);
			conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.USER, DBConfig.PASS);
			insertStatement = conn.prepareStatement(MySQLStatement.insertAuthor);
			selectStatement = conn.prepareStatement(MySQLStatement.selectAuthor);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Insert an author into author_table
	 * @param author	
	 * 		  the name of author
	 * 
	 * @return the id of inserted author if inserted successfully;
	 * 			otherwise, return -1
	 * */
	public int insertAuthor(String author) {
		try {
			selectStatement.setString(1, author);
			ResultSet resultSet = selectStatement.executeQuery();
			if(resultSet.next()) {
				return resultSet.getInt(1);
			}
			insertStatement.setString(1, author);
			insertStatement.executeUpdate();
			ResultSet generatedKeys = insertStatement.getGeneratedKeys();
			if(generatedKeys.next()) {
				return generatedKeys.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * This method close all database related resources. Please remember to call
	 * this function after using InsertAuthor
	 * */
	public void closeResources() {
		try {
			if(insertStatement != null) {
				insertStatement.close();	
			}
			if(selectStatement != null) {
				selectStatement.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	/* this is for testing InsertAuthor */	
	public static void main(String[] args) {
		InsertAuthor insertAuthor = new InsertAuthor();
		System.out.println(insertAuthor.insertAuthor("AA"));
		System.out.println(insertAuthor.insertAuthor("AA"));
		System.out.println(insertAuthor.insertAuthor("B"));
		insertAuthor.closeResources();
	}
}
