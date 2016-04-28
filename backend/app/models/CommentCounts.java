package models;

/**
 * Created by guoqing on 16/4/27.
 */

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;


@Entity(name="commentcounts")
public class CommentCounts extends Model {
    @Id
    private int id;

    private int rootid;
    private int counts;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCounts() {
        return counts;
    }

    public void setCounts(int parentid) {
        this.counts = counts;
    }

    public int getRootid() {
        return rootid;
    }

    public void setRootid(int rootid) {
        this.rootid = rootid;
    }

    public CommentCounts(int id, int rootid, int counts) {

        this.rootid = rootid;
        this.counts = counts;
    }

    public CommentCounts(){
    }

    public static Finder<Integer, CommentCounts> find = new Finder<Integer, CommentCounts>(Integer.class, CommentCounts.class);
}

