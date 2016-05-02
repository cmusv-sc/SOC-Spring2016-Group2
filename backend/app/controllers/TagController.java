package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import models.*;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;

import static play.libs.Json.toJson;

/**
 * Created by sagejoyoox on 4/23/16.
 */
public class TagController extends Controller {

    //===================publication===========================
    public Result addTagpub(Long pubid, String tagpub){
        Publication publicationadd = Publication.findwithtagpub.where().eq("id", pubid).findUnique();
        List<Tagpub> tagpubadd = Tagpub.findwithpublication.where().eq("pub_id", pubid).findList();
        for (Tagpub tagpubtemp:tagpubadd){
            if (tagpubtemp.getTag().equals(tagpub)){
                return ok(tagpub + " already existed!");
            }
        }
        tagpubadd.add(new Tagpub(tagpub));
        publicationadd.setTagpubs(tagpubadd);
        publicationadd.save();
        return ok(tagpub + " added successfully!");
    }

    public Result deleteTagpub(Long pubid, String tagpub){
        List<Tagpub> tagpubdelete = Tagpub.findwithpublication.where().eq("pub_id", pubid).findList();
        for(Tagpub tagpubtemp:tagpubdelete){
            if(tagpubtemp.getTag().equals(tagpub)){
                Tagpub.findwithpublication.ref(tagpubtemp.getId()).delete();
                return ok(tagpub + " deleted successfully!");
            }
        }
        return ok(tagpub + " does not exist!");
    }

    public Result updateTagPub(Long pubid, String tagpub) {
      List<Tagpub> tagpubdelete = Tagpub.findwithpublication.where().eq("pub_id", pubid).findList();
      for (Tagpub tagpubtemp:tagpubdelete) {
        Tagpub.findwithpublication.ref(tagpubtemp.getId()).delete();
      }
      String[] tag_array = tagpub.split(",");
      for (int i = 0; i < tag_array.length; ++i) {
        addTagpub(pubid, tag_array[i]);
      }
      return ok(tagpub + " updated successfully!");
    }

    public Result getTagpubs(String title){
        List<Tagpub> tagpubs = Tagpub.findwithpublication.where().eq("publication.title", title).findList();
        StringBuilder sb =new StringBuilder();
        for(int i=0; i<tagpubs.size(); i++){
            if(i>0){
                sb.append(",");
            }
            sb.append(tagpubs.get(i).toJson());
        }
        return ok(sb.toString());
    }

    public Result getPublications(String tagpub){
        List<PublicationWithAuthorsinTag> results = new ArrayList<PublicationWithAuthorsinTag>();
        List<Publication> publications = Publication.findwithtagpub.where().eq("tagpubs.tag", tagpub).findList();
        for (Publication publicationtemp:publications){
            List<PublicationAuthor> publication_authors = PublicationAuthor.find.where().eq("publication_id", publicationtemp.getId()).findList();
            ArrayList<Author> authors = new ArrayList<Author>();
            for (PublicationAuthor publicationauthortemp:publication_authors){
                authors.add(Author.find.where().eq("id", publicationauthortemp.getId()).findUnique());
            }
            results.add(new PublicationWithAuthorsinTag(publicationtemp, authors));
        }
        return ok(Json.toJson(results));
    }

    public Result getTagByPub_id(Long pub_id)
    {
        List<Tagpub> tagpubs = Tagpub.findwithpublication.where().eq("pub_id", pub_id).findList();
        StringBuilder sb = new StringBuilder();
        for(Tagpub tagpub: tagpubs){
            sb.append(tagpub.getTag()+",");
        }
        if (sb.length()>0)
            sb.deleteCharAt(sb.length()-1);
        return ok(sb.toString());
    }
    //===================publication===========================
//========================================================================================================
    //======================post===========================
    public Result addTagpost(Long postid, String tagpost){
        Post postadd = Post.find.where().eq("id", postid).findUnique();
        List<Tagpost> tagpostadd = Tagpost.findwithpost.where().eq("post_id", postid).findList();
        for (Tagpost tagposttemp:tagpostadd){
            if (tagposttemp.getTag().equals(tagpost)){
                return ok(tagpost + " already existed!");
            }
        }
        Tagpost tagpost1 = new Tagpost(postid, tagpost);
        tagpost1.save();
        return ok(tagpost + " added successfully!");
    }

    public Result deleteTagpost(Long postid, String tagpost){
        List<Tagpost> tagpostdelete = Tagpost.findwithpost.where().eq("post_id", postid).findList();
        for(Tagpost tagposttemp:tagpostdelete){
            if(tagposttemp.getTag().equals(tagpost)){
                Tagpost.findwithpost.ref(tagposttemp.getId()).delete();
                return ok(tagpost + " deleted successfully!");
            }
        }
        return ok(tagpost + " does not exist!");
    }


    public Result getTagByPost_id(Long post_id)
    {
        List<Tagpost> tagposts = Tagpost.findwithpost.where().eq("post_id", post_id).findList();
        StringBuilder sb = new StringBuilder();
        for(Tagpost tagpost: tagposts){
            sb.append(tagpost.getTag()+",");
        }
        if (sb.length()>0)
            sb.deleteCharAt(sb.length()-1);
        return ok(sb.toString());
    }
    //======================post===========================

public class PublicationWithAuthorsinTag{
        private Publication publication;
        private ArrayList<Author> authors;
        public PublicationWithAuthorsinTag(){
            publication = new Publication();
            authors = new ArrayList<Author>();
        }

        public PublicationWithAuthorsinTag(Publication publication, ArrayList<Author> authors){
            this.publication = publication;
            this.authors = authors;
        }

        public ArrayList<Author> getAuthors() {
            return authors;
        }

        public void setAuthors(ArrayList<Author> authors) {
            this.authors = authors;
        }

        public Publication getPublication() {
            return publication;
        }

        public void setPublication(Publication publication) {
            this.publication = publication;
        }
    }
}
