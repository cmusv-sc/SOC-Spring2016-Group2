package models;

import com.avaje.ebean.Model;
import controllers.Application;
import play.api.db.DB;
import play.data.format.Formats;
import play.data.validation.Constraints;
import play.data.validation.ValidationError;

import javax.persistence.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Person extends Model {
    /***
     *  you are responsible for calling their close() method somewhere in your code
     *  so that they can be immediately returned to the pool.
     */

    public Person(Long id, Date date, String name){
        this.id=id;
        this.dueDate=date;
        this.name=name;
    }


    @Id
	public Long id;

    public String name;

    @Formats.DateTime(pattern="dd/MM/yyyy")
    public Date dueDate = new Date();

    public static Finder<Long, Person> find = new Finder<Long,Person>(Person.class);

    public Person() {
    }


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
