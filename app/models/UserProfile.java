
import com.avaje.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.ArrayList;
import java.util.List;


@Entity(name="userProfile")
public class UserProfile extends Model {

    @Id
    public Long id;

    public String name;

    public String collaboratorNumbers;

    public String subscriberNumbers;

	public List<String> interests = new ArrayList<String>();

	public List<String> contributedPaper = new ArrayList<String>();

	public List<String> associatedTags = new ArrayList<String>();



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCollaboratorNumbers() {
		return collaboratorNumbers;
	}

	public void setCollaboratorNumbers(String collaboratorNumbers) {
		this.collaboratorNumbers = collaboratorNumbers;
	}

	public String getSubscriberNumbers() {
		return subscriberNumbers;
	}

	public void setSubscriberNumbers(String subscriberNumbers) {
		this.subscriberNumbers = subscriberNumbers;
	}

	public List<String> getInterests() {
		return interests;
	}

	public void setInterests(List<String> interests) {
		this.interests = interests;
	}

	public List<String> getContributedPaper() {
		return contributedPaper;
	}

	public void setContributedPaper(List<String> contributedPaper) {
		this.contributedPaper = contributedPaper;
	}

	public List<String> getAssociatedTags() {
		return associatedTags;
	}

	public void setAssociatedTags(List<String> associatedTags) {
		this.associatedTags = associatedTags;
	}

	@Override
    public String toString() {
    		return "userprofile [id=" + id + ", name=" + name + ", collaboratorNumbers=" + collaboratorNumbers
    				+ ", subscriberNumbers=" + subscriberNumbers + ", interests=" + interests + ", contributedPaper="
    				+ contributedPaper + ", associatedTags=" + associatedTags + "]";
    }

}