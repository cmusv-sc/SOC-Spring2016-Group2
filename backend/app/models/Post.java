package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
    public long authorId;
    
    /* if the post is a question */
    public boolean isQueustion;
    
    /* if the post is a question, answerId 
     * is the id of comment which is set as answer
     * */
    public Long answerId;
    
    /* post created at */
    @Column(columnDefinition = "datetime")
    public Timestamp postAt;

    public static Finder<Long, Post> find = new Finder<Long, Post>(Post.class);
    
    public Post() {
    }
    
    public Post(
    		String title, 
    		String content, 
    		Long authorId,  
    		Timestamp postAt
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

	public long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}

	public long getAnswerId() {
		return answerId;
	}

	public void setAnswerId(long answerId) {
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

//	public static List<ObjectNode> getPostDetails(List<Post> posts){
//		List<ObjectNode> results = new ArrayList<ObjectNode>();
//		for(Post post : posts) {
//			ObjectNode result = Json.newObject();
//			StringBuilder sb=new StringBuilder();
//			for(Author author: authors){
//				sb.append(author+";");
//			}
//			result.put("authors",sb.toString());
//			result.put("title", publication.getTitle());
//			result.put("editor", publication.getEditor());
//			result.put("booktitle",publication.getBooktitle());
//			result.put("isbn", publication.getIsbn());
//			result.put("year",publication.getYear());
//			result.put("crossref",publication.getCrossref());
//			result.put("ee",publication.getEe());
//			result.put("url",publication.getUrl());
//			result.put("series",publication.getSeries());
//			result.put("volume",publication.getVolume());
//			results.add(result);
//		}
//		return  results;
//	}
	//============tagging===================
}
}
