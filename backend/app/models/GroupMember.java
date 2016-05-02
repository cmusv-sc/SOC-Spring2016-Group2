package models;
import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
/**
 * Created by Meng on 4/21/16.
 */
@Entity(name="group_member")
public class GroupMember extends Model {

    @Id
    public Long id;
    public String member_id;
    public Long group_id;
    public static Finder<Integer, GroupMember> find
            = new Model.Finder<>(Integer.class, GroupMember.class);
    /***
     *  you are responsible for calling their close() method somewhere in your code
     *  so that they can be immediately returned to the pool.
     */

    public GroupMember(String memberid, Long groupid){
        this.member_id=memberid;
        this.group_id=groupid;
    }

    public String getMemberId(){
        return member_id;
    }


}