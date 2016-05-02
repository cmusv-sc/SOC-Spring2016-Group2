package models;

import java.util.List;

import javax.persistence.*;

import com.avaje.ebean.Model;
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
    public long authorId;

    /* if the post is a question */
    public boolean isQuestion;

    /* the answer of question */
    public String answer;

    /* post created at */
    public String postAt;

    public static Finder<Long, Post> find = new Finder<Long, Post>(Post.class);

    public Post() {
    }

    public Post(
    		String title,
    		String content,
    		long authorId,
    		String postAt,
    		boolean isQuestion
    		) {
    	this.title = title;
    	this.content = content;
    	this.authorId = authorId;
    	this.postAt = postAt;
    	this.isQuestion = isQuestion;
    	this.answer = "";
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

	public String getPostAt() {
		return postAt;
	}

	public void setPostAt(String postAt) {
		this.postAt = postAt;
	}

	public boolean IsQuestion() {
		return isQuestion;
	}

	public void setQueustion(boolean isQuestion) {
		this.isQuestion = isQuestion;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
}