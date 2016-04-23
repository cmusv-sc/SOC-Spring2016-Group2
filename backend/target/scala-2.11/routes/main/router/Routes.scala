
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/ThomasHsu/Desktop/SSNetwork/backend/conf/routes
// @DATE:Sat Apr 23 13:33:00 PDT 2016

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
  Application_5: controllers.Application,
  // @LINE:9
  Assets_4: controllers.Assets,
  // @LINE:24
  ForumController_0: controllers.ForumController,
  // @LINE:30
  ThumbController_3: controllers.ThumbController,
  // @LINE:36
  PostController_2: controllers.PostController,
  // @LINE:45
  TagController_1: controllers.TagController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    Application_5: controllers.Application,
    // @LINE:9
    Assets_4: controllers.Assets,
    // @LINE:24
    ForumController_0: controllers.ForumController,
    // @LINE:30
    ThumbController_3: controllers.ThumbController,
    // @LINE:36
    PostController_2: controllers.PostController,
    // @LINE:45
    TagController_1: controllers.TagController
  ) = this(errorHandler, Application_5, Assets_4, ForumController_0, ThumbController_3, PostController_2, TagController_1, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Application_5, Assets_4, ForumController_0, ThumbController_3, PostController_2, TagController_1, prefix)
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
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """comment""", """controllers.ForumController.getComments(rootid:Integer, categoryid:Integer)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateComment""", """controllers.ForumController.updateComment()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """upload""", """controllers.ForumController.uploadFile()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addThumb""", """controllers.ThumbController.addThumb()"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteThumb/""" + "$" + """id<[^/]+>""", """controllers.ThumbController.deleteThumb(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getThumbSum/""" + "$" + """user<[^/]+>/""" + "$" + """type<[^/]+>""", """controllers.ThumbController.getThumbSum(user:String, type:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """post/addPost""", """controllers.PostController.addPost()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """post/getPostById/""" + "$" + """postId<[^/]+>""", """controllers.PostController.getPostById(postId:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """post/getAllPosts""", """controllers.PostController.getAllPosts()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """post/addComment""", """controllers.PostController.addComment()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """post/setAsQuestion""", """controllers.PostController.setAsQuestion()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """post/setAnswer""", """controllers.PostController.setAnswer()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addtagpub/""" + "$" + """pubid<[^/]+>/""" + "$" + """tagpub<[^/]+>""", """controllers.TagController.addTagpub(pubid:Long, tagpub:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deletetagpub/""" + "$" + """pubid<[^/]+>/""" + "$" + """tagpub<[^/]+>""", """controllers.TagController.deleteTagpub(pubid:Long, tagpub:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """gettagpubs/""" + "$" + """title<[^/]+>""", """controllers.TagController.getTagpubs(title:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getpublications/""" + "$" + """tagpub<[^/]+>""", """controllers.TagController.getPublications(tagpub:String)"""),
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
    Application_5.index(),
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
    Assets_4.at(fakeValue[String], fakeValue[String]),
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
    Application_5.upload(),
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
    Application_5.getPaperByYear(fakeValue[Integer]),
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
    Application_5.getPaperByTitle(fakeValue[String]),
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

  // @LINE:25
  private[this] lazy val controllers_ForumController_getComments6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("comment")))
  )
  private[this] lazy val controllers_ForumController_getComments6_invoker = createInvoker(
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

  // @LINE:26
  private[this] lazy val controllers_ForumController_updateComment7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateComment")))
  )
  private[this] lazy val controllers_ForumController_updateComment7_invoker = createInvoker(
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

  // @LINE:27
  private[this] lazy val controllers_ForumController_uploadFile8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("upload")))
  )
  private[this] lazy val controllers_ForumController_uploadFile8_invoker = createInvoker(
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

  // @LINE:30
  private[this] lazy val controllers_ThumbController_addThumb9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addThumb")))
  )
  private[this] lazy val controllers_ThumbController_addThumb9_invoker = createInvoker(
    ThumbController_3.addThumb(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ThumbController",
      "addThumb",
      Nil,
      "POST",
      """## Thumb""",
      this.prefix + """addThumb"""
    )
  )

  // @LINE:31
  private[this] lazy val controllers_ThumbController_deleteThumb10_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteThumb/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ThumbController_deleteThumb10_invoker = createInvoker(
    ThumbController_3.deleteThumb(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ThumbController",
      "deleteThumb",
      Seq(classOf[Long]),
      "DELETE",
      """""",
      this.prefix + """deleteThumb/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:32
  private[this] lazy val controllers_ThumbController_getThumbSum11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getThumbSum/"), DynamicPart("user", """[^/]+""",true), StaticPart("/"), DynamicPart("type", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ThumbController_getThumbSum11_invoker = createInvoker(
    ThumbController_3.getThumbSum(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ThumbController",
      "getThumbSum",
      Seq(classOf[String], classOf[String]),
      "GET",
      """""",
      this.prefix + """getThumbSum/""" + "$" + """user<[^/]+>/""" + "$" + """type<[^/]+>"""
    )
  )

  // @LINE:36
  private[this] lazy val controllers_PostController_addPost12_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/addPost")))
  )
  private[this] lazy val controllers_PostController_addPost12_invoker = createInvoker(
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

  // @LINE:37
  private[this] lazy val controllers_PostController_getPostById13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/getPostById/"), DynamicPart("postId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PostController_getPostById13_invoker = createInvoker(
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

  // @LINE:38
  private[this] lazy val controllers_PostController_getAllPosts14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/getAllPosts")))
  )
  private[this] lazy val controllers_PostController_getAllPosts14_invoker = createInvoker(
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

  // @LINE:39
  private[this] lazy val controllers_PostController_addComment15_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/addComment")))
  )
  private[this] lazy val controllers_PostController_addComment15_invoker = createInvoker(
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

  // @LINE:40
  private[this] lazy val controllers_PostController_setAsQuestion16_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/setAsQuestion")))
  )
  private[this] lazy val controllers_PostController_setAsQuestion16_invoker = createInvoker(
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

  // @LINE:41
  private[this] lazy val controllers_PostController_setAnswer17_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/setAnswer")))
  )
  private[this] lazy val controllers_PostController_setAnswer17_invoker = createInvoker(
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

  // @LINE:45
  private[this] lazy val controllers_TagController_addTagpub18_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addtagpub/"), DynamicPart("pubid", """[^/]+""",true), StaticPart("/"), DynamicPart("tagpub", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TagController_addTagpub18_invoker = createInvoker(
    TagController_1.addTagpub(fakeValue[Long], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TagController",
      "addTagpub",
      Seq(classOf[Long], classOf[String]),
      "GET",
      """Tagging for publication""",
      this.prefix + """addtagpub/""" + "$" + """pubid<[^/]+>/""" + "$" + """tagpub<[^/]+>"""
    )
  )

  // @LINE:46
  private[this] lazy val controllers_TagController_deleteTagpub19_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deletetagpub/"), DynamicPart("pubid", """[^/]+""",true), StaticPart("/"), DynamicPart("tagpub", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TagController_deleteTagpub19_invoker = createInvoker(
    TagController_1.deleteTagpub(fakeValue[Long], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TagController",
      "deleteTagpub",
      Seq(classOf[Long], classOf[String]),
      "GET",
      """""",
      this.prefix + """deletetagpub/""" + "$" + """pubid<[^/]+>/""" + "$" + """tagpub<[^/]+>"""
    )
  )

  // @LINE:47
  private[this] lazy val controllers_TagController_getTagpubs20_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("gettagpubs/"), DynamicPart("title", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TagController_getTagpubs20_invoker = createInvoker(
    TagController_1.getTagpubs(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TagController",
      "getTagpubs",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """gettagpubs/""" + "$" + """title<[^/]+>"""
    )
  )

  // @LINE:48
  private[this] lazy val controllers_TagController_getPublications21_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getpublications/"), DynamicPart("tagpub", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TagController_getPublications21_invoker = createInvoker(
    TagController_1.getPublications(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TagController",
      "getPublications",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """getpublications/""" + "$" + """tagpub<[^/]+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_Application_index0_route(params) =>
      call { 
        controllers_Application_index0_invoker.call(Application_5.index())
      }
  
    // @LINE:9
    case controllers_Assets_at1_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at1_invoker.call(Assets_4.at(path, file))
      }
  
    // @LINE:11
    case controllers_Application_upload2_route(params) =>
      call { 
        controllers_Application_upload2_invoker.call(Application_5.upload())
      }
  
    // @LINE:19
    case controllers_Application_getPaperByYear3_route(params) =>
      call(params.fromPath[Integer]("year", None)) { (year) =>
        controllers_Application_getPaperByYear3_invoker.call(Application_5.getPaperByYear(year))
      }
  
    // @LINE:20
    case controllers_Application_getPaperByTitle4_route(params) =>
      call(params.fromPath[String]("title", None)) { (title) =>
        controllers_Application_getPaperByTitle4_invoker.call(Application_5.getPaperByTitle(title))
      }
  
    // @LINE:24
    case controllers_ForumController_addComment5_route(params) =>
      call { 
        controllers_ForumController_addComment5_invoker.call(ForumController_0.addComment())
      }
  
    // @LINE:25
    case controllers_ForumController_getComments6_route(params) =>
      call(params.fromQuery[Integer]("rootid", None), params.fromQuery[Integer]("categoryid", None)) { (rootid, categoryid) =>
        controllers_ForumController_getComments6_invoker.call(ForumController_0.getComments(rootid, categoryid))
      }
  
    // @LINE:26
    case controllers_ForumController_updateComment7_route(params) =>
      call { 
        controllers_ForumController_updateComment7_invoker.call(ForumController_0.updateComment())
      }
  
    // @LINE:27
    case controllers_ForumController_uploadFile8_route(params) =>
      call { 
        controllers_ForumController_uploadFile8_invoker.call(ForumController_0.uploadFile())
      }
  
    // @LINE:30
    case controllers_ThumbController_addThumb9_route(params) =>
      call { 
        controllers_ThumbController_addThumb9_invoker.call(ThumbController_3.addThumb())
      }
  
    // @LINE:31
    case controllers_ThumbController_deleteThumb10_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ThumbController_deleteThumb10_invoker.call(ThumbController_3.deleteThumb(id))
      }
  
    // @LINE:32
    case controllers_ThumbController_getThumbSum11_route(params) =>
      call(params.fromPath[String]("user", None), params.fromPath[String]("type", None)) { (user, _pf_escape_type) =>
        controllers_ThumbController_getThumbSum11_invoker.call(ThumbController_3.getThumbSum(user, _pf_escape_type))
      }
  
    // @LINE:36
    case controllers_PostController_addPost12_route(params) =>
      call { 
        controllers_PostController_addPost12_invoker.call(PostController_2.addPost())
      }
  
    // @LINE:37
    case controllers_PostController_getPostById13_route(params) =>
      call(params.fromPath[Long]("postId", None)) { (postId) =>
        controllers_PostController_getPostById13_invoker.call(PostController_2.getPostById(postId))
      }
  
    // @LINE:38
    case controllers_PostController_getAllPosts14_route(params) =>
      call { 
        controllers_PostController_getAllPosts14_invoker.call(PostController_2.getAllPosts())
      }
  
    // @LINE:39
    case controllers_PostController_addComment15_route(params) =>
      call { 
        controllers_PostController_addComment15_invoker.call(PostController_2.addComment())
      }
  
    // @LINE:40
    case controllers_PostController_setAsQuestion16_route(params) =>
      call { 
        controllers_PostController_setAsQuestion16_invoker.call(PostController_2.setAsQuestion())
      }
  
    // @LINE:41
    case controllers_PostController_setAnswer17_route(params) =>
      call { 
        controllers_PostController_setAnswer17_invoker.call(PostController_2.setAnswer())
      }
  
    // @LINE:45
    case controllers_TagController_addTagpub18_route(params) =>
      call(params.fromPath[Long]("pubid", None), params.fromPath[String]("tagpub", None)) { (pubid, tagpub) =>
        controllers_TagController_addTagpub18_invoker.call(TagController_1.addTagpub(pubid, tagpub))
      }
  
    // @LINE:46
    case controllers_TagController_deleteTagpub19_route(params) =>
      call(params.fromPath[Long]("pubid", None), params.fromPath[String]("tagpub", None)) { (pubid, tagpub) =>
        controllers_TagController_deleteTagpub19_invoker.call(TagController_1.deleteTagpub(pubid, tagpub))
      }
  
    // @LINE:47
    case controllers_TagController_getTagpubs20_route(params) =>
      call(params.fromPath[String]("title", None)) { (title) =>
        controllers_TagController_getTagpubs20_invoker.call(TagController_1.getTagpubs(title))
      }
  
    // @LINE:48
    case controllers_TagController_getPublications21_route(params) =>
      call(params.fromPath[String]("tagpub", None)) { (tagpub) =>
        controllers_TagController_getPublications21_invoker.call(TagController_1.getPublications(tagpub))
      }
  }
}
