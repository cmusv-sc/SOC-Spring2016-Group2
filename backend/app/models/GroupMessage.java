package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
/**
 * Created by Meng on 4/22/16.
 */
@Entity(name="group_message")
public class GroupMessage extends Model {
    @Id
    public Long id;
    public String member_id;
    public Long group_id;
    public String title;
    public String message;

    public static Finder<Integer, GroupMessage> find
            = new Model.Finder<>(Integer.class, GroupMessage.class);
    /***
     *  you are responsible for calling their close() method somewhere in your code
     *  so that they can be immediately returned to the pool.
     */

    public GroupMessage(String memberid, Long groupid,String title, String message){
        this.member_id=memberid;
        this.group_id=groupid;
        this.title = title;
        this.message = message;
    }


}
