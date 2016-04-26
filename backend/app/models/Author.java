package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;


@Entity(name="authors")
public class Author extends Model {
	public String name;

	public Author(String name) {
		this.name = name;
	}

	public Author() {
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
	@Id
	public  Long  id;
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
			Author author=find.where().eq("id", id.getauthorID()).findUnique();
			authors.add(author);
		}
		return authors;
	}
	public static List<Author> findAll(){
		return find.all();
	}
	public static List<Long> find_Author_Id(String name){
		List<Author> authors=find.where().eq("name",name).findList();
		List<Long> author_ids = new ArrayList<Long>();
		for(Author author:authors){
			author_ids.add(author.getId());
		}
		return author_ids;
	}
}
