package models;

import java.util.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "authorId", referencedColumnName = "id")
    public User author;
    
    /* if the post is a question */
    public boolean isQueustion;
    
    /* post created at */
    @Column(columnDefinition = "datetime")
    public Timestamp postAt;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy="owner")
    public List<Comment> comments;

    public static Finder<Long, Post> find = new Finder<Long, Post>(Post.class);
    
    public Post() {
    }
    
    public Post(
    		String title, 
    		String content, 
    		User author, 
    		boolean isQuestion, 
    		Timestamp postAt
    		) {
    	this.title = title;
    	this.content = content;
    	this.author = author;
    	this.isQueustion = isQuestion;
    	this.postAt = postAt;
    	this.comments = new ArrayList<Comment>();
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

	public User getAuthor() {
		return author;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", content=" + content + ", author=" + author + ", isQueustion="
				+ isQueustion + ", postAt=" + postAt + "]";
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Timestamp getPostAt() {
		return postAt;
	}

	public void setPostAt(Timestamp postAt) {
		this.postAt = postAt;
	}

	public boolean isQueustion() {
		return isQueustion;
	}

	public void setQueustion(boolean isQueustion) {
		this.isQueustion = isQueustion;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public static Finder<Long, Post> getFind() {
		return find;
	}

	public static void setFind(Finder<Long, Post> find) {
		Post.find = find;
	}
	
	
}
