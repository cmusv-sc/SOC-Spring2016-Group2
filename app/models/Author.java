package models;

import com.avaje.ebean.Model;

import java.util.ArrayList;
import java.util.List;

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