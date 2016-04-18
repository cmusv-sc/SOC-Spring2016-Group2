package models;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import static play.test.Helpers.*;

public class UserTest {

	@Test
	public void userTest() {
	    running(fakeApplication(), new Runnable() {
	        public void run() {
	    		User user = new User("bob", "password", "bob@gmail.com");
	    		user.save();
	    		List<User> users = User.find.all();
	    		assertThat(users.size(), equalTo(1));
	    		user = users.get(0);
	    		assertThat(user.getUsername(), equalTo("bob"));
	    		assertThat(user.getPassword(), equalTo("password"));
	    		assertThat(user.getEmail(), equalTo("bob@gmail.com"));
	        }
	     });
	}

	/*@Test
	public void userTest() {
	    running(fakeApplication(), new Runnable() {
	        public void run() {
	    		User user = new User("bob", "password", "bob@gmail.com");
	    		user.save();
	    		List<User> users = User.find.all();
	    		assertThat(users.size(), equalTo(1));
	    		user = users.get(0);
	    		assertThat(user.getUsername(), equalTo("bob"));
	    		assertThat(user.getPassword(), equalTo("password"));
	    		assertThat(user.getEmail(), equalTo("bob@gmail.com"));
	        }
	     });
	}*/
}
