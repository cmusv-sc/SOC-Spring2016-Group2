package models;

import javax.persistence.Entity;
import javax.persistence.*;

import com.avaje.ebean.Model;

@Entity(name="user")
public class User extends Model{
	
	@Id
	public Long id;
	
	public String username;
	
	public String password;
	
	public String email;
	
	public User() {
		
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public static Finder<Long, User> find = new Finder<Long, User>(User.class);
	
	public User(
			String username,
			String password,
			String email
			) {
		this.username = username;
		this.password = password;
		this.email = email;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + "]";
	}
}
