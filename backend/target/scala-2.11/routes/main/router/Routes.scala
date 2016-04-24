
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/caoyi/SSNetwork/backend/conf/routes
// @DATE:Sat Apr 23 10:04:47 PDT 2016

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
  Application_2: controllers.Application,
  // @LINE:9
  Assets_1: controllers.Assets,
  // @LINE:26
  ForumController_0: controllers.ForumController,
  // @LINE:32
  PostController_3: controllers.PostController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    Application_2: controllers.Application,
    // @LINE:9
    Assets_1: controllers.Assets,
    // @LINE:26
    ForumController_0: controllers.ForumController,
    // @LINE:32
    PostController_3: controllers.PostController
  ) = this(errorHandler, Application_2, Assets_1, ForumController_0, PostController_3, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Application_2, Assets_1, ForumController_0, PostController_3, prefix)
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
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """all""", """controllers.Application.getAllPublications()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """keyword/""" + "$" + """keyWord<[^/]+>""", """controllers.Application.getPaperBykeyWord(keyWord:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """author/""" + "$" + """author<[^/]+>""", """controllers.Application.getCoAuthors(author:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """comment""", """controllers.ForumController.addComment()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """comment""", """controllers.ForumController.getComments(rootid:Integer, categoryid:Integer)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateComment""", """controllers.ForumController.updateComment()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """upload""", """controllers.ForumController.uploadFile()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """post/addPost""", """controllers.PostController.addPost()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """post/getPostById/""" + "$" + """postId<[^/]+>""", """controllers.PostController.getPostById(postId:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """post/getAllPosts""", """controllers.PostController.getAllPosts()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """post/addComment""", """controllers.PostController.addComment()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """post/setAsQuestion""", """controllers.PostController.setAsQuestion()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """post/setAnswer""", """controllers.PostController.setAnswer()"""),
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
    Application_2.index(),
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
    Assets_1.at(fakeValue[String], fakeValue[String]),
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
    Application_2.upload(),
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
    Application_2.getPaperByYear(fakeValue[Integer]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getPaperByYear",
      Seq(classOf[Integer]),
      "GET",
      """##Paper Suggestion""",
      this.prefix + """year/""" + "$" + """year<[^/]+>"""
    )
  )

  // @LINE:20
  private[this] lazy val controllers_Application_getPaperByTitle4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("title/"), DynamicPart("title", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_getPaperByTitle4_invoker = createInvoker(
    Application_2.getPaperByTitle(fakeValue[String]),
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

  // @LINE:21
  private[this] lazy val controllers_Application_getAllPublications5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("all")))
  )
  private[this] lazy val controllers_Application_getAllPublications5_invoker = createInvoker(
    Application_2.getAllPublications(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getAllPublications",
      Nil,
      "GET",
      """""",
      this.prefix + """all"""
    )
  )

  // @LINE:22
  private[this] lazy val controllers_Application_getPaperBykeyWord6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("keyword/"), DynamicPart("keyWord", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_getPaperBykeyWord6_invoker = createInvoker(
    Application_2.getPaperBykeyWord(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getPaperBykeyWord",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """keyword/""" + "$" + """keyWord<[^/]+>"""
    )
  )

  // @LINE:23
  private[this] lazy val controllers_Application_getCoAuthors7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("author/"), DynamicPart("author", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_getCoAuthors7_invoker = createInvoker(
    Application_2.getCoAuthors(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getCoAuthors",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """author/""" + "$" + """author<[^/]+>"""
    )
  )

  // @LINE:26
  private[this] lazy val controllers_ForumController_addComment8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("comment")))
  )
  private[this] lazy val controllers_ForumController_addComment8_invoker = createInvoker(
    ForumController_0.addComment(),
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

  // @LINE:27
  private[this] lazy val controllers_ForumController_getComments9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("comment")))
  )
  private[this] lazy val controllers_ForumController_getComments9_invoker = createInvoker(
    ForumController_0.getComments(fakeValue[Integer], fakeValue[Integer]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ForumController",
      "getComments",
      Seq(classOf[Integer], classOf[Integer]),
      "GET",
      """""",
      this.prefix + """comment"""
    )
  )

  // @LINE:28
  private[this] lazy val controllers_ForumController_updateComment10_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateComment")))
  )
  private[this] lazy val controllers_ForumController_updateComment10_invoker = createInvoker(
    ForumController_0.updateComment(),
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

  // @LINE:29
  private[this] lazy val controllers_ForumController_uploadFile11_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("upload")))
  )
  private[this] lazy val controllers_ForumController_uploadFile11_invoker = createInvoker(
    ForumController_0.uploadFile(),
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

  // @LINE:32
  private[this] lazy val controllers_PostController_addPost12_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/addPost")))
  )
  private[this] lazy val controllers_PostController_addPost12_invoker = createInvoker(
    PostController_3.addPost(),
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

  // @LINE:33
  private[this] lazy val controllers_PostController_getPostById13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/getPostById/"), DynamicPart("postId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PostController_getPostById13_invoker = createInvoker(
    PostController_3.getPostById(fakeValue[Long]),
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

  // @LINE:34
  private[this] lazy val controllers_PostController_getAllPosts14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/getAllPosts")))
  )
  private[this] lazy val controllers_PostController_getAllPosts14_invoker = createInvoker(
    PostController_3.getAllPosts(),
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

  // @LINE:35
  private[this] lazy val controllers_PostController_addComment15_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/addComment")))
  )
  private[this] lazy val controllers_PostController_addComment15_invoker = createInvoker(
    PostController_3.addComment(),
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

  // @LINE:36
  private[this] lazy val controllers_PostController_setAsQuestion16_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/setAsQuestion")))
  )
  private[this] lazy val controllers_PostController_setAsQuestion16_invoker = createInvoker(
    PostController_3.setAsQuestion(),
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

  // @LINE:37
  private[this] lazy val controllers_PostController_setAnswer17_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/setAnswer")))
  )
  private[this] lazy val controllers_PostController_setAnswer17_invoker = createInvoker(
    PostController_3.setAnswer(),
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


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_Application_index0_route(params) =>
      call { 
        controllers_Application_index0_invoker.call(Application_2.index())
      }
  
    // @LINE:9
    case controllers_Assets_at1_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at1_invoker.call(Assets_1.at(path, file))
      }
  
    // @LINE:11
    case controllers_Application_upload2_route(params) =>
      call { 
        controllers_Application_upload2_invoker.call(Application_2.upload())
      }
  
    // @LINE:19
    case controllers_Application_getPaperByYear3_route(params) =>
      call(params.fromPath[Integer]("year", None)) { (year) =>
        controllers_Application_getPaperByYear3_invoker.call(Application_2.getPaperByYear(year))
      }
  
    // @LINE:20
    case controllers_Application_getPaperByTitle4_route(params) =>
      call(params.fromPath[String]("title", None)) { (title) =>
        controllers_Application_getPaperByTitle4_invoker.call(Application_2.getPaperByTitle(title))
      }
  
    // @LINE:21
    case controllers_Application_getAllPublications5_route(params) =>
      call { 
        controllers_Application_getAllPublications5_invoker.call(Application_2.getAllPublications())
      }
  
    // @LINE:22
    case controllers_Application_getPaperBykeyWord6_route(params) =>
      call(params.fromPath[String]("keyWord", None)) { (keyWord) =>
        controllers_Application_getPaperBykeyWord6_invoker.call(Application_2.getPaperBykeyWord(keyWord))
      }
  
    // @LINE:23
    case controllers_Application_getCoAuthors7_route(params) =>
      call(params.fromPath[String]("author", None)) { (author) =>
        controllers_Application_getCoAuthors7_invoker.call(Application_2.getCoAuthors(author))
      }
  
    // @LINE:26
    case controllers_ForumController_addComment8_route(params) =>
      call { 
        controllers_ForumController_addComment8_invoker.call(ForumController_0.addComment())
      }
  
    // @LINE:27
    case controllers_ForumController_getComments9_route(params) =>
      call(params.fromQuery[Integer]("rootid", None), params.fromQuery[Integer]("categoryid", None)) { (rootid, categoryid) =>
        controllers_ForumController_getComments9_invoker.call(ForumController_0.getComments(rootid, categoryid))
      }
  
    // @LINE:28
    case controllers_ForumController_updateComment10_route(params) =>
      call { 
        controllers_ForumController_updateComment10_invoker.call(ForumController_0.updateComment())
      }
  
    // @LINE:29
    case controllers_ForumController_uploadFile11_route(params) =>
      call { 
        controllers_ForumController_uploadFile11_invoker.call(ForumController_0.uploadFile())
      }
  
    // @LINE:32
    case controllers_PostController_addPost12_route(params) =>
      call { 
        controllers_PostController_addPost12_invoker.call(PostController_3.addPost())
      }
  
    // @LINE:33
    case controllers_PostController_getPostById13_route(params) =>
      call(params.fromPath[Long]("postId", None)) { (postId) =>
        controllers_PostController_getPostById13_invoker.call(PostController_3.getPostById(postId))
      }
  
    // @LINE:34
    case controllers_PostController_getAllPosts14_route(params) =>
      call { 
        controllers_PostController_getAllPosts14_invoker.call(PostController_3.getAllPosts())
      }
  
    // @LINE:35
    case controllers_PostController_addComment15_route(params) =>
      call { 
        controllers_PostController_addComment15_invoker.call(PostController_3.addComment())
      }
  
    // @LINE:36
    case controllers_PostController_setAsQuestion16_route(params) =>
      call { 
        controllers_PostController_setAsQuestion16_invoker.call(PostController_3.setAsQuestion())
      }
  
    // @LINE:37
    case controllers_PostController_setAnswer17_route(params) =>
      call { 
        controllers_PostController_setAnswer17_invoker.call(PostController_3.setAnswer())
      }
  }
}
