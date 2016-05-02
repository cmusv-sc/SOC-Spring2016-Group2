package controllers;

import java.util.*;

import com.avaje.ebean.Expr;
import com.fasterxml.jackson.databind.JsonNode;
import models.Post;
import models.PostComment;
import play.mvc.Controller;
import play.mvc.Result;

import util.Common;

import static play.libs.Json.toJson;
import play.libs.Json;

public class PostController extends Controller {



	/* add a new post to database */
	public Result addPost() {
		response().setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE");
        response().setHeader("Access-Control-Max-Age", "3600");
        response().setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-    Type, Accept, Authorization, X-Auth-Token");
        response().setHeader("Access-Control-Allow-Credentials", "true");
        response().setHeader("Access-Control-Allow-Origin", "*");
		JsonNode jsonNode = request().body().asJson();
		if(jsonNode == null) {
			return Common.badRequestWrapper("Post is empty");
		}
		String title = jsonNode.path("title").asText();
		String content = jsonNode.path("content").asText();

		long authorId = jsonNode.path("authorId").asLong();
		String postAt = jsonNode.path("postAt").asText();
		boolean isQuestion = jsonNode.path("isQuestion").asBoolean();
		new Post(title, content, authorId, postAt, isQuestion).save();
		return ok(toJson("success"));
	}

	/* find post by id */
	public Result getPostById(Long postId) {
        response().setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE");
        response().setHeader("Access-Control-Max-Age", "3600");
        response().setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-    Type, Accept, Authorization, X-Auth-Token");
        response().setHeader("Access-Control-Allow-Credentials", "true");
        response().setHeader("Access-Control-Allow-Origin", "*");
		Post post = Post.find.byId(postId);
		if(post == null) {
			return Common.badRequestWrapper("no record found");
		}
		return created(Json.toJson(post));
	}

	/* get all post */
	public Result getAllPosts() {
        response().setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE");
        response().setHeader("Access-Control-Max-Age", "3600");
        response().setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-    Type, Accept, Authorization, X-Auth-Token");
        response().setHeader("Access-Control-Allow-Credentials", "true");
        response().setHeader("Access-Control-Allow-Origin", "*");
		List<Post> posts = Post.find.all();
		if(posts == null || posts.size() == 0) {
			return Common.badRequestWrapper("no record found");
		}
		return created(Json.toJson(posts));
	}

	public Result addComment() {
        response().setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE");
        response().setHeader("Access-Control-Max-Age", "3600");
        response().setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-    Type, Accept, Authorization, X-Auth-Token");
        response().setHeader("Access-Control-Allow-Credentials", "true");
        response().setHeader("Access-Control-Allow-Origin", "*");
		JsonNode jsonNode = request().body().asJson();
        if(jsonNode == null) {
            return Common.badRequestWrapper("no request body");
        }
		long postId = jsonNode.path("postId").asLong();
		long commentId = jsonNode.path("commentId").asLong();
		Post post = Post.find.byId(postId);
		if(post == null) {
			return Common.badRequestWrapper("post not found");
		}
		new PostComment(postId, commentId).save();
		return ok(Json.toJson("success"));
	}

	public Result setAsQuestion() {
        response().setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE");
        response().setHeader("Access-Control-Max-Age", "3600");
        response().setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-    Type, Accept, Authorization, X-Auth-Token");
        response().setHeader("Access-Control-Allow-Credentials", "true");
        response().setHeader("Access-Control-Allow-Origin", "*");
		JsonNode jsonNode = request().body().asJson();
        if(jsonNode == null) {
            return Common.badRequestWrapper("no request body");
        }
		long postId = jsonNode.path("postId").asLong();
		Post post = Post.find.byId(postId);
		if(post == null) {
			return Common.badRequestWrapper("Cannot find post");
		}
		post.setQueustion(true);
		post.save();
		return ok(Json.toJson("success"));
	}

	public Result setAnswer() {
        response().setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE");
        response().setHeader("Access-Control-Max-Age", "3600");
        response().setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-    Type, Accept, Authorization, X-Auth-Token");
        response().setHeader("Access-Control-Allow-Credentials", "true");
        response().setHeader("Access-Control-Allow-Origin", "*");
		JsonNode jsonNode = request().body().asJson();
        if(jsonNode == null) {
            return Common.badRequestWrapper("no request body");
        }
		long postId = jsonNode.path("postId").asLong();
		String answer = jsonNode.path("answer").asText();
		Post post = Post.find.byId(postId);
		if(post == null) {
			return Common.badRequestWrapper("Cannot find post");
		}
		if(!post.IsQuestion()) {
			return Common.badRequestWrapper("This is not a question");
		}
		post.setAnswer(answer);
		post.save();
		return ok(Json.toJson("success"));
	}

    public Result search(String keyword) {
        response().setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE");
        response().setHeader("Access-Control-Max-Age", "3600");
        response().setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-    Type, Accept, Authorization, X-Auth-Token");
        response().setHeader("Access-Control-Allow-Credentials", "true");
        response().setHeader("Access-Control-Allow-Origin", "*");
        List<Post> posts = Post.find.where()
        		.or(Expr.like("title", "%" + keyword + "%"), Expr.like("content", "%" + keyword + "%"))
        		.orderBy("postAt")
        		.findList();
        if(posts == null || posts.size() == 0) {
            return Common.badRequestWrapper("No record found");
        }
        return created(Json.toJson(posts));
    }

    public Result getPostByUserId(Long userId) {
        response().setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE");
        response().setHeader("Access-Control-Max-Age", "3600");
        response().setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-    Type, Accept, Authorization, X-Auth-Token");
        response().setHeader("Access-Control-Allow-Credentials", "true");
        response().setHeader("Access-Control-Allow-Origin", "*");
        List<Post> posts = Post.find
            .where()
            .eq("authorId", userId)
            .findList();
        if(posts == null || posts.size() == 0) {
            return Common.badRequestWrapper("No record found");
        }
        return created(Json.toJson(posts));

    }
}
