
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/yuanyuan/Documents/SSNetwork/backend/conf/routes
// @DATE:Sat Apr 23 21:41:34 PDT 2016

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
  // @LINE:31
  ThumbController_3: controllers.ThumbController,
  // @LINE:37
  PostController_2: controllers.PostController,
  // @LINE:46
  TagController_1: controllers.TagController,
  // @LINE:51
  PublicationController_6: controllers.PublicationController,
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
    // @LINE:31
    ThumbController_3: controllers.ThumbController,
    // @LINE:37
    PostController_2: controllers.PostController,
    // @LINE:46
    TagController_1: controllers.TagController,
    // @LINE:51
    PublicationController_6: controllers.PublicationController
  ) = this(errorHandler, Application_5, Assets_4, ForumController_0, ThumbController_3, PostController_2, TagController_1, PublicationController_6, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Application_5, Assets_4, ForumController_0, ThumbController_3, PostController_2, TagController_1, PublicationController_6, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.Application.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """person/uploadPic""", """controllers.Application.upload()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """comment""", """controllers.ForumController.addComment()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """comment""", """controllers.ForumController.getComments(rootid:Integer, categoryid:Integer)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateComment""", """controllers.ForumController.updateComment()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteComment""", """controllers.ForumController.deleteComment()"""),
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
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getTag/""" + "$" + """pub_id<[^/]+>""", """controllers.TagController.getTagByPub_id(pub_id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updatepub""", """controllers.PublicationController.updatePublication()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """year/""" + "$" + """year<[^/]+>""", """controllers.Application.getPublicationWithAuthorsByYear(year:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """id/""" + "$" + """id<[^/]+>""", """controllers.Application.getPublicationWithAuthorsById(id:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """title/""" + "$" + """title<[^/]+>""", """controllers.Application.getPublicationWithAuthorsByTitle(title:String)"""),
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

  // @LINE:24
  private[this] lazy val controllers_ForumController_addComment3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("comment")))
  )
  private[this] lazy val controllers_ForumController_addComment3_invoker = createInvoker(
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
  private[this] lazy val controllers_ForumController_getComments4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("comment")))
  )
  private[this] lazy val controllers_ForumController_getComments4_invoker = createInvoker(
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
  private[this] lazy val controllers_ForumController_updateComment5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateComment")))
  )
  private[this] lazy val controllers_ForumController_updateComment5_invoker = createInvoker(
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
  private[this] lazy val controllers_ForumController_deleteComment6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteComment")))
  )
  private[this] lazy val controllers_ForumController_deleteComment6_invoker = createInvoker(
    ForumController_0.deleteComment(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ForumController",
      "deleteComment",
      Nil,
      "POST",
      """""",
      this.prefix + """deleteComment"""
    )
  )

  // @LINE:28
  private[this] lazy val controllers_ForumController_uploadFile7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("upload")))
  )
  private[this] lazy val controllers_ForumController_uploadFile7_invoker = createInvoker(
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

  // @LINE:31
  private[this] lazy val controllers_ThumbController_addThumb8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addThumb")))
  )
  private[this] lazy val controllers_ThumbController_addThumb8_invoker = createInvoker(
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

  // @LINE:32
  private[this] lazy val controllers_ThumbController_deleteThumb9_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteThumb/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ThumbController_deleteThumb9_invoker = createInvoker(
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

  // @LINE:33
  private[this] lazy val controllers_ThumbController_getThumbSum10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getThumbSum/"), DynamicPart("user", """[^/]+""",true), StaticPart("/"), DynamicPart("type", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ThumbController_getThumbSum10_invoker = createInvoker(
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

  // @LINE:37
  private[this] lazy val controllers_PostController_addPost11_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/addPost")))
  )
  private[this] lazy val controllers_PostController_addPost11_invoker = createInvoker(
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

  // @LINE:38
  private[this] lazy val controllers_PostController_getPostById12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/getPostById/"), DynamicPart("postId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PostController_getPostById12_invoker = createInvoker(
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

  // @LINE:39
  private[this] lazy val controllers_PostController_getAllPosts13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/getAllPosts")))
  )
  private[this] lazy val controllers_PostController_getAllPosts13_invoker = createInvoker(
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

  // @LINE:40
  private[this] lazy val controllers_PostController_addComment14_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/addComment")))
  )
  private[this] lazy val controllers_PostController_addComment14_invoker = createInvoker(
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

  // @LINE:41
  private[this] lazy val controllers_PostController_setAsQuestion15_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/setAsQuestion")))
  )
  private[this] lazy val controllers_PostController_setAsQuestion15_invoker = createInvoker(
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

  // @LINE:42
  private[this] lazy val controllers_PostController_setAnswer16_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/setAnswer")))
  )
  private[this] lazy val controllers_PostController_setAnswer16_invoker = createInvoker(
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

  // @LINE:46
  private[this] lazy val controllers_TagController_addTagpub17_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addtagpub/"), DynamicPart("pubid", """[^/]+""",true), StaticPart("/"), DynamicPart("tagpub", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TagController_addTagpub17_invoker = createInvoker(
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

  // @LINE:47
  private[this] lazy val controllers_TagController_deleteTagpub18_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deletetagpub/"), DynamicPart("pubid", """[^/]+""",true), StaticPart("/"), DynamicPart("tagpub", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TagController_deleteTagpub18_invoker = createInvoker(
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

  // @LINE:48
  private[this] lazy val controllers_TagController_getTagpubs19_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("gettagpubs/"), DynamicPart("title", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TagController_getTagpubs19_invoker = createInvoker(
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

  // @LINE:49
  private[this] lazy val controllers_TagController_getPublications20_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getpublications/"), DynamicPart("tagpub", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TagController_getPublications20_invoker = createInvoker(
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

  // @LINE:50
  private[this] lazy val controllers_TagController_getTagByPub_id21_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getTag/"), DynamicPart("pub_id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TagController_getTagByPub_id21_invoker = createInvoker(
    TagController_1.getTagByPub_id(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TagController",
      "getTagByPub_id",
      Seq(classOf[Long]),
      "GET",
      """""",
      this.prefix + """getTag/""" + "$" + """pub_id<[^/]+>"""
    )
  )

  // @LINE:51
  private[this] lazy val controllers_PublicationController_updatePublication22_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updatepub")))
  )
  private[this] lazy val controllers_PublicationController_updatePublication22_invoker = createInvoker(
    PublicationController_6.updatePublication(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PublicationController",
      "updatePublication",
      Nil,
      "POST",
      """""",
      this.prefix + """updatepub"""
    )
  )

  // @LINE:54
  private[this] lazy val controllers_Application_getPublicationWithAuthorsByYear23_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("year/"), DynamicPart("year", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_getPublicationWithAuthorsByYear23_invoker = createInvoker(
    Application_5.getPublicationWithAuthorsByYear(fakeValue[Integer]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getPublicationWithAuthorsByYear",
      Seq(classOf[Integer]),
      "GET",
      """## Testing New Features""",
      this.prefix + """year/""" + "$" + """year<[^/]+>"""
    )
  )

  // @LINE:55
  private[this] lazy val controllers_Application_getPublicationWithAuthorsById24_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("id/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_getPublicationWithAuthorsById24_invoker = createInvoker(
    Application_5.getPublicationWithAuthorsById(fakeValue[Integer]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getPublicationWithAuthorsById",
      Seq(classOf[Integer]),
      "GET",
      """""",
      this.prefix + """id/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:56
  private[this] lazy val controllers_Application_getPublicationWithAuthorsByTitle25_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("title/"), DynamicPart("title", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_getPublicationWithAuthorsByTitle25_invoker = createInvoker(
    Application_5.getPublicationWithAuthorsByTitle(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getPublicationWithAuthorsByTitle",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """title/""" + "$" + """title<[^/]+>"""
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
  
    // @LINE:24
    case controllers_ForumController_addComment3_route(params) =>
      call { 
        controllers_ForumController_addComment3_invoker.call(ForumController_0.addComment())
      }
  
    // @LINE:25
    case controllers_ForumController_getComments4_route(params) =>
      call(params.fromQuery[Integer]("rootid", None), params.fromQuery[Integer]("categoryid", None)) { (rootid, categoryid) =>
        controllers_ForumController_getComments4_invoker.call(ForumController_0.getComments(rootid, categoryid))
      }
  
    // @LINE:26
    case controllers_ForumController_updateComment5_route(params) =>
      call { 
        controllers_ForumController_updateComment5_invoker.call(ForumController_0.updateComment())
      }
  
    // @LINE:27
    case controllers_ForumController_deleteComment6_route(params) =>
      call { 
        controllers_ForumController_deleteComment6_invoker.call(ForumController_0.deleteComment())
      }
  
    // @LINE:28
    case controllers_ForumController_uploadFile7_route(params) =>
      call { 
        controllers_ForumController_uploadFile7_invoker.call(ForumController_0.uploadFile())
      }
  
    // @LINE:31
    case controllers_ThumbController_addThumb8_route(params) =>
      call { 
        controllers_ThumbController_addThumb8_invoker.call(ThumbController_3.addThumb())
      }
  
    // @LINE:32
    case controllers_ThumbController_deleteThumb9_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ThumbController_deleteThumb9_invoker.call(ThumbController_3.deleteThumb(id))
      }
  
    // @LINE:33
    case controllers_ThumbController_getThumbSum10_route(params) =>
      call(params.fromPath[String]("user", None), params.fromPath[String]("type", None)) { (user, _pf_escape_type) =>
        controllers_ThumbController_getThumbSum10_invoker.call(ThumbController_3.getThumbSum(user, _pf_escape_type))
      }
  
    // @LINE:37
    case controllers_PostController_addPost11_route(params) =>
      call { 
        controllers_PostController_addPost11_invoker.call(PostController_2.addPost())
      }
  
    // @LINE:38
    case controllers_PostController_getPostById12_route(params) =>
      call(params.fromPath[Long]("postId", None)) { (postId) =>
        controllers_PostController_getPostById12_invoker.call(PostController_2.getPostById(postId))
      }
  
    // @LINE:39
    case controllers_PostController_getAllPosts13_route(params) =>
      call { 
        controllers_PostController_getAllPosts13_invoker.call(PostController_2.getAllPosts())
      }
  
    // @LINE:40
    case controllers_PostController_addComment14_route(params) =>
      call { 
        controllers_PostController_addComment14_invoker.call(PostController_2.addComment())
      }
  
    // @LINE:41
    case controllers_PostController_setAsQuestion15_route(params) =>
      call { 
        controllers_PostController_setAsQuestion15_invoker.call(PostController_2.setAsQuestion())
      }
  
    // @LINE:42
    case controllers_PostController_setAnswer16_route(params) =>
      call { 
        controllers_PostController_setAnswer16_invoker.call(PostController_2.setAnswer())
      }
  
    // @LINE:46
    case controllers_TagController_addTagpub17_route(params) =>
      call(params.fromPath[Long]("pubid", None), params.fromPath[String]("tagpub", None)) { (pubid, tagpub) =>
        controllers_TagController_addTagpub17_invoker.call(TagController_1.addTagpub(pubid, tagpub))
      }
  
    // @LINE:47
    case controllers_TagController_deleteTagpub18_route(params) =>
      call(params.fromPath[Long]("pubid", None), params.fromPath[String]("tagpub", None)) { (pubid, tagpub) =>
        controllers_TagController_deleteTagpub18_invoker.call(TagController_1.deleteTagpub(pubid, tagpub))
      }
  
    // @LINE:48
    case controllers_TagController_getTagpubs19_route(params) =>
      call(params.fromPath[String]("title", None)) { (title) =>
        controllers_TagController_getTagpubs19_invoker.call(TagController_1.getTagpubs(title))
      }
  
    // @LINE:49
    case controllers_TagController_getPublications20_route(params) =>
      call(params.fromPath[String]("tagpub", None)) { (tagpub) =>
        controllers_TagController_getPublications20_invoker.call(TagController_1.getPublications(tagpub))
      }
  
    // @LINE:50
    case controllers_TagController_getTagByPub_id21_route(params) =>
      call(params.fromPath[Long]("pub_id", None)) { (pub_id) =>
        controllers_TagController_getTagByPub_id21_invoker.call(TagController_1.getTagByPub_id(pub_id))
      }
  
    // @LINE:51
    case controllers_PublicationController_updatePublication22_route(params) =>
      call { 
        controllers_PublicationController_updatePublication22_invoker.call(PublicationController_6.updatePublication())
      }
  
    // @LINE:54
    case controllers_Application_getPublicationWithAuthorsByYear23_route(params) =>
      call(params.fromPath[Integer]("year", None)) { (year) =>
        controllers_Application_getPublicationWithAuthorsByYear23_invoker.call(Application_5.getPublicationWithAuthorsByYear(year))
      }
  
    // @LINE:55
    case controllers_Application_getPublicationWithAuthorsById24_route(params) =>
      call(params.fromPath[Integer]("id", None)) { (id) =>
        controllers_Application_getPublicationWithAuthorsById24_invoker.call(Application_5.getPublicationWithAuthorsById(id))
      }
  
    // @LINE:56
    case controllers_Application_getPublicationWithAuthorsByTitle25_route(params) =>
      call(params.fromPath[String]("title", None)) { (title) =>
        controllers_Application_getPublicationWithAuthorsByTitle25_invoker.call(Application_5.getPublicationWithAuthorsByTitle(title))
      }
  }
}
