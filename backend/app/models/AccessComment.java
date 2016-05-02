package models;

 import com.avaje.ebean.Model;

 import javax.persistence.Entity;
 import javax.persistence.Id;
 import java.util.ArrayList;
 import java.util.List;


 @Entity(name="AccessComment")
 public class AccessComment extends Model {
     @Id
 public long publicationID;
 public boolean status;

public AccessComment(long publicationID, boolean status){
         this.status = status;
         this.publicationID = publicationID;

     }
     public long getPublicationID() {
       return publicationID;
     }

     public void setPublicationID(long publicationID) {
       this.publicationID = publicationID;
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
