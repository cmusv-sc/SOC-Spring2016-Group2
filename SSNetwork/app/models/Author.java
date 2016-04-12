package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity(name="authors")
public class Author extends Model {
	public String name;
	
	public Author(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/*
	 * Get the string representation of author
	 * @return	the string representation of author
	 * */
	public String toString() {
		return "Author:\t" + this.name;
	}
}
