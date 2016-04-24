package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Publication;
import models.Tagpub;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sagejoyoox on 4/23/16.
 */
public class TagController extends Controller {

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
        List<ObjectNode> publicationsjson = Publication.findPubDetails(publications);

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
        sb.deleteCharAt(sb.length()-1);
        return ok(sb.toString());
    }

}

