package controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;

import models.Comment;
import models.Post;
import models.User;
import play.mvc.Controller;
import play.mvc.Result;

import util.Common;

public class PostController extends Controller {
	
	/* add a new post to database */
	public Result addPost() {
		JsonNode jsonNode = request().body().asJson();
		if(jsonNode == null) {
			return Common.badRequestWrapper("Post is empty");
		}
		String title = jsonNode.path("title").asText();
		String content = jsonNode.path("content").asText();
		long authorId = jsonNode.path("authorId").asLong();
		User author = User.find.byId(authorId);
		if(author == null) {
			return Common.badRequestWrapper("Cannot find author");
		}
		boolean isQuestion = jsonNode.path("isQuestion").asBoolean();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date postAt = new Date();
		try {
			postAt = dateFormat.parse(jsonNode.path("postAt").asText());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Post(title, content, author, isQuestion, postAt).save();
		return ok(new Gson().toJson("success"));
	}
	
	/* find post by id */
	public Result getPostById(Long postId) {
		Post post = Post.find.byId(postId);
		if(post == null) {
			return Common.badRequestWrapper("no record found");
		}
		return created(new Gson().toJson(post));
	}
	
	/* get all post */
	public Result getPosts() {
		List<Post> posts = Post.find.all();
		if(posts == null || posts.size() == 0) {
			return Common.badRequestWrapper("no record found");
		}
		return created(new Gson().toJson(posts));
	}
	
	public Result addComment() {
		JsonNode jsonNode = request().body().asJson();
		if(jsonNode == null) {
			return Common.badRequestWrapper("Comment is empty");
		}
		long postId = jsonNode.path("postId").asLong();
		Post post = Post.find.byId(postId);
		if(post == null) {
			return Common.badRequestWrapper("Cannot find post");
		}
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date commentAt = new Date();
		try {
			commentAt = dateFormat.parse(jsonNode.path("commentAt").asText());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Common.badRequestWrapper("Invalid date format, please sure the format is 'dd-MM-yyyy'");
		}
		long authorId = jsonNode.path("authorId").asLong();
		User author = User.find.byId(authorId);
		if(author == null) {
			return Common.badRequestWrapper("Cannot find author");
		}
		String content = jsonNode.path("content").asText();
		boolean isAnswer = jsonNode.path("isAnswer").asBoolean();
		Comment comment = new Comment(
				commentAt,
				author,
				content,
				isAnswer,
				post
				);
		/* the save of post will cascade to comment */
		//comment.save();
		post.getComments().add(comment);
		post.save();
		
		return ok(new Gson().toJson("success"));
	}
	
	public Result getComments(Long postId) {
		Post post = Post.find.byId(postId);
		if(post == null) {
			return Common.badRequestWrapper("Cannot find post");
		}
		List<Comment> comments = post.getComments();
		return created(new Gson().toJson(comments));
	}
	
	public Result setAnswer(Long postId, Long commentId) {
		Post post = Post.find.byId(postId);
		if(post == null) {
			return Common.badRequestWrapper("Cannot find post");
		}
		List<Comment> comments = post.getComments();
		for(Comment comment : comments) {
			if(comment.getId() == commentId) {
				comment.setAnswer(true);
				comment.save();
				post.save();
				return created(new Gson().toJson("success"));
			}
		}
		return Common.badRequestWrapper("Cannot find comment");
	}
}





