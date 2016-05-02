import controllers.SAXETL;
import models.Author;
import models.UserProfile;
import controllers.UserProfileController;
import play.*;

import java.util.List;

/**
 * Created by caoyi on 4/12/16.
 */
public class Global extends GlobalSettings {

    @Override
    public void onStart(Application app) {
        String message = "Application has started! LOLADADA";
        Logger.info(message);
        if(Author.find.all().size() == 0 && UserProfile.findAll().size() == 0){
            List<Author> allauthors=Author.find.all();
            if(allauthors == null || allauthors.size() <= 0){
                SAXETL.loadData();
                System.out.println("Data load successfully!");
            }
            UserProfileController userProfileController =
                    new UserProfileController();
            userProfileController.createAllUserProfile();
        }

    }

    @Override
    public void onStop(Application app) {
        String message = "Application shutdown...!!!";
        Logger.info(message);
        System.out.println(message);
    }
}
