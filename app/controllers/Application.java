package controllers;

import com.google.gson.Gson;

import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {

    public Result index() {

        return ok(new Gson().toJson("welcome"));
    }
}