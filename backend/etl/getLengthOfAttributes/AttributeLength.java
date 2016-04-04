import java.util.List;

/**
 * Author: Lunwen He
 * Date: 04/02/2016
 * */

/**
 * This class defines the max length of each attribute
 * of an article. Why do we need the max length of each
 * attribute? Because we need the max length of each 
 * attribute to define the length of each column in database
 * */
public class AttributeLength {
	private int titleLength;
	private int mdateLength;
	private int keyLength;
	private int authorLength;
	private int pagesLength;
	private int yearLength;
	private int volumeLength;
	private int journalLength;
	private int numberLength;
	private int urlLength;
	private int eeLength;
	
	public AttributeLength() {
		
	}

	public int getTitleLength() {
		return titleLength;
	}

	public void setTitleLength(int titleLength) {
		this.titleLength = titleLength > this.titleLength ? titleLength : this.titleLength;
	}

	public int getMdateLength() {
		return mdateLength;
	}

	public void setMdateLength(int mdateLength) {
		this.mdateLength = mdateLength > this.mdateLength ? mdateLength : this.mdateLength;
	}

	public int getKeyLength() {
		return keyLength;
	}

	public void setKeyLength(int keyLength) {
		this.keyLength = keyLength > this.keyLength ? keyLength : this.keyLength;
	}

	public int getauthorLength() {
		return authorLength;
	}

	public void setauthorLength(int authorLength) {
		this.authorLength = authorLength > this.authorLength ? authorLength : this.authorLength;
	}

	public int getPagesLength() {
		return pagesLength;
	}

	public void setPagesLength(int pagesLength) {
		this.pagesLength = pagesLength > this.pagesLength ? pagesLength : this.pagesLength;
	}

	public int getYearLength() {
		return yearLength;
	}

	public void setYearLength(int yearLength) {
		this.yearLength = yearLength > this.yearLength ? yearLength : this.yearLength;
	}

	public int getVolumeLength() {
		return volumeLength;
	}

	public void setVolumeLength(int volumeLength) {
		this.volumeLength = volumeLength > this.volumeLength ? volumeLength : this.volumeLength;
	}

	public int getJournalLength() {
		return journalLength;
	}

	public void setJournalLength(int journalLength) {
		this.journalLength = journalLength > this.journalLength ? journalLength : this.journalLength;
	}

	public int getNumberLength() {
		return numberLength;
	}

	public void setNumberLength(int numberLength) {
		this.numberLength = numberLength > this.numberLength ? numberLength : this.numberLength;
	}

	public int getUrlLength() {
		return urlLength;
	}

	public void setUrlLength(int urlLength) {
		this.urlLength = urlLength > this.urlLength ? urlLength : this.urlLength;
	}

	public int getEeLength() {
		return eeLength;
	}

	public void setEeLength(int eeLength) {
		this.eeLength = eeLength > this.eeLength ? eeLength : this.eeLength;
	}
	
	public String toString() {
		
		StringBuffer stringBuffer = new StringBuffer();
		
		stringBuffer.append("Max title length:\t" + this.titleLength + "\n");
		stringBuffer.append("Max mdate length:\t" + this.mdateLength + "\n");
		stringBuffer.append("Max key length:\t" + this.keyLength + "\n");
		stringBuffer.append("Max author length:\t" + this.authorLength + "\n");
		stringBuffer.append("Max pages length:\t" + this.pagesLength + "\n");
		stringBuffer.append("Max year length:\t" + this.yearLength + "\n");
		stringBuffer.append("Max volume length:\t" + this.volumeLength + "\n");
		stringBuffer.append("Max journal length:\t" + this.journalLength + "\n");
		stringBuffer.append("Max number length:\t" + this.numberLength + "\n");
		stringBuffer.append("Max url length:\t" + this.urlLength + "\n");
		stringBuffer.append("Max ee length:\t" + this.eeLength + "\n");
		
		return stringBuffer.toString();
	}
}
