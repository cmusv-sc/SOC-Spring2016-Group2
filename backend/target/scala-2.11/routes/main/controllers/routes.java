
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/ThomasHsu/Desktop/SSNetwork/backend/conf/routes
// @DATE:Sat Apr 23 13:33:00 PDT 2016

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseTagController TagController = new controllers.ReverseTagController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseThumbController ThumbController = new controllers.ReverseThumbController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseApplication Application = new controllers.ReverseApplication(RoutesPrefix.byNamePrefix());
  public static final controllers.ReversePostController PostController = new controllers.ReversePostController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseForumController ForumController = new controllers.ReverseForumController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseTagController TagController = new controllers.javascript.ReverseTagController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseThumbController ThumbController = new controllers.javascript.ReverseThumbController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseApplication Application = new controllers.javascript.ReverseApplication(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReversePostController PostController = new controllers.javascript.ReversePostController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseForumController ForumController = new controllers.javascript.ReverseForumController(RoutesPrefix.byNamePrefix());
  }

}
