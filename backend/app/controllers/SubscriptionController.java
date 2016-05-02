package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import models.*;
import play.libs.Json;
import play.mvc.*;
import java.util.*;
import static play.libs.Json.toJson;


public class SubscriptionController extends Controller{

	// static{
	// 	MongoClient mongoClient2 = new MongoClient("lec2-54-200-79-239.us-west-2.compute.amazonaws.com", 27017);
	// 	MongoDatabase db = mongoClient.getDatabase("test");
	// 	collection = db.getCollection("myCollection");
	// 	System.out.println("mongodb contention="+contention);
	// }
	public Result loadSubscriptionList() {	
		/*
		TODO: get follower_id from cookie
		Long followerId=Http.Request.current().cookies.get("username");
		*/
		Long followerId=new Long(1); 	
		List<Subscription> subscriptions=Subscription.find.where().eq("followerId", followerId).findList();
		List<ObjectNode> results= new ArrayList<ObjectNode>();
		for(Subscription subscription:subscriptions){
			Long followeeId=subscription.getFolloweeId();
			String category=subscription.getCategory();
			ObjectNode result=Json.newObject();
			// System.out.println(category);
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
			result.put("username", username);
			result.put("category", category);
			results.add(result);
		}		
		return ok(toJson(results));
	}


	public Result loadSubscriptionListByCategory(String category) {	
		/*
		TODO: get follower_id from cookie
		Long followerId=Http.Request.current().cookies.get("username");
		*/
		Long followerId=new Long(1); 	
		List<Subscription> subscriptions=Subscription.find.where().eq("followerId", followerId).eq("category", category).findList();
		List<ObjectNode> results= new ArrayList<ObjectNode>();
		String username="";
		if(category.equals("user")){
			for(Subscription subscription:subscriptions){
				Long followeeId=subscription.getFolloweeId();
				User user=User.find.byId(followeeId);
				if(user!=null){
					username=user.getUsername();
					ObjectNode result=Json.newObject();
					result.put("username", username);
					result.put("category", "user");
					results.add(result);
				}
			}
		}
		else if(category.equals("group")){
			for(Subscription subscription:subscriptions){
				Long followeeId=subscription.getFolloweeId();
				UserGroup userGroup=UserGroup.find.byId(followeeId);
				if(userGroup!=null){
					username=userGroup.getGroupname();
					ObjectNode result=Json.newObject();
					result.put("username", username);
					result.put("category", "group");
					results.add(result);
				}
			}
		}
		else{
			for(Subscription subscription:subscriptions){
				Long followeeId=subscription.getFolloweeId();
				List<Publication> publications=Publication.find.where().eq("pubkey", followeeId).findList();
				Publication publication=publications.get(0);
				if(publication!=null){
					username=publication.getTitle();
					ObjectNode result=Json.newObject();
					result.put("username", username);
					result.put("category", "paper");
					results.add(result);
				}
			}
		}
		return ok(toJson(results));
	}


	public Result loadTimeline(){
		/*
		TODO: get follower_id from cookie
		Long followerId=Http.Request.current().cookies.get("username");
		*/
		Long followerId=new Long(1);
		List<Subscription> subscriptions=Subscription.find.where().eq("followerId", followerId).findList();
		if(subscriptions.size()==0)
			return ok("No available posts.");
		List<ObjectNode> results=new ArrayList<ObjectNode>();
		for(Subscription subscription:subscriptions){
			Long followeeId=subscription.getFolloweeId();
			String category=subscription.getCategory();
			String timestamp=null;
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
						ObjectNode result=Json.newObject();
						result.put("timestamp", timestamp+"");
						result.put("username", username);
						result.put("category", "user");
						result.put("content", content);
						results.add(result);
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
					// get timestamp and content
						List<Post> posts=Post.find.where().eq("authorId", userId).findList();
						for(Post post: posts){
							if(post!=null){
								timestamp=post.getPostAt();
								content=post.getContent();
								ObjectNode result=Json.newObject();
								result.put("timestamp", timestamp+"");
								result.put("username", username);
								result.put("category", "group");
								result.put("content", content);
								results.add(result);
							}
						}
					}					
				}
			}
			else{
				List<Publication> publications=Publication.find.where().eq("pubkey", followeeId).findList();
				Publication publication=publications.get(0);
				String title="";
				if(publication!=null){
					title=publication.getTitle();
					// get comments
					List<NestedComment> comments=getCommentsRecursively(followeeId.intValue(), 1, 0);
					for(NestedComment nestedComment: comments){
						ObjectNode result=Json.newObject();
						result.put("timestamp", nestedComment.comment.getTime()+"");
						result.put("username", title);
						result.put("category", "paper");
						result.put("content", nestedComment.comment.getContent()); //????
						results.add(result);
					}
				}
			}
		}
		return ok(toJson(results));
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

	public ArrayList<NestedComment> getCommentsRecursively(int rootid, int categoryid, int parentid){
		ArrayList<NestedComment> list = new ArrayList<NestedComment>();
		List<Comment> comments = Comment.find.where().eq("parentid", parentid).eq("rootid", rootid).eq("categoryid", categoryid).findList();
		for (int i = 0; i < comments.size(); i++){
			list.add(new NestedComment(comments.get(i), getCommentsRecursively(rootid, categoryid, comments.get(i).getId())));
		}
		return list;
	}
}

class NestedComment{
	public Comment comment;
	public int thumbup = 0;
	public int thumbdown = 0;
	public boolean thumbuped = false;
	public boolean thumbdowned = false;
	public ArrayList<NestedComment> children;
	public NestedComment(Comment comment, ArrayList<NestedComment> children){
		this.comment = comment;
		this.children = children;
	}
	public NestedComment(Comment comment, ArrayList<NestedComment> children, int thumbdown, int thumbup){
		this.comment = comment;
		this.children = children;
		this.thumbdown = thumbdown;
		this.thumbup = thumbup;
	}


}





