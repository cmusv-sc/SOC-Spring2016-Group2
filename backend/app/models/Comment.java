package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;


@Entity(name="comment")
public class Comment extends Model {
    @Id
    private Long id;

    private Long parentid;
    private Long authorid;
    private String content;
    private Date time;
    private Long rootid;
    private Long categoryid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public Long getAuthorid() {
        return authorid;
    }

    public void setAuthorid(Long authorid) {
        this.authorid = authorid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Long getRootid() {
        return rootid;
    }

    public void setRootid(Long rootid) {
        this.rootid = rootid;
    }

    public Long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    public Comment(Long id, Long parentid, Long authorid, String content, Date time, Long rootid, Long categoryid) {
        this.parentid = parentid;
        this.authorid = authorid;
        this.content = content;
        this.time = time;
        this.rootid = rootid;
        this.categoryid = categoryid;
    }

    public Comment(){
    }

    public static Finder<Long, Comment> find = new Finder<Long, Comment>(Long.class, Comment.class);

    
}
