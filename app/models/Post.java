package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.avaje.ebean.Model;
import play.data.format.Formats;
/**
 * This class defines one post
 * */
@Entity(name="post")
public class Post extends Model {
    @Id
	public Long id;

    /* the title of the post */
    public String title;

    /* the content of post */
    public String content;
    
    /* the author of post */
    public String author;
    
    /* if the post is a question */
    public boolean isQueustion;
    
    /* post created at */
    @Formats.DateTime(pattern="dd/MM/yyyy")
    public Date postAt = new Date();

    public static Finder<Long, Post> find = new Finder<Long, Post>(Post.class);
    
    public Post() {
    	this.title = "";
    	this.content = "";
    	this.author = "";
    	this.isQueustion = false;
    	this.postAt = new Date();
    }
    
    public Post(
    		String title, 
    		String content, 
    		String author, 
    		boolean isQuestion, 
    		Date postAt
    		) {
    	this.title = title;
    	this.content = content;
    	this.author = author;
    	this.isQueustion = isQuestion;
    	this.postAt = postAt;
    }
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", content=" + content + ", author=" + author + ", isQueustion="
				+ isQueustion + ", postAt=" + postAt + "]";
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getPostAt() {
		return postAt;
	}

	public void setPostAt(Date postAt) {
		this.postAt = postAt;
	}

	public boolean isQueustion() {
		return isQueustion;
	}

	public void setQueustion(boolean isQueustion) {
		this.isQueustion = isQueustion;
	}
}
