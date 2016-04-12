package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity(name="publication_author")
public class PublicationAuthor extends Model{
	public long publicationID;
	public long authorID;
	
	public PublicationAuthor(long publicationID, long authorID) {
		this.publicationID = publicationID;
		this.authorID = authorID;
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
}
