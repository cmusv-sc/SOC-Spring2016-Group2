package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.avaje.ebean.Model;


@Entity(name="post_comment")
public class PostComment extends Model {
	@Id
	public Long id;
	
	public long postId;
	
	public long commentId;
	
	public PostComment() {
		
	}
	
	public PostComment(long postId, long commentId) {
		this.postId = postId;
		this.commentId = commentId;
	}
	
	public static Finder<Long,PostComment> find = new Finder(Long.class, PostComment.class);

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getpostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}
}
