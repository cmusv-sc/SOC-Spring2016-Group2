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

			//String userNameTest = "Xiaoxing Ma";
			Long authorId = Author.find_Author_Id(userName).get(0);

    		new UserProfile(userName,
					updateCollaboratorNumbers(authorId),
					updateSubscribeNumbers(authorId),
					updateTags(authorId).toString(),
					updateTitle(authorId).toString()).save();

    		return ok(toJson("success"));
	}





	public Result getUserProfile(String userName){
		List<UserProfile> userProfile = UserProfile.findByUserName(userName);
		if(userProfile.size() == 0){
			return Common.badRequestWrapper("bad request");
		}
		UserProfile data = userProfile.get(0);
		ObjectNode result = Json.newObject();
		result.put("collaboratornumber",String.valueOf(data.getCollaboratorNumbers()));
		result.put("subscribenumbers",String.valueOf(data.getSubscriberNumbers()));
		result.put("tags",data.getTags());
		result.put("titles",data.getPaperTitles());

		return ok(Json.toJson(result));
    }





    public Result refreshUserprofile(String userName){
		List<ObjectNode> results = new ArrayList<ObjectNode>();

		Long authorId = Author.find_Author_Id(userName).get(0);

		ObjectNode result_Coll = Json.newObject();
		ObjectNode result_Tit = Json.newObject();
		ObjectNode result_Tag = Json.newObject();
		ObjectNode result_Sub = Json.newObject();

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

		return 1;

	}

	public List<PublicationAuthor> getPublicationAuthor(Long authorId){

		return PublicationAuthor.find(null,authorId);
	}




}
