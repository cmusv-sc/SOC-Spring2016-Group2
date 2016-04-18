package controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;

import models.Post;
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
		String author = jsonNode.path("author").asText();
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
		return created(new Gson().toJson("success"));
	}
	
	/* find post by id */
	public Result getPostById(Long id) {
		Post post = Post.find.byId(id);
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
}
