package models;
import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Meng on 4/19/16.
 */
@Entity(name="user_group")
public class UserGroup extends Model {

    @Id
    public Long id;
    public String groupname;
    public String createrid;
    public String intro;
    public String type;

    public static Finder<Long, UserGroup> find
            = new Model.Finder<>(Long.class, UserGroup.class);
    /***
     *  you are responsible for calling their close() method somewhere in your code
     *  so that they can be immediately returned to the pool.
     */
    public UserGroup(String createrid, String groupname, String intro, String type){
        this.groupname=groupname;
        this.createrid=createrid;
        this.intro = intro;
        this.type = type;
    }

    public String getGroupname(){
        return groupname;
    }

}
