package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.avaje.ebean.Model;


@Entity(name="post_comment")
public class PostComment extends Model {
	@Id
	public Long id;
	
	public long publicationId;
	
	public long authorId;
	
	public PostComment() {
		
	}
	
	public PostComment(long publicationId, long authorId) {
		this.publicationId = publicationId;
		this.authorId = authorId;
	}
	
	public static Finder<Long,PostComment> find = new Finder(Long.class, PostComment.class);

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getPublicationId() {
		return publicationId;
	}

	public void setPublicationId(long publicationId) {
		this.publicationId = publicationId;
	}

	public long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}
}
