
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/Anna/Documents/graduate2/soc/SSNetwork/backend/conf/routes
// @DATE:Sun Apr 24 14:28:07 PDT 2016

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  Application_4: controllers.Application,
  // @LINE:9
  Assets_3: controllers.Assets,
  // @LINE:24
  ForumController_1: controllers.ForumController,
  // @LINE:30
  PostController_2: controllers.PostController,
  // @LINE:39
  SubscriptionController_0: controllers.SubscriptionController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    Application_4: controllers.Application,
    // @LINE:9
    Assets_3: controllers.Assets,
    // @LINE:24
    ForumController_1: controllers.ForumController,
    // @LINE:30
    PostController_2: controllers.PostController,
    // @LINE:39
    SubscriptionController_0: controllers.SubscriptionController
  ) = this(errorHandler, Application_4, Assets_3, ForumController_1, PostController_2, SubscriptionController_0, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Application_4, Assets_3, ForumController_1, PostController_2, SubscriptionController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.Application.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """person/uploadPic""", """controllers.Application.upload()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """year/""" + "$" + """year<[^/]+>""", """controllers.Application.getPaperByYear(year:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """title/""" + "$" + """title<[^/]+>""", """controllers.Application.getPaperByTitle(title:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """comment""", """controllers.ForumController.addComment()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """comment""", """controllers.ForumController.getComments(rootid:Long, categoryid:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateComment""", """controllers.ForumController.updateComment()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """upload""", """controllers.ForumController.uploadFile()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """post/addPost""", """controllers.PostController.addPost()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """post/getPostById/""" + "$" + """postId<[^/]+>""", """controllers.PostController.getPostById(postId:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """post/getAllPosts""", """controllers.PostController.getAllPosts()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """post/addComment""", """controllers.PostController.addComment()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """post/setAsQuestion""", """controllers.PostController.setAsQuestion()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """post/setAnswer""", """controllers.PostController.setAnswer()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """subscribe/list/all""", """controllers.SubscriptionController.loadSubscriptionList()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """subscribe/list/""" + "$" + """category<[^/]+>""", """controllers.SubscriptionController.loadSubscriptionListByCategory(category:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """subscribe/timeline""", """controllers.SubscriptionController.loadTimeline()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """subscribe/""" + "$" + """followeeid<[^/]+>/""" + "$" + """category<[^/]+>""", """controllers.SubscriptionController.subscribe(followeeid:Long, category:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_Application_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_Application_index0_invoker = createInvoker(
    Application_4.index(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "index",
      Nil,
      "GET",
      """ Home page""",
      this.prefix + """"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_Assets_at1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at1_invoker = createInvoker(
    Assets_3.at(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/""" + "$" + """file<.+>"""
    )
  )

  // @LINE:11
  private[this] lazy val controllers_Application_upload2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("person/uploadPic")))
  )
  private[this] lazy val controllers_Application_upload2_invoker = createInvoker(
    Application_4.upload(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "upload",
      Nil,
      "POST",
      """""",
      this.prefix + """person/uploadPic"""
    )
  )

  // @LINE:19
  private[this] lazy val controllers_Application_getPaperByYear3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("year/"), DynamicPart("year", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_getPaperByYear3_invoker = createInvoker(
    Application_4.getPaperByYear(fakeValue[Integer]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getPaperByYear",
      Seq(classOf[Integer]),
      "GET",
      """##Sprint1""",
      this.prefix + """year/""" + "$" + """year<[^/]+>"""
    )
  )

  // @LINE:20
  private[this] lazy val controllers_Application_getPaperByTitle4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("title/"), DynamicPart("title", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_getPaperByTitle4_invoker = createInvoker(
    Application_4.getPaperByTitle(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getPaperByTitle",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """title/""" + "$" + """title<[^/]+>"""
    )
  )

  // @LINE:24
  private[this] lazy val controllers_ForumController_addComment5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("comment")))
  )
  private[this] lazy val controllers_ForumController_addComment5_invoker = createInvoker(
    ForumController_1.addComment(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ForumController",
      "addComment",
      Nil,
      "POST",
      """## Forum""",
      this.prefix + """comment"""
    )
  )

  // @LINE:25
  private[this] lazy val controllers_ForumController_getComments6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("comment")))
  )
  private[this] lazy val controllers_ForumController_getComments6_invoker = createInvoker(
    ForumController_1.getComments(fakeValue[Long], fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ForumController",
      "getComments",
      Seq(classOf[Long], classOf[Long]),
      "GET",
      """""",
      this.prefix + """comment"""
    )
  )

  // @LINE:26
  private[this] lazy val controllers_ForumController_updateComment7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateComment")))
  )
  private[this] lazy val controllers_ForumController_updateComment7_invoker = createInvoker(
    ForumController_1.updateComment(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ForumController",
      "updateComment",
      Nil,
      "POST",
      """""",
      this.prefix + """updateComment"""
    )
  )

  // @LINE:27
  private[this] lazy val controllers_ForumController_uploadFile8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("upload")))
  )
  private[this] lazy val controllers_ForumController_uploadFile8_invoker = createInvoker(
    ForumController_1.uploadFile(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ForumController",
      "uploadFile",
      Nil,
      "POST",
      """""",
      this.prefix + """upload"""
    )
  )

  // @LINE:30
  private[this] lazy val controllers_PostController_addPost9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/addPost")))
  )
  private[this] lazy val controllers_PostController_addPost9_invoker = createInvoker(
    PostController_2.addPost(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PostController",
      "addPost",
      Nil,
      "POST",
      """Post Related REST API""",
      this.prefix + """post/addPost"""
    )
  )

  // @LINE:31
  private[this] lazy val controllers_PostController_getPostById10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/getPostById/"), DynamicPart("postId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PostController_getPostById10_invoker = createInvoker(
    PostController_2.getPostById(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PostController",
      "getPostById",
      Seq(classOf[Long]),
      "GET",
      """""",
      this.prefix + """post/getPostById/""" + "$" + """postId<[^/]+>"""
    )
  )

  // @LINE:32
  private[this] lazy val controllers_PostController_getAllPosts11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/getAllPosts")))
  )
  private[this] lazy val controllers_PostController_getAllPosts11_invoker = createInvoker(
    PostController_2.getAllPosts(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PostController",
      "getAllPosts",
      Nil,
      "GET",
      """""",
      this.prefix + """post/getAllPosts"""
    )
  )

  // @LINE:33
  private[this] lazy val controllers_PostController_addComment12_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/addComment")))
  )
  private[this] lazy val controllers_PostController_addComment12_invoker = createInvoker(
    PostController_2.addComment(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PostController",
      "addComment",
      Nil,
      "POST",
      """""",
      this.prefix + """post/addComment"""
    )
  )

  // @LINE:34
  private[this] lazy val controllers_PostController_setAsQuestion13_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/setAsQuestion")))
  )
  private[this] lazy val controllers_PostController_setAsQuestion13_invoker = createInvoker(
    PostController_2.setAsQuestion(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PostController",
      "setAsQuestion",
      Nil,
      "POST",
      """""",
      this.prefix + """post/setAsQuestion"""
    )
  )

  // @LINE:35
  private[this] lazy val controllers_PostController_setAnswer14_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/setAnswer")))
  )
  private[this] lazy val controllers_PostController_setAnswer14_invoker = createInvoker(
    PostController_2.setAnswer(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PostController",
      "setAnswer",
      Nil,
      "POST",
      """""",
      this.prefix + """post/setAnswer"""
    )
  )

  // @LINE:39
  private[this] lazy val controllers_SubscriptionController_loadSubscriptionList15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("subscribe/list/all")))
  )
  private[this] lazy val controllers_SubscriptionController_loadSubscriptionList15_invoker = createInvoker(
    SubscriptionController_0.loadSubscriptionList(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SubscriptionController",
      "loadSubscriptionList",
      Nil,
      "GET",
      """ Subscribe""",
      this.prefix + """subscribe/list/all"""
    )
  )

  // @LINE:40
  private[this] lazy val controllers_SubscriptionController_loadSubscriptionListByCategory16_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("subscribe/list/"), DynamicPart("category", """[^/]+""",true)))
  )
  private[this] lazy val controllers_SubscriptionController_loadSubscriptionListByCategory16_invoker = createInvoker(
    SubscriptionController_0.loadSubscriptionListByCategory(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SubscriptionController",
      "loadSubscriptionListByCategory",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """subscribe/list/""" + "$" + """category<[^/]+>"""
    )
  )

  // @LINE:41
  private[this] lazy val controllers_SubscriptionController_loadTimeline17_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("subscribe/timeline")))
  )
  private[this] lazy val controllers_SubscriptionController_loadTimeline17_invoker = createInvoker(
    SubscriptionController_0.loadTimeline(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SubscriptionController",
      "loadTimeline",
      Nil,
      "GET",
      """""",
      this.prefix + """subscribe/timeline"""
    )
  )

  // @LINE:42
  private[this] lazy val controllers_SubscriptionController_subscribe18_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("subscribe/"), DynamicPart("followeeid", """[^/]+""",true), StaticPart("/"), DynamicPart("category", """[^/]+""",true)))
  )
  private[this] lazy val controllers_SubscriptionController_subscribe18_invoker = createInvoker(
    SubscriptionController_0.subscribe(fakeValue[Long], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SubscriptionController",
      "subscribe",
      Seq(classOf[Long], classOf[String]),
      "GET",
      """""",
      this.prefix + """subscribe/""" + "$" + """followeeid<[^/]+>/""" + "$" + """category<[^/]+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_Application_index0_route(params) =>
      call { 
        controllers_Application_index0_invoker.call(Application_4.index())
      }
  
    // @LINE:9
    case controllers_Assets_at1_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at1_invoker.call(Assets_3.at(path, file))
      }
  
    // @LINE:11
    case controllers_Application_upload2_route(params) =>
      call { 
        controllers_Application_upload2_invoker.call(Application_4.upload())
      }
  
    // @LINE:19
    case controllers_Application_getPaperByYear3_route(params) =>
      call(params.fromPath[Integer]("year", None)) { (year) =>
        controllers_Application_getPaperByYear3_invoker.call(Application_4.getPaperByYear(year))
      }
  
    // @LINE:20
    case controllers_Application_getPaperByTitle4_route(params) =>
      call(params.fromPath[String]("title", None)) { (title) =>
        controllers_Application_getPaperByTitle4_invoker.call(Application_4.getPaperByTitle(title))
      }
  
    // @LINE:24
    case controllers_ForumController_addComment5_route(params) =>
      call { 
        controllers_ForumController_addComment5_invoker.call(ForumController_1.addComment())
      }
  
    // @LINE:25
    case controllers_ForumController_getComments6_route(params) =>
      call(params.fromQuery[Long]("rootid", None), params.fromQuery[Long]("categoryid", None)) { (rootid, categoryid) =>
        controllers_ForumController_getComments6_invoker.call(ForumController_1.getComments(rootid, categoryid))
      }
  
    // @LINE:26
    case controllers_ForumController_updateComment7_route(params) =>
      call { 
        controllers_ForumController_updateComment7_invoker.call(ForumController_1.updateComment())
      }
  
    // @LINE:27
    case controllers_ForumController_uploadFile8_route(params) =>
      call { 
        controllers_ForumController_uploadFile8_invoker.call(ForumController_1.uploadFile())
      }
  
    // @LINE:30
    case controllers_PostController_addPost9_route(params) =>
      call { 
        controllers_PostController_addPost9_invoker.call(PostController_2.addPost())
      }
  
    // @LINE:31
    case controllers_PostController_getPostById10_route(params) =>
      call(params.fromPath[Long]("postId", None)) { (postId) =>
        controllers_PostController_getPostById10_invoker.call(PostController_2.getPostById(postId))
      }
  
    // @LINE:32
    case controllers_PostController_getAllPosts11_route(params) =>
      call { 
        controllers_PostController_getAllPosts11_invoker.call(PostController_2.getAllPosts())
      }
  
    // @LINE:33
    case controllers_PostController_addComment12_route(params) =>
      call { 
        controllers_PostController_addComment12_invoker.call(PostController_2.addComment())
      }
  
    // @LINE:34
    case controllers_PostController_setAsQuestion13_route(params) =>
      call { 
        controllers_PostController_setAsQuestion13_invoker.call(PostController_2.setAsQuestion())
      }
  
    // @LINE:35
    case controllers_PostController_setAnswer14_route(params) =>
      call { 
        controllers_PostController_setAnswer14_invoker.call(PostController_2.setAnswer())
      }
  
    // @LINE:39
    case controllers_SubscriptionController_loadSubscriptionList15_route(params) =>
      call { 
        controllers_SubscriptionController_loadSubscriptionList15_invoker.call(SubscriptionController_0.loadSubscriptionList())
      }
  
    // @LINE:40
    case controllers_SubscriptionController_loadSubscriptionListByCategory16_route(params) =>
      call(params.fromPath[String]("category", None)) { (category) =>
        controllers_SubscriptionController_loadSubscriptionListByCategory16_invoker.call(SubscriptionController_0.loadSubscriptionListByCategory(category))
      }
  
    // @LINE:41
    case controllers_SubscriptionController_loadTimeline17_route(params) =>
      call { 
        controllers_SubscriptionController_loadTimeline17_invoker.call(SubscriptionController_0.loadTimeline())
      }
  
    // @LINE:42
    case controllers_SubscriptionController_subscribe18_route(params) =>
      call(params.fromPath[Long]("followeeid", None), params.fromPath[String]("category", None)) { (followeeid, category) =>
        controllers_SubscriptionController_subscribe18_invoker.call(SubscriptionController_0.subscribe(followeeid, category))
      }
  }
}
