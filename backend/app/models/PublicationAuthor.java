package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;


@Entity(name="publication_author")
public class PublicationAuthor extends Model {
	public long publicationID;
	public long authorID;

	public PublicationAuthor(long publicationID, long authorID) {
		this.publicationID = publicationID;
		this.authorID = authorID;
	}

	public PublicationAuthor() {
	}

	/*
	 * Get the string representation of PublicationAuthor
	 * @return	the string representation of PublicationAuthor
	 * */
	public String toString() {
		return "<publicationID: " + this.publicationID + ",\tauthorID: " + this.authorID + ">";
	}

	public long getPublicationID() {
		return publicationID;
	}

	public void setPublicationID(long publicationID) {
		this.publicationID = publicationID;
	}

	public long getauthorID() {
		return authorID;
	}

	public void setauthorID(long authorID) {
		this.authorID = authorID;
	}
	@Id
	public Long id;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public static Model.Finder<Long,PublicationAuthor> find = new Model.Finder(Long.class, PublicationAuthor.class);

	public static List<PublicationAuthor> find(Long publicationID, Long authorID){
		if(publicationID!=null){
			//find authorid with publicationid
			return find.where()
					.eq("publicationID",publicationID).findList();
		}else{
			//find publicationid with authorid
			return find.where()
					.eq("authorID",authorID).findList();
		}

	}
	public static List<PublicationAuthor> findAll(){
		return find.all();
	}
	public static List<Long> find_pub_id(List<Long> authorids){
		List<Long> pubids=new ArrayList<Long>();
		for(Long id: authorids){
			pubids.add(PublicationAuthor.find.where().eq("authorID",id).findUnique().getPublicationID());
		}
		return pubids;
	}



}
