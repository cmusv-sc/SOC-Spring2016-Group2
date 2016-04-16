package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;


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
	
	/*
	 * Get the string representation of author
	 * @return	the string representation of author
	 * */
	public String toString() {
		return  this.name;
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public static Model.Finder<Long,Author>  find = new Model.Finder(Long.class, Author.class);
	
    public static List<Author> find(List<PublicationAuthor> ids){
		List<Author> authors=new ArrayList<Author>();
		for(PublicationAuthor id: ids){
			System.out.println(id.getauthorID());
			System.out.println("=====================");
			Author author=find.where().eq("id", id.getauthorID()).findUnique();
			authors.add(author);
		}
		return authors;
	}
    
	public static List<Author> findAll(){
		return find.all();
	}
}
