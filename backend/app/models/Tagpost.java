package models;

import com.avaje.ebean.Model;

import javax.persistence.*;

/**
 * Created by sagejoyoox on 4/25/16.
 */
@Entity
@Table(name="tagpost")
public class Tagpost extends Model{
    @Id
    @Column(name="tagpost_id")
    public Long id;

    public String tag;

    @Column(name="post_id")
    public Long postid;

    public static Finder<Long, Tagpost> findwithpost = new Finder<Long,Tagpost>(Tagpost.class);

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

    public Tagpost(Long postid, String tag) {
        this.postid = postid;
        this.tag = tag;
    }

    public Tagpost() {
    }

    public Long getPostid() {
        return postid;
    }

    public void setPostid(Long postid) {
        this.postid = postid;
    }



    public String toJson() {
        return "{\"id\":\"" + id + "\", \"tag\":\"" + tag + "\"}";
    }
}

