package models;

import java.util.*;
import javax.persistence.*;
import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

/*
This class is only for test.
*/

@Entity 
public class User extends Model  {

	@Id
	public Long id;
	public String username;
	
	public User(Long id, String username){
		this.id=id;
		this.username=username;
	}

	public Long getUserId(){
		return id;
	}

	public String getUsername(){
		return username;
	}

	public static Finder<Long, User> find = new Finder<Long, User>(User.class);
}
