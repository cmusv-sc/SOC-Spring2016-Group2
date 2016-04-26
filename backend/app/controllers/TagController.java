package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Post;
import models.Publication;
import models.Tagpost;
import models.Tagpub;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;

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
        List<Publication> publications = Publication.findwithtagpub.where().eq("tagpubs.tag", tagpub).findList();
        List<ObjectNode> publicationsjson = Publication.getPubDetails(publications);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<publicationsjson.size(); i++){
            if(i>0){
                sb.append(",");
            }
            sb.append(publicationsjson.get(i));
        }
        return ok(sb.toString());
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
/*    public Result addTagpost(Long postid, String tagpost){
        Post postadd = Post.find.where().eq("id", postid).findUnique();
        List<Tagpost> tagpostadd = Tagpost.findwithpost.where().eq("post_id", postid).findList();
        for (Tagpost tagposttemp:tagpostadd){
            if (tagposttemp.getTag().equals(tagpost)){
                return ok(tagpost + " already existed!");
            }
        }
        tagpostadd.add(new Tagpost(tagpost));
        postadd.setTagposts(tagpostadd);
        postadd.save();
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
    }*/
    //======================post===========================

}

