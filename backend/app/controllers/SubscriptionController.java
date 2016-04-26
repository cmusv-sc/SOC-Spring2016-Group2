package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import models.*;
import play.libs.Json;
import play.mvc.*;
import java.util.*;

public class SubscriptionController extends Controller{
	public Result loadSubscriptionList() {	
		/*
		TODO: get follower_id from cookie
		Long followerId=Http.Request.current().cookies.get("username");
		*/
		Long followerId=new Long(1); 	
		List<Subscription> subscriptions=Subscription.find.where().eq("followerId", followerId).findList();
		Map<String, String> map=new HashMap<String, String>();
		for(Subscription subscription:subscriptions){
			Long followeeId=subscription.getFolloweeId();
			String category=subscription.getCategory();
			System.out.println(category);
			String username="";
			if(category.equals("user")){
				User user=User.find.byId(followeeId);
				if(user!=null)
					username=user.getUsername();
			}
			else if(category.equals("group")){
				UserGroup userGroup=UserGroup.find.byId(followeeId);
				if(userGroup!=null)
					username=userGroup.getGroupname();
			}
			else{
				List<Publication> publications=Publication.find.where().eq("pubkey", followeeId).findList();
				Publication publication=publications.get(0);
				if(publication!=null)
					username=publication.getTitle();
			}
			map.put(username, category);
		}		
		return ok(map+"");
	}


	public Result loadSubscriptionListByCategory(String category) {	
		/*
		TODO: get follower_id from cookie
		Long followerId=Http.Request.current().cookies.get("username");
		*/
		Long followerId=new Long(1); 	
		List<Subscription> subscriptions=Subscription.find.where().eq("followerId", followerId).eq("category", category).findList();
		Map<String, String> map=new HashMap<String, String>();
		String username="";
		if(category.equals("user")){
			for(Subscription subscription:subscriptions){
				Long followeeId=subscription.getFolloweeId();
				User user=User.find.byId(followeeId);
				if(user!=null)
					username=user.getUsername();
				map.put(username, category);
			}
		}
		else if(category.equals("group")){
			for(Subscription subscription:subscriptions){
				Long followeeId=subscription.getFolloweeId();
				UserGroup userGroup=UserGroup.find.byId(followeeId);
				if(userGroup!=null)
					username=userGroup.getGroupname();
				map.put(username, category);
			}
		}
		else{
			for(Subscription subscription:subscriptions){
				Long followeeId=subscription.getFolloweeId();
				List<Publication> publications=Publication.find.where().eq("pubkey", followeeId).findList();
				Publication publication=publications.get(0);
				if(publication!=null)
					username=publication.getTitle();
				map.put(username, category);
			}
		}
		return ok(map+"");
	}


	public Result loadTimeline(){
		/*
		TODO: get follower_id from cookie
		Long followerId=Http.Request.current().cookies.get("username");
		*/
		Long followerId=new Long(1);
		List<Subscription> subscriptions=Subscription.find.where().eq("followerId", followerId).findList();
		if(subscriptions.size()==0)
			return ok("empty");
		List<String> results=new ArrayList<String>();
		for(Subscription subscription:subscriptions){
			Long followeeId=subscription.getFolloweeId();
			String category=subscription.getCategory();
			Date timestamp=null;
			String username="";
			String content="";

			if(category.equals("user")){
				//get username
				User user=User.find.byId(followeeId);
				System.out.println("entered user");
				if(user!=null)
					username=user.getUsername();
				System.out.println("username="+username);
				// get timestamp and content
				List<Post> posts=Post.find.where().eq("authorId", followeeId).findList();
				for(Post post: posts){
					if(post!=null){
					timestamp=post.getPostAt();
					content=post.getContent();
					System.out.println("content="+content);
					results.add(timestamp+"\t"+username+"\t"+content);
					}
				}
			}
			else if(category.equals("group")){
				// get members
				List<GroupMember> groupMembers=GroupMember.find.where().eq("group_id", followeeId).findList();
				List<User> users=new ArrayList<User>();
				for(GroupMember groupMember: groupMembers){
					if(groupMember!=null)
						users.add(User.find.where().eq("id", groupMember.getMemberId()).findList().get(0));
				}
				UserGroup userGroup=UserGroup.find.byId(followeeId);
				String groupname="";
				if(userGroup!=null)
					groupname=userGroup.getGroupname();
				for(User user: users){
					long userId=0;
					//get username
					if(user!=null){
						username=user.getUsername();
						userId=user.getUserId();
					}
					// get timestamp and content
					List<Post> posts=Post.find.where().eq("authorId", userId).findList();
					for(Post post: posts){
						if(post!=null){
						timestamp=post.getPostAt();
						content=post.getContent();
						results.add(timestamp+"\t"+username+": "+groupname+"\t"+content);
						}
					}					
				}
			}
			else{
				List<Publication> publications=Publication.find.where().eq("pubkey", followeeId).findList();
				Publication publication=publications.get(0);
				String title="";
				String result="";
				if(publication!=null)
					title=publication.getTitle();
				// get comments
				List<Comment> comments=Comment.find.where().eq("rootid", followeeId).eq("categoryid",1).findList();
				for(Comment comment: comments){
					if(comment!=null)
						result+=comment.getContent()+"\t";
				}
				results.add(title+"\t"+result);
			}
		}
		return ok(results+"");
	}


    public Result subscribe(Long followeeid, String category){
		/*
		TODO cookie
		*/
		Long followerId=new Long(1);
		Subscription subscription=new Subscription(null, followerId, followeeid, category, new Date());
		subscription.save();
		return ok("subscribe successfully");
	}
}






