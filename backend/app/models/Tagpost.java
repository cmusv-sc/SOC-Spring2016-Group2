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

    @ManyToOne
    @JoinColumn(name="post_id")
    public Post post;

    public static Finder<Long, Tagpost> findwithpost = new Finder<Long,Tagpost>(Tagpost.class);

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
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

    public Tagpost(String tag) {
        super();
        this.tag = tag;
    }

    public Tagpost() {
    }

    public String toJson() {
        return "{\"id\":\"" + id + "\", \"tag\":\"" + tag + "\"}";
    }
}

