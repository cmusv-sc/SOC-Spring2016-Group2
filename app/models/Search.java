package models;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by caoyi on 4/13/16.
 */
@Entity
public class Search {



    String keywords;
    String searchType;

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

    private String id;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public Search(){
       this.keywords="";
       this.searchType="";
    }
}
