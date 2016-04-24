package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;


@Entity(name="AccessComStatus")
public class AccessComStatus extends Model {
    @Id
public long parentid;
public boolean status;

public AccessComStatus( long parentid, boolean status){
        this.status = true;
        this.parentid = parentid;

    }
    public long parentid() {
      return parentid;
    }

    public void parentid(long publicationID) {
      this.parentid = parentid;
    }

    public boolean isStatus() {
      return status;
  }

  public void setStatus(boolean status) {
      this.status = status;
  }

    public AccessComment(){

    }

    public static Finder<Long, AccessComment> find = new Finder<Long, AccessComment>(Long.class, AccessComment.class);
}
