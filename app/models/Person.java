package models;

import com.avaje.ebean.Model;
import play.data.format.Formats;
import javax.persistence.*;
import java.util.Date;

@Entity(name="person")
public class Person extends Model {
	
    @Id
	public Long id;

    public String name;

    @Formats.DateTime(pattern="dd/MM/yyyy")
    public Date dueDate = new Date();

    
    /***
     *  you are responsible for calling their close() method somewhere in your code
     *  so that they can be immediately returned to the pool.
     */

    public Person(Long id, Date date, String name){
        this.id=id;
        this.dueDate=date;
        this.name=name;
    }

    public Person() {
    	this.dueDate = new Date("01/01/2011");
    	this.name = "";
    }

    public static Finder<Long, Person> find = new Finder<Long,Person>(Person.class);

    public void setId(Long id){
        this.id=id;
    }

    public void setDueDate(Date newdate){
        this.dueDate=newdate;
    }

    public void setName(String name){
        this.name=name;
    }

    public Long getId(){
        return id;
    }
    
    public Date getDueDate(){
        return dueDate;
    }
    
    public String getName(){
        return  name;
    }


    /****
     * If validation passes you must return null . Returning any non-null value
     * (empty string or empty list) is treated as failed validation.
     * @return
     */

    //override the validate function if there is more than one judge

    /*public List<ValidationError> validate() {
        List<ValidationError> errors = new ArrayList<ValidationError>();
        if (Person.byName(name) != null) {
            errors.add(new ValidationError("name", "the name is already exists!"));
        }
        if (authenticate(name) == null) {
            errors.add(new ValidationError("name", "invalid name format!"));
        }
        return errors.isEmpty() ? null : errors;
    }*/

}
