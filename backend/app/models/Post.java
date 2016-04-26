package models;

import java.sql.Timestamp;
import java.util.*;
import javax.persistence.*;
import com.avaje.ebean.Model;
/**
 * This class defines one post
 * */
@Entity(name="post")
public class Post extends Model {
    @Id
    @Column(name="post_id")
    public Long id;

    /* the title of the post */
    public String title;

    /* the content of post */
    public String content;
    
    /* the author of post */
    public Long authorId;
    
    /* if the post is a question */
    public boolean isQueustion;
    
    /* if the post is a question, answerId 
     * is the id of comment which is set as answer
     * */
    public Long answerId;
    
    /* post created at */
    @Column(columnDefinition = "datetime")
    public Date postAt;

    public static Finder<Long, Post> find = new Finder<Long, Post>(Post.class);
    
    public Post() {
    }
    
    public Post(
    		String title, 
    		String content, 
    		Long authorId,  
    		Date postAt

    		) {
    	this.title = title;
    	this.content = content;
    	this.authorId = authorId;
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

	public Date getPostAt() {
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

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public Long getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}

	
	//=====================tagging=================
	//I also changed the id's column name as post_id, please contact me
	//if there is any conflict that I may have caused you
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	public List<Tagpost> tagposts;

	public List<Tagpost> getTagposts() {
		return tagposts;
	}

	public void setTagposts(List<Tagpost> tagposts) {
		this.tagposts = tagposts;
	}

	//============tagging===================
}
