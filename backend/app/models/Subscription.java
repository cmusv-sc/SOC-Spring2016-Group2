package models;

import java.util.*;
import javax.persistence.*;
import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity 
public class Subscription extends Model {

	@Id
	public Long id;
	public Long followerId;
	public Long followeeId;
	public String category;
	@Formats.DateTime(pattern="mm/hh/dd/MM/yyyy")
	public Date timestamp = new Date();

	// constructor
	public Subscription(Long id, Long followerId, Long followeeId, String category, Date timestamp){
		this.id=id;
		this.followerId=followerId;
		this.followeeId=followeeId;
		this.category=category;
		this.timestamp=timestamp;
	}

	public String toString(){
		return id+" "+followerId+" "+followeeId+" "+category+" "+timestamp;
	}

	// getters
	public Long getFolloweeId(){
		return followeeId;
	}

	public String getCategory(){
		return category;
	}

	public static Finder<Long,Subscription> find = new Finder<Long,Subscription>(
		Long.class, Subscription.class
		); 


	public static List<Long> findFolloweeIdByCategory(long followerId, String category){
		List<Subscription> subscriptions=find.where().eq("followerId", followerId).eq("category", category).findList();
		// for(Subscription subscription:subscriptions)
		// 	System.out.println(subscription.toString());
		List<Long> followeeIds=new ArrayList<Long>();
		for(Subscription subscription:subscriptions){
			followeeIds.add(subscription.getFolloweeId());
		}
		return followeeIds;
	}

	public static Map<Long, String> findAllFollowee(long followerId){
		List<Subscription> subscriptions=find.where().eq("followerId", followerId).findList();
		// for(Subscription subscription:subscriptions)
		// 	System.out.println(subscription.toString());
		Map<Long, String> map=new HashMap<Long, String>();
		for(Subscription subscription:subscriptions){
			map.put(subscription.getFolloweeId(), subscription.getCategory());
		}
		return map;
	}
}
