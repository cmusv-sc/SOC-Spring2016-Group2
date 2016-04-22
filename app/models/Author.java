package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity(name="author")
public class Author extends Model {

	@Id
	public  Long  id;
	
	public String name;

	public Author(String name) {
		this.name = name;
	}

	public Author() {
		this.name = "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public static Finder<Long, Author>  find = new Finder<Long, Author>(Long.class, Author.class);
}