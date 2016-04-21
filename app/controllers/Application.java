package controllers;


import com.avaje.ebean.Model;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import com.google.common.collect.ImmutableMap;
import models.*;
import org.w3c.dom.Document;
import play.data.Form;
import play.db.Database;
import play.db.Databases;
import play.libs.Json;
import play.libs.XPath;
import play.mvc.*;
import views.html.*;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static play.data.Form.form;
import static play.libs.Json.toJson;

public class Application extends Controller {
  // final static Form<Search> search_form=form(Search.class);

    public Result index() {
       // Form<Search> filledform=search_form.bindFromRequest();
       // filledform.fill(new Search());
        return ok(index.render());
    }

    public  Result addPerson() {
        Person person = form(Person.class).bindFromRequest().get();
        System.out.println("hhhhh"+person.name);
       // person.setName("zhangjia");
        Form personForm= form(Person.class);
        //set existing value into the form
       // personForm=personForm.fill(new Person(Long.valueOf(100),new Date(), "yile"));
        person.save();
        return redirect(routes.Application.index());
    }

    public  Result getPersons() {
        Person person = form(Person.class).bindFromRequest().get();
         System.out.println("person"+person);
        Http.RequestBody requestBody=request().body();
        System.out.println(requestBody.asText());
        List<Person> persons = new Model.Finder(String.class, Person.class).all();
        persons.add(0,new Person((long)1, new Timestamp(0), "zhangs"));
        return ok(toJson(persons));
    }

    /***
     * You can use a DynamicForm if you need to retrieve data
     * from an html form that is not related to a Model:
     * @return
     */
//    public  Result hello() {
//        DynamicForm requestData = FormFactory.form().bindFromRequest();
//        String firstname = requestData.get("firstname");
//        String lastname = requestData.get("lastname");
//        return ok("Hello " + firstname + " " + lastname);
//    }

    public Result getPersonById(Long id){
        JsonNode json = request().body().asJson();
        System.out.println(request().body().asText());
        Person person=Person.find.byId(id);
        System.out.println(person.name);
        return ok(toJson(person));

    }

    /****
     *
     * 主要的方法
     * @return
     */
    @BodyParser.Of(BodyParser.Json.class)
    public Result sayHello() {
        JsonNode json = request().body().asJson();
        String name = json.findPath("name").textValue();
        if(name == null) {
            return badRequest("Missing parameter [name]");
        } else {
             //send json data
            ObjectNode result = Json.newObject();
            result.put("exampleField1", "foobar");
            result.put("exampleField2", "Hello world!");
            return ok(result);
            //set new json data to
            //return ok("Hello " + name);
        }
    }

    /***
     *
     * This method is used to access xml file
     * @return
     */
    @BodyParser.Of(BodyParser.Xml.class)
    public Result sayHello2() {
        Document dom = request().body().asXml();
        if (dom == null) {
            return badRequest("Expecting Xml data");
        } else {
            String name = XPath.selectText("//name", dom);

                if (name == null) {
                    return badRequest("<message \"status\"=\"KO\">Missing parameter [name]</message>").as("application/xml");
                } else {
                    return ok("<message \"status\"=\"OK\">Hello " + name + "</message>").as("application/xml");
                }

        }
    }


    /***
     * This method is used to upload a file
     */
    public  Result upload() {
        play.mvc.Http.MultipartFormData<File> body = request().body().asMultipartFormData();
        play.mvc.Http.MultipartFormData.FilePart<File> picture = body.getFile("picture");
        if (picture != null) {
            String fileName = picture.getFilename();
            String contentType = picture.getContentType();
            java.io.File file = picture.getFile();

            return ok(file).as("image/png");
        } else {
            flash("error", "Missing file");
            return badRequest();
        }
    }


    /***
     * This method is used to find the paper by year
     */

    public Result getPaperByYear(int year) {
//        System.out.println(request().body().asText());
//        int year=Integer.parseInt(request().body().asText());
        System.out.println(year);
        List<ObjectNode> results=new ArrayList<ObjectNode>();
        List<Publication> publications = Publication.find("byYear", year, null);
        System.out.println("There are " + publications.size() + " publication"+year);
        for(Publication publication : publications) {
           // System.out.println(publication.toString());
            ObjectNode result = Json.newObject();
            List<PublicationAuthor> authorids=PublicationAuthor.find(publication.getId(),null);
            List<Author> authors=Author.find(authorids);
            StringBuilder sb=new StringBuilder();
            for(Author author: authors){
                sb.append(author+";");
            }
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
        return ok(Json.toJson(results));
    }

    public Result getPaperByTitle(String title){
//        String title=request().body().asText();
//        System.out.println(title);
        List<Publication> publications = Publication.find("byTitle", null, title);

        List<ObjectNode> results=new ArrayList<ObjectNode>();
        System.out.println("There are " + publications.size() );
        for(Publication publication : publications) {
            // System.out.println(publication.toString());
            ObjectNode result = Json.newObject();
            List<PublicationAuthor> authorids=PublicationAuthor.find(publication.getId(),null);
            System.out.println(authorids);
             List<Author> authors=Author.find(authorids);
            StringBuilder sb=new StringBuilder();
            for(Author author: authors){
                System.out.println(author);
                 sb.append(author+";");
            }
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
        return ok(Json.toJson(results));
    }
//
//    public Result submit(){
//    // Form<Search> filledform=search_form.bindFromRequest();
//        Search search=filledform.get();
//        ObjectNode result=Json.newObject();
//        result.put("keyword",search.getKeywords());
//        result.put("searchtype",search.getSearchType());
//        return ok(Json.toJson(result));
//    }


}
