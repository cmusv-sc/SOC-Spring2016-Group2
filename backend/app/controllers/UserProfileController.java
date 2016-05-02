package controllers;

import java.sql.Timestamp;
import java.util.*;

import com.avaje.ebean.Expr;
import com.fasterxml.jackson.databind.JsonNode;
import play.mvc.Controller;
import play.mvc.Result;
import util.Common;

import static play.libs.Json.toJson;
import play.libs.Json;
import models.*;
import models.Tagpub;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Model;
import com.avaje.ebean.SqlRow;

import static play.data.Form.form;
import static play.libs.Json.toJson;
import java.io.File;
import com.fasterxml.jackson.databind.node.ObjectNode;


public class UserProfileController extends Controller {

	public Result createuserProfileProfile(){

    		JsonNode jsonNode = request().body().asJson();
    		if(jsonNode == null) {
    			return Common.badRequestWrapper("post is empty");
    		}
    		String userName = jsonNode.path("userName").asText();

			String userNameTest = "Xiaoxing Ma";
			Long authorId = Author.find_Author_Id(userName).get(0);

    		new UserProfile(userName,
					updateCollaboratorNumbers(authorId),
					updateSubscribeNumbers(authorId),
					updateTags(authorId).toString(),
					updateTitle(authorId).toString()).save();

    		return ok(toJson("success"));
	}





	public Result getUserProfile(String userName){
		List<ObjectNode> results = new ArrayList<ObjectNode>();
		List<UserProfile> userProfile = UserProfile.findByUserName(userName);
		if(userProfile.size() == 0){
			return Common.badRequestWrapper("bad request");
		}
		UserProfile data = userProfile.get(0);
		ObjectNode result1 = Json.newObject();
		ObjectNode result2 = Json.newObject();
		ObjectNode result3 = Json.newObject();
		ObjectNode result4 = Json.newObject();
		result1.put("collaboratornumber",String.valueOf(data.getCollaboratorNumbers()));
		result2.put("subscribenumbers",String.valueOf(data.getSubscriberNumbers()));
		result3.put("tags",data.getTags());
		result4.put("titles",data.getPaperTitles());

		results.add(result1);
		results.add(result2);
		results.add(result3);
		results.add(result4);

		return ok(Json.toJson(results));
    }





    public Result refreshUserprofile(String userName){
		List<ObjectNode> results = new ArrayList<ObjectNode>();

		ObjectNode result_Coll = Json.newObject();
		ObjectNode result_Tit = Json.newObject();
		ObjectNode result_Tag = Json.newObject();
		ObjectNode result_Sub = Json.newObject();


		if(Author.find_Author_Id(userName).size() == 0){
			result_Coll.put("collaboratornumber","");
			result_Sub.put("subscribenumbers","");
			result_Tit.put("titles","");
			result_Tag.put("tags","");
			results.add(result_Coll);
			results.add(result_Sub);
			results.add(result_Tit);
			results.add(result_Tag);
			return ok(Json.toJson(results));
		}

		Long authorId = Author.find_Author_Id(userName).get(0);


		Integer collaboratorNumbers = updateCollaboratorNumbers(authorId);
		result_Coll.put("collaboratornumber",String.valueOf(collaboratorNumbers));


		Integer subscribeNumbers = updateSubscribeNumbers(authorId);
		result_Sub.put("subscribenumbers",String.valueOf(subscribeNumbers));


		String titleResult = updateTitle(authorId).toString();
		result_Tit.put("titles",titleResult);

		String TagsResult = updateTags(authorId).toString();
		result_Tag.put("tags",TagsResult);

		results.add(result_Coll);
		results.add(result_Sub);
		results.add(result_Tit);
		results.add(result_Tag);


		List<UserProfile> userProfile = UserProfile.findByUserName(userName);
		UserProfile originUser = userProfile.get(0);

		UserProfile newProfile =  new UserProfile();
		newProfile.setId(originUser.getId());
		newProfile.setUserName(originUser.getUserName());
		newProfile.setCollaboratorNumbers(collaboratorNumbers);
		newProfile.setPaperTitles(titleResult);
		newProfile.setTags(TagsResult);
		newProfile.setSubscriberNumbers(subscribeNumbers);
		newProfile.update();

		return ok(Json.toJson(results));

    }


	public StringBuilder updateTitle(Long authorId){

		StringBuilder titlesResult = new StringBuilder();
		List<PublicationAuthor> publicationAuthors = getPublicationAuthor(authorId);

		for(PublicationAuthor publicationAuthor : publicationAuthors){

			List<Publication> publications =
					Publication.findPublicationById(publicationAuthor.getPublicationID());

			for(Publication publication : publications) {

				titlesResult.append(publication.getTitle()+"$&");

			}

		}

		return titlesResult;
	}


	public StringBuilder updateTags(Long authorId){

		StringBuilder tagsResult = new StringBuilder();
		List<PublicationAuthor> publicationAuthors = getPublicationAuthor(authorId);

		for(PublicationAuthor publicationAuthor : publicationAuthors){
			List<Publication> publications =
					Publication.findPublicationById(publicationAuthor.getPublicationID());
			for(Publication publication : publications) {

				Long pubId = publication.getId();
				List<Tagpub> tags = Tagpub.findByPubId(pubId);
				for(Tagpub tag : tags){
					tagsResult.append(tag.getTag() + "$&");
				}
			}

		}
		return tagsResult;
	}


	public Integer updateCollaboratorNumbers(Long authorId){

		List<PublicationAuthor> publicationAuthors = getPublicationAuthor(authorId);
		Integer newCollborators = -1;

		for(PublicationAuthor publicationAuthor : publicationAuthors){
			List<PublicationAuthor> publicationAuthorsOthers
					=  PublicationAuthor.find(publicationAuthor.getPublicationID(),null);
			List<Author> collaborators = Author.find(publicationAuthorsOthers);
			newCollborators = collaborators.size() - 1;
		}

		return newCollborators;
	}


	public Integer updateSubscribeNumbers(Long authorId){

		return 0;

	}

	public List<PublicationAuthor> getPublicationAuthor(Long authorId){

		return PublicationAuthor.find(null,authorId);
	}

	public void createAllUserProfile(){
		//List<ObjectNode> results = new ArrayList<ObjectNode>();

		List<Author> authors = Author.findAll();

		int i = 0;
		for(Author author : authors){
			String userName = author.getName();
			Long authorId = Author.find_Author_Id(userName).get(0);
			Integer collaboratorNumbers = updateCollaboratorNumbers(authorId);
			Integer subscribeNumbers = updateSubscribeNumbers(authorId);
			String titleResult = updateTitle(authorId).toString();
			String TagsResult = updateTags(authorId).toString();

			new UserProfile(userName,
					collaboratorNumbers,
					subscribeNumbers,
					TagsResult,
					titleResult).save();
			System.out.println("Generating User Profile " + i);
			i ++;
		}
		return;
	}


}
