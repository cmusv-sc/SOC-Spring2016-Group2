import controllers.SAXETL;
import models.Author;
import play.*;

import java.util.List;

/**
 * Created by caoyi on 4/12/16.
 */
public class Global extends GlobalSettings {

    @Override
    public void onStart(Application app) {
        String message = "Application has started! LOLADADA";
      //  SAXETL.loadData();
 /*       Logger.info(message);
        List<Author> allauthors=Author.find.all();
        if(allauthors!=null){
            SAXETL.loadData();
            System.out.println("Data load successfully!");
        }*/
    }

    @Override
    public void onStop(Application app) {
        String message = "Application shutdown...!!!";
        Logger.info(message);
        System.out.println(message);
    }
}
