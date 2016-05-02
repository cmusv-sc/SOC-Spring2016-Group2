package controllers;

import models.*;
import play.mvc.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import play.api.Logger;
import static play.data.Form.form;
import static play.libs.Json.toJson;
import java.util.HashMap;
import java.io.Console;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;

public class PublicationController extends Controller
{
  public  Result UpdatePublication(Long pub_id, String title, String editor,
                                   String year, String isbn,
                                   String volume, String pages, String mdate,
                                   String series, String publisher, String booktitle,
                                   String crossref, String ee, String author){

    Publication publication = Publication.find.byId(pub_id);

    //if (!title.isEmpty()) {
      publication.setTitle(title);
    //}
    //if (!editor.isEmpty()) {
      publication.setEditor(editor);
    //}
    //if (!year.isEmpty()) {
      publication.setYear(year);
    //}
    //if (!isbn.isEmpty() ) {
      publication.setIsbn(isbn);
    //}
    //if (!url.isEmpty() ) {
    //if (!volume.isEmpty()) {
      publication.setVolume(volume);
    //}
    //if (!pages.isEmpty() ) {
      publication.setPages(pages);
    //}
    //if (!mdate.isEmpty() ) {
      publication.setMdate(mdate);
    //}
    //if (!series.isEmpty() ) {
      publication.setSeries(series);
    //}
    //if (!publisher.isEmpty() ) {
      publication.setPublisher(publisher);
    //}
    //if (!booktitle.isEmpty() ) {
      publication.setBooktitle(booktitle);
    //}
    //if (!crossref.isEmpty() ) {
      publication.setCrossref(crossref);
    //}
    //if (!ee.isEmpty() ) {
      publication.setEe(ee);
    //}
    //if (!author.isEmpty() ) {
      String[] author_array = author.split(",");
      List<PublicationAuthor> publication_author = PublicationAuthor.find(pub_id, null);

      // Clean the exsiting publication_author pair in the database.
      for (int i = 0; i < publication_author.size(); ++i) {
        publication_author.get(i).delete();
      }

      // Save the new publication_author pair in the database.
      for (int i = 0; i < author_array.length; ++i) {
        String author_name = author_array[i];
        author_name.trim();
        List<Long> author_ids = Author.find_Author_Id(author_name);
        long author_id;

        // If the author name does not exists, generate a random id for the author name.
        if (author_ids.size() == 0) {
          Random r = new Random();
          author_id = r.nextLong();
          if (author_id < 0) {
            author_id *= -1;
          }
          // Save the author into database;
          Author new_author = new Author();
          new_author.setName(author_name);
          new_author.setId(author_id);
          new_author.save();
        } else {
          author_id = author_ids.get(0);
        }
        PublicationAuthor data = new PublicationAuthor(pub_id, author_id);
        data.save();
      }
    //}

    publication.save();
    HashMap<String, String> msg = new HashMap<String, String>();
    msg.put("title", publication.title);

    return ok(toJson(msg));
  }
}
