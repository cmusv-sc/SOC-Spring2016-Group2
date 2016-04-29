package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Meng on 4/26/16.
 */
@Entity(name="group_notice")
public class GroupNotice extends Model {
    @Id
    public Long id;
    public String sender;
    public Long group_id;
    public String groupname;
    public String receiver;

    public static Model.Finder<Long, GroupNotice> find
            = new Model.Finder<>(Long.class, GroupNotice.class);
    /***
     *  you are responsible for calling their close() method somewhere in your code
     *  so that they can be immediately returned to the pool.
     */

    public GroupNotice(String sender, Long group_id, String receiver){
        this.sender=sender;
        this.group_id=group_id;
        this.receiver=receiver;
    }
    public void setGroupname(String groupname){
        this.groupname = groupname;
    }

}

