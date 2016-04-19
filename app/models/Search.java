package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.avaje.ebean.Model;

/**
 * Created by caoyi on 4/13/16.
 */
@Entity(name="search")
public class Search extends Model {

    @Id
    public Long id;

    public String keywords;
    
    public String searchType;

    public Search(){
        this.keywords="";
        this.searchType="";
     }
    
    public Search(String keywords, String searchType) {
    	this.keywords = keywords;
    	this.searchType = searchType;
    }
    
    public String getKeywords() {
        return keywords;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
