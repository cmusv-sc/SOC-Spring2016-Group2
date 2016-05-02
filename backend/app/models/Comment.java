
package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;


@Entity(name="comment")
public class Comment extends Model {
    @Id
    private int id;

    private int parentid;
    private String authorid;
    private String content;
    private Long time;
    private int rootid;
    private int categoryid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    public String getAuthorid() {
        return authorid;
    }

    public void setAuthorid(String authorid) {
        this.authorid = authorid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public int getRootid() {
        return rootid;
    }

    public void setRootid(int rootid) {
        this.rootid = rootid;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public Comment(int id, int parentid, String authorid, String content, Long time, int rootid, int categoryid) {
        this.parentid = parentid;
        this.authorid = authorid;
        this.content = content;
        this.time = time;
        this.rootid = rootid;
        this.categoryid = categoryid;
    }

    public Comment(){
    }

    public static Finder<Integer, Comment> find = new Finder<Integer, Comment>(Integer.class, Comment.class);
}