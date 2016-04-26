package models;

import com.avaje.ebean.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by sagejoyoox on 4/23/16.
 */
@Entity
@Table(name="tagpub")
public class Tagpub extends Model {
    @Id
    @Column(name="tagpub_id")
    public Long id;

    public String tag;

    @ManyToOne
    @JoinColumn(name="pub_id")
    @JsonBackReference
    public Publication publication;

    public static Finder<Long, Tagpub> findwithpublication = new Finder<Long,Tagpub>(Tagpub.class);

    public static List<Tagpub> findByPubId(Long pubId){
        return findwithpublication.where().eq("pub_id",pubId).findList();
    }


    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Long getId() {

        return id;
    }

    public String getTag() {
        return tag;
    }

    public Tagpub(String tag) {
        super();
        this.tag = tag;
    }

    public Tagpub() {
    }

    public String toJson() {
        return "{\"id\":\"" + id + "\", \"tag\":\"" + tag + "\"}";
    }
}

