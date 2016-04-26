package models;

import javax.persistence.*;

import com.avaje.ebean.Model;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;

import java.util.ArrayList;
import java.util.List;

/**
 * This class defines one record in publications table
 * */
@Entity(name="publications")
public class Publication extends Model {
	@Id
	@Column(name="pub_id")
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


	public static List<Publication>  find(String str, Integer year, String title, List<Long> pubids) {
		List<Publication> publications=new ArrayList<Publication>();
		if(str==null){
			List<Publication> publications1=find.where().eq("title",title).findList();
			publications.addAll(publications1);
			return  publications;
		} else  if(str.equals("byYear")){
			publications=find.where()
					.eq("year",year)
					.findList();
			return publications;

		}else if(str.equals("byTitle")){
			publications=find.where().eq("title",title).findList();
			return publications;
		}else  if(str.equals("byId")){
			for(long id: pubids){
				publications.add(find.where().eq("id",id).findUnique());
			}
			return  publications;
		}else{
			return null;
		}
	}
	public static List<Publication> findAll(){
		return find.all();

	}

	public static List<ObjectNode> findPubDetails(List<Publication> publications, List<ObjectNode> results, String str){
		for(Publication publication : publications) {
			// System.out.println(publication.toString());
			ObjectNode result = Json.newObject();
			List<PublicationAuthor> authorids=PublicationAuthor.find(publication.getId(),null);
			List<Author> authors=Author.find(authorids);
			StringBuilder sb=new StringBuilder();
			for(Author author: authors){
				sb.append(author+";");
			}
			List<Comment> comments = Comment.find.where().eq("rootid", publication.getId()).findList();
			List<Tagpub> tags = Tagpub.findwithpublication.where().eq("pub_id", publication.getId()).findList();
			result.put("GsearchResultClass",str);
			result.put("popularity",comments.size()+tags.size());
			result.put("authors",sb.toString());
			result.put("title", publication.getTitle());
			result.put("editor", publication.getEditor());
			result.put("booktitle",publication.getBooktitle());
			result.put("isbn", publication.getIsbn());
			result.put("year",publication.getYear());
			result.put("crossref",publication.getCrossref());
			result.put("ee",publication.getEe());
			result.put("url",publication.getUrl());
			result.put("series",publication.getSeries());
			result.put("volume",publication.getVolume());
			results.add(result);
		}
		return  results;
	}
	public static List<ObjectNode> findAuthors(List<Publication> publications, List<ObjectNode> results, String str){
		for(Publication publication : publications) {
			// System.out.println(publication.toString());
			ObjectNode result = Json.newObject();
			List<PublicationAuthor> authorids=PublicationAuthor.find(publication.getId(),null);
			List<Author> authors=Author.find(authorids);
			StringBuilder sb=new StringBuilder();
			for(Author author: authors){
				sb.append(author+";");
			}
			result.put("GsearchResultClass",str);
			result.put("authors",sb.toString());
			//System.out.println(sb.toString());
			results.add(result);
		}
		return  results;
	}

		//============tagging===================
		@OneToMany(mappedBy = "publication", cascade = CascadeType.ALL)
		@JsonManagedReference
		public List<Tagpub> tagpubs;

		public List<Tagpub> getTagpubs () {
			return tagpubs;
		}

	public void setTagpubs(List<Tagpub> tagpubs) {
		this.tagpubs = tagpubs;
	}

	public static Finder<Long, Publication> findwithtagpub = new Finder<Long, Publication>(Publication.class);

	public static List<ObjectNode> findPubDetails(List<Publication> publications) {
		List<ObjectNode> results = new ArrayList<ObjectNode>();
		for (Publication publication : publications) {
			ObjectNode result = Json.newObject();
			List<PublicationAuthor> authorids = PublicationAuthor.find(publication.getId(), null);
			List<Author> authors = Author.find(authorids);
			StringBuilder sb = new StringBuilder();
			for (Author author : authors) {
				sb.append(author + ";");
			}

			result.put("authors", sb.toString());
			result.put("title", publication.getTitle());
			result.put("editor", publication.getEditor());
			result.put("booktitle", publication.getBooktitle());
			result.put("isbn", publication.getIsbn());
			result.put("year", publication.getYear());
			result.put("crossref", publication.getCrossref());
			result.put("ee", publication.getEe());
			result.put("url", publication.getUrl());
			result.put("series", publication.getSeries());
			result.put("volume", publication.getVolume());
			results.add(result);
		}
		return results;
	}

	//============tagging===================


	public static List<Publication> findPublicationById(Long publicationId) {

		return find.where().eq("id", publicationId).findList();

	}

}