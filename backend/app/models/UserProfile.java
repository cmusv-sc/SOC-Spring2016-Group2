package models;

import com.avaje.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.ArrayList;
import java.util.List;


@Entity(name="userProfile")
public class UserProfile extends Model {

    @Id
    private Long id;

	private String userName;

    private Integer collaboratorNumbers;

    private Integer subscriberNumbers;

    private String tags;

    private String paperTitles;

   	public  UserProfile(){

   	}

    public UserProfile(String userName, Integer collaboratorNumbers,
    				   Integer subscriberNumbers, String tags,
    				   String paperTitles) {
    		this.userName = userName;
    		this.collaboratorNumbers = collaboratorNumbers;
    		this.subscriberNumbers = subscriberNumbers;
    		this.tags = tags;
    		this.paperTitles = paperTitles;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getCollaboratorNumbers() {
		return collaboratorNumbers;
	}

	public void setCollaboratorNumbers(Integer collaboratorNumbers) {
		this.collaboratorNumbers = collaboratorNumbers;
	}

	public Integer getSubscriberNumbers() {
		return subscriberNumbers;
	}

	public void setSubscriberNumbers(Integer subscriberNumbers) {
		this.subscriberNumbers = subscriberNumbers;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getPaperTitles() {
		return paperTitles;
	}

	public void setPaperTitles(String paperTitles) {
		this.paperTitles = paperTitles;
	}

	public static Finder<Long, UserProfile> find = new Finder<Long, UserProfile>(Long.class, UserProfile.class);

    public static List<UserProfile> findByUserName(String userName){
    	return find.where().eq("user_name",userName).findList();
    }
	public static List<UserProfile> findAll(){
		return find.all();
	}
}