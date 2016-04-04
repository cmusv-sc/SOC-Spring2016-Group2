package ssnetwork.edu.cmu.mysqlStatement;

/**
 * Author: Lunwen He
 * Date: 04/04/2016
 * */

/**
 * This class defines MySQL statement will be used when
 * inserting into or selecting from database
 * */
public class MySQLStatement {

	/* insert an article record into article_table */
	public static String insertArticle = "insert into article_table "
			+ "(title, mdate, keyword, pages, year, volume, journal, number, url, ee)"
			+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	/* insert an author record into author_table */
	public static String insertAuthor = "insert into author_table"
			+ "(author)"
			+ " values (?)";
	
	/* insert an <article_id, author_id> into article_author_table */
	public static String insertArticleAuthor = "insert into article_author_table "
			+ "(article_id, author_id)"
			+ " values (?, ?)";
}
