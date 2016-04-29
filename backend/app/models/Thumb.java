package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;


@Entity(name="thumb")
public class Thumb extends Model {

	@Id
	public Long  id;
	public Boolean thumb_type;
	public String sender;
	public Integer receiver;

	public Thumb(Long id, Boolean thumb_type, String sender, Integer receiver) {
		this.id = id;
		this.thumb_type = thumb_type;
		this.sender = sender;
		this.receiver = receiver;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getThumb_type() {
		return thumb_type;
	}

	public void setThumb_type(Boolean thumb_type) {
		this.thumb_type = thumb_type;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public Integer getReceiver() {
		return receiver;
	}

	public void setReceiver(Integer receiver) {
		this.receiver = receiver;
	}
	public static Finder<Long,Thumb> find = new Finder<Long,Thumb>(Long.class, Thumb.class);
	
	public static List<Thumb>  find(String key, String val) {
		System.out.println("thumb find, key is " + key + ", val is " + val);
		if(key.equals("user")){
			return find.where()
					.eq("sender", val)
					.findList();

		}
		if(key.equals("id")){
			return find.where()
					.eq("id", val)
					.findList();
		}else{
			return null;
		}
	}
}
