package models;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
    //@Formats.DateTime(pattern="dd/MM/yyyy")
    //public Date commentAt;
    @Column(columnDefinition = "datetime")
    public Timestamp commentAt;
    
    /* who created this comment */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "authorId", referencedColumnName = "id")
    public User author;
    
    /* the content of this comment */
    public String content;
    
    /* when the post is a question,
     * if this comment is selected as answer
     **/
    public boolean isAnswer;
    
    /* the post it belongs to */
    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    public Post owner;
    
    public static Finder<Long, Comment> find = new Finder<Long, Comment>(Comment.class);
    
    public Comment() {
    }
    
    public Comment(
    		Timestamp commentAt,
    		User author,
    		String content,
    		boolean isAnswer,
    		Post owner
    		) {
    	this.commentAt = commentAt;
    	this.author = author;
    	this.content = content;
    	this.isAnswer = isAnswer;
    	this.owner = owner;
    }

	public Post getOwner() {
		return owner;
	}

	public void setOwner(Post owner) {
		this.owner = owner;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getCommentAt() {
		return commentAt;
	}

	public void setCommentAt(Timestamp commentAt) {
		this.commentAt = commentAt;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", commentAt=" + commentAt + ", author=" + author + ", content=" + content
				+ ", isAnswer=" + isAnswer + "]";
	}
}
