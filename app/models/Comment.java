package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.avaje.ebean.Model;


/**
 * This class defines one comment
 * */
@Entity(name="post")
public class Comment extends Model {

    @Id
	public Long id;
    
    /* when does the comment created */
    public Date commentAt;
    
    /* who created this comment */
    public String commentBy;
    
    /* the content of this comment */
    public String content;
    
    /* the post this comment belongs to */
    @ManyToOne
    public Post post;
    
    /* when the post is a question,
     * if this comment is selected as answer
     **/
    public boolean isAnswer;
    
    public static Finder<Long, Comment> find = new Finder<Long, Comment>(Comment.class);
    
    public Comment() {
    	this.commentAt = new Date();
    	this.commentBy = "";
    	this.post = null;
    	this.content = "";
    	this.isAnswer = false;
    }
    
    public Comment(
    		Date commentAt,
    		String commentBy,
    		String content,
    		Post post,
    		boolean isAnswer
    		) {
    	this.commentAt = commentAt;
    	this.commentBy = commentBy;
    	this.content = content;
    	this.post = post;
    	this.isAnswer = isAnswer;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCommentAt() {
		return commentAt;
	}

	public void setCommentAt(Date commentAt) {
		this.commentAt = commentAt;
	}

	public String getCommentBy() {
		return commentBy;
	}

	public void setCommentBy(String commentBy) {
		this.commentBy = commentBy;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public boolean isAnswer() {
		return isAnswer;
	}

	public void setAnswer(boolean isAnswer) {
		this.isAnswer = isAnswer;
	}

	public static Finder<Long, Comment> getFind() {
		return find;
	}

	public static void setFind(Finder<Long, Comment> find) {
		Comment.find = find;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", commentAt=" + commentAt + ", commentBy=" + commentBy + ", content=" + content
				+ ", post=" + post + ", isAnswer=" + isAnswer + "]";
	}
}
