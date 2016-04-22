import com.google.common.collect.ImmutableMap;
import controllers.SAXETL;
import models.Author;
import play.*;

import play.db.Database;
import play.db.Databases;
import play.db.evolutions.Evolution;
import play.db.evolutions.Evolutions;

import java.util.List;

/**
 * Created by caoyi on 4/12/16.
 */
public class Global extends GlobalSettings {



    @Override
    public void onStart(Application app) {
        String message = "Application has started! LOLADA";
        Logger.info(message);
        List<Author> allauthors=Author.findAll();
        if(allauthors!=null){
            //SAXETL.loadData();
            System.out.println("Data load successfully!");
        }

    }
    @Override
    public void onStop(Application app) {
        String message = "Application shutdown...!!! LOLADA";
        Logger.info(message);
        System.out.println(message);
    }

}
