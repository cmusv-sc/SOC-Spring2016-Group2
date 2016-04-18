package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.avaje.ebean.Model;

import java.util.List;

/**
 * This class defines one record in publications table
 * */
@Entity(name="publication")
public class Publication extends Model {
	@Id
	public Long id;
	public String pubkey;
	public String title;
	public String editor;
	public String year;
	public String isbn;
	public String url;
	public String volume;
	public String pages;
	public String mdate;
	public String series;
	public String publisher;
	public String booktitle;
	public String crossref;
	public String ee;
	
	public Publication(
			String pubkey,
			String title,
			String editor,
			String year,
			String isbn,
			String url,
			String volume,
			String pages,
			String mdate,
			String series,
			String publisher,
			String booktitle,
			String crossref,
			String ee			
			) {
		this.pubkey = pubkey;
		this.title = title;
		this.editor = editor;
		this.year = year;
		this.isbn = isbn;
		this.url = url;
		this.volume = volume;
		this.pages = pages;
		this.mdate = mdate;
		this.series = series;
		this.publisher = publisher;
		this.booktitle = booktitle;
		this.crossref = crossref;
		this.ee = ee;
	}
	
	/* the default vaule for each attribute is empty */
	public Publication() {
		this.pubkey = "";
		this.title = "";
		this.editor = "";
		this.year = "";
		this.isbn = "";
		this.url = "";
		this.volume = "";
		this.pages = "";
		this.mdate = "";
		this.series = "";
		this.publisher = "";
		this.booktitle = "";
		this.crossref = "";
		this.ee = "";
	}
	
	/*
	 * Get the string representation of publication
	 * @return	the string representation of publication
	 * */
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("Publication detail: \n");
		stringBuffer.append("\tTitle:\t" + this.title + "\n");
		stringBuffer.append("\tKey:\t" + this.pubkey + "\n");
		stringBuffer.append("\tEditor:\t" + this.editor + "\n");
		stringBuffer.append("\tYear:\t" + this.year + "\n");
		stringBuffer.append("\tIsbn:\t" + this.isbn + "\n");
		stringBuffer.append("\tURL:\t" + this.url + "\n");
		stringBuffer.append("\tVolume:\t" + this.volume + "\n");
		stringBuffer.append("\tPages:\t" + this.pages + "\n");
		stringBuffer.append("\tMdate:\t" + this.mdate + "\n");
		stringBuffer.append("\tSeries:\t" + this.series + "\n");
		stringBuffer.append("\tPublisher:\t" + this.publisher + "\n");
		stringBuffer.append("\tBooktitle:\t" + this.booktitle + "\n");
		stringBuffer.append("\tCrossref:\t" + this.crossref + "\n");
		stringBuffer.append("\tEE:\t" + this.ee);
		return stringBuffer.toString();
	}
	
	/**
	 * We can define our own getter and setter, even though play
	 * will generate them automatically. Here is the reference
	 * comes from: 
	 * https://www.playframework.com/documentation/1.0.1/model
	 * 
	 * You can’t directly use getter and setter methods to access 
	 * properties if you rely on automatic generation. These methods
	 * are generated at runtime. So if you reference them in code 
	 * you write, the compiler won’t find the methods and will 
	 * generate an error. Of course you can define the getter and 
	 * setter methods yourself. If a method exists play will use the 
	 * existing accessors.
	 * */
	public String getPubkey() {
		return pubkey;
	}

	public void setPubkey(String pubkey) {
		this.pubkey = pubkey;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
		this.mdate = mdate;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getBooktitle() {
		return booktitle;
	}

	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}

	public String getCrossref() {
		return crossref;
	}

	public void setCrossref(String crossref) {
		this.crossref = crossref;
	}

	public String getEe() {
		return ee;
	}

	public void setEe(String ee) {
		this.ee = ee;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public static Finder<Long,Publication> find = new Finder<Long,Publication>(Long.class, Publication.class);
	
	public static List<Publication>  find(String str, Integer year, String title) {
		if(str.equals("byYear")){
			return find.where()
					.eq("year",year)
					.findList();

		}
		if(str.equals("byTitle")){
			return find.where().eq("title",title).findList();
		}else{
			return null;
		}
	}


	public static List<Publication>  findPublicationById(Long publicationId) {

    			return find.where().eq("id",publicationId).findList();

    }
}
