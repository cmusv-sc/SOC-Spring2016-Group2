import java.util.ArrayList;
import java.util.List;


public class Article {
	private String title;
	private String mdate;
	private String key;
	private List<String> authors;
	private String pages;
	private String year;
	private String volume;
	private String journal;
	private String number;
	private String url;
	private String ee;
	
	public Article(){
		this.authors = new ArrayList<String>();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
		this.mdate = mdate;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public String getAuthorsToString(){
		StringBuilder sb = new StringBuilder();
		for(String author : this.authors)
			sb.append(author + "@");
		return sb.toString();
	}
	
	public void addAuthors(String author) {
		this.authors.add(author);
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getJournal() {
		return journal;
	}

	public void setJournal(String journal) {
		this.journal = journal;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getEe() {
		return ee;
	}

	public void setEe(String ee) {
		this.ee = ee;
	}
	
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("title: " + this.title + "\t");
		stringBuffer.append("mdate: " + this.mdate + "\t");
		stringBuffer.append("key: " + this.key + "\t");
		stringBuffer.append("authors: " + this.getAuthorsToString() + "\t");
		stringBuffer.append("pages: " + this.pages + "\t");
		stringBuffer.append("year: " + this.year + "\t");
		stringBuffer.append("volume: " + this.volume + "\t");
		stringBuffer.append("journal: " + this.journal + "\t");
		stringBuffer.append("number: " + this.number + "\t");
		stringBuffer.append("url: " + this.url + "\t");
		stringBuffer.append("ee: " + this.ee);
		return stringBuffer.toString();
	}
}
