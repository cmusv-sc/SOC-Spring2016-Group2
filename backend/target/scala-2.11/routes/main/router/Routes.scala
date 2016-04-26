
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/Anna/Documents/graduate2/soc/SSNetwork/backend/conf/routes
// @DATE:Tue Apr 26 03:28:51 PDT 2016

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
  Application_7: controllers.Application,
  // @LINE:9
  Assets_6: controllers.Assets,
  // @LINE:24
  ForumController_1: controllers.ForumController,
  // @LINE:31
  ThumbController_5: controllers.ThumbController,
  // @LINE:37
  PostController_4: controllers.PostController,
  // @LINE:46
  SubscriptionController_0: controllers.SubscriptionController,
  // @LINE:57
  TagController_3: controllers.TagController,
  // @LINE:76
  UserProfileController_2: controllers.UserProfileController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    Application_7: controllers.Application,
    // @LINE:9
    Assets_6: controllers.Assets,
    // @LINE:24
    ForumController_1: controllers.ForumController,
    // @LINE:31
    ThumbController_5: controllers.ThumbController,
    // @LINE:37
    PostController_4: controllers.PostController,
    // @LINE:46
    SubscriptionController_0: controllers.SubscriptionController,
    // @LINE:57
    TagController_3: controllers.TagController,
    // @LINE:76
    UserProfileController_2: controllers.UserProfileController
  ) = this(errorHandler, Application_7, Assets_6, ForumController_1, ThumbController_5, PostController_4, SubscriptionController_0, TagController_3, UserProfileController_2, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Application_7, Assets_6, ForumController_1, ThumbController_5, PostController_4, SubscriptionController_0, TagController_3, UserProfileController_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.Application.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """person/uploadPic""", """controllers.Application.upload()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """comment""", """controllers.ForumController.addComment()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateComment""", """controllers.ForumController.updateComment()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """upload""", """controllers.ForumController.uploadFile()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addThumb""", """controllers.ThumbController.addThumb()"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteThumb/""" + "$" + """thumb_type<[^/]+>/""" + "$" + """sender<[^/]+>/""" + "$" + """receiver<[^/]+>""", """controllers.ThumbController.deleteThumb(thumb_type:Integer, sender:Integer, receiver:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getThumbSum/""" + "$" + """user<[^/]+>/""" + "$" + """type<[^/]+>""", """controllers.ThumbController.getThumbSum(user:String, type:String)"""),
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
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """post/search/""" + "$" + """keyword<[^/]+>""", """controllers.PostController.search(keyword:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """post/getPostByUserId/""" + "$" + """userId<[^/]+>""", """controllers.PostController.getPostByUserId(userId:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addtagpub/""" + "$" + """pubid<[^/]+>/""" + "$" + """tagpub<[^/]+>""", """controllers.TagController.addTagpub(pubid:Long, tagpub:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deletetagpub/""" + "$" + """pubid<[^/]+>/""" + "$" + """tagpub<[^/]+>""", """controllers.TagController.deleteTagpub(pubid:Long, tagpub:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """gettagpubs/""" + "$" + """title<[^/]+>""", """controllers.TagController.getTagpubs(title:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getpublications/""" + "$" + """tagpub<[^/]+>""", """controllers.TagController.getPublications(tagpub:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getTag/""" + "$" + """pub_id<[^/]+>""", """controllers.TagController.getTagByPub_id(pub_id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addtagpost/""" + "$" + """postid<[^/]+>/""" + "$" + """tagpost<[^/]+>""", """controllers.TagController.addTagpost(postid:Long, tagpost:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deletetagpost/""" + "$" + """postid<[^/]+>/""" + "$" + """tagpost<[^/]+>""", """controllers.TagController.deleteTagpost(postid:Long, tagpost:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getTagpost/""" + "$" + """post_id<[^/]+>""", """controllers.TagController.getTagByPost_id(post_id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """year/""" + "$" + """year<[^/]+>""", """controllers.Application.getPublicationWithAuthorsByYear(year:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """id/""" + "$" + """id<[^/]+>""", """controllers.Application.getPublicationWithAuthorsById(id:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """title/""" + "$" + """title<[^/]+>""", """controllers.Application.getPublicationWithAuthorsByTitle(title:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """userprofile/create""", """controllers.UserProfileController.createuserProfileProfile()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """userprofile/""" + "$" + """userName<[^/]+>""", """controllers.UserProfileController.getUserProfile(userName:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """userprofile/refresh/""" + "$" + """userName<[^/]+>""", """controllers.UserProfileController.refreshUserprofile(userName:String)"""),
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
    Application_7.index(),
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
    Assets_6.at(fakeValue[String], fakeValue[String]),
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
    Application_7.upload(),
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

  // @LINE:27
  private[this] lazy val controllers_ForumController_updateComment4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateComment")))
  )
  private[this] lazy val controllers_ForumController_updateComment4_invoker = createInvoker(
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

  // @LINE:28
  private[this] lazy val controllers_ForumController_uploadFile5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("upload")))
  )
  private[this] lazy val controllers_ForumController_uploadFile5_invoker = createInvoker(
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

  // @LINE:31
  private[this] lazy val controllers_ThumbController_addThumb6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addThumb")))
  )
  private[this] lazy val controllers_ThumbController_addThumb6_invoker = createInvoker(
    ThumbController_5.addThumb(),
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
  private[this] lazy val controllers_ThumbController_deleteThumb7_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteThumb/"), DynamicPart("thumb_type", """[^/]+""",true), StaticPart("/"), DynamicPart("sender", """[^/]+""",true), StaticPart("/"), DynamicPart("receiver", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ThumbController_deleteThumb7_invoker = createInvoker(
    ThumbController_5.deleteThumb(fakeValue[Integer], fakeValue[Integer], fakeValue[Integer]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ThumbController",
      "deleteThumb",
      Seq(classOf[Integer], classOf[Integer], classOf[Integer]),
      "DELETE",
      """""",
      this.prefix + """deleteThumb/""" + "$" + """thumb_type<[^/]+>/""" + "$" + """sender<[^/]+>/""" + "$" + """receiver<[^/]+>"""
    )
  )

  // @LINE:33
  private[this] lazy val controllers_ThumbController_getThumbSum8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getThumbSum/"), DynamicPart("user", """[^/]+""",true), StaticPart("/"), DynamicPart("type", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ThumbController_getThumbSum8_invoker = createInvoker(
    ThumbController_5.getThumbSum(fakeValue[String], fakeValue[String]),
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
  private[this] lazy val controllers_PostController_addPost9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/addPost")))
  )
  private[this] lazy val controllers_PostController_addPost9_invoker = createInvoker(
    PostController_4.addPost(),
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
  private[this] lazy val controllers_PostController_getPostById10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/getPostById/"), DynamicPart("postId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PostController_getPostById10_invoker = createInvoker(
    PostController_4.getPostById(fakeValue[Long]),
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
  private[this] lazy val controllers_PostController_getAllPosts11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/getAllPosts")))
  )
  private[this] lazy val controllers_PostController_getAllPosts11_invoker = createInvoker(
    PostController_4.getAllPosts(),
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
  private[this] lazy val controllers_PostController_addComment12_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/addComment")))
  )
  private[this] lazy val controllers_PostController_addComment12_invoker = createInvoker(
    PostController_4.addComment(),
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
  private[this] lazy val controllers_PostController_setAsQuestion13_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/setAsQuestion")))
  )
  private[this] lazy val controllers_PostController_setAsQuestion13_invoker = createInvoker(
    PostController_4.setAsQuestion(),
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
  private[this] lazy val controllers_PostController_setAnswer14_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/setAnswer")))
  )
  private[this] lazy val controllers_PostController_setAnswer14_invoker = createInvoker(
    PostController_4.setAnswer(),
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

  // @LINE:47
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

  // @LINE:48
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

  // @LINE:49
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

  // @LINE:52
  private[this] lazy val controllers_PostController_search19_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/search/"), DynamicPart("keyword", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PostController_search19_invoker = createInvoker(
    PostController_4.search(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PostController",
      "search",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """post/search/""" + "$" + """keyword<[^/]+>"""
    )
  )

  // @LINE:53
  private[this] lazy val controllers_PostController_getPostByUserId20_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/getPostByUserId/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PostController_getPostByUserId20_invoker = createInvoker(
    PostController_4.getPostByUserId(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PostController",
      "getPostByUserId",
      Seq(classOf[Long]),
      "GET",
      """""",
      this.prefix + """post/getPostByUserId/""" + "$" + """userId<[^/]+>"""
    )
  )

  // @LINE:57
  private[this] lazy val controllers_TagController_addTagpub21_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addtagpub/"), DynamicPart("pubid", """[^/]+""",true), StaticPart("/"), DynamicPart("tagpub", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TagController_addTagpub21_invoker = createInvoker(
    TagController_3.addTagpub(fakeValue[Long], fakeValue[String]),
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

  // @LINE:58
  private[this] lazy val controllers_TagController_deleteTagpub22_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deletetagpub/"), DynamicPart("pubid", """[^/]+""",true), StaticPart("/"), DynamicPart("tagpub", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TagController_deleteTagpub22_invoker = createInvoker(
    TagController_3.deleteTagpub(fakeValue[Long], fakeValue[String]),
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

  // @LINE:59
  private[this] lazy val controllers_TagController_getTagpubs23_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("gettagpubs/"), DynamicPart("title", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TagController_getTagpubs23_invoker = createInvoker(
    TagController_3.getTagpubs(fakeValue[String]),
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

  // @LINE:60
  private[this] lazy val controllers_TagController_getPublications24_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getpublications/"), DynamicPart("tagpub", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TagController_getPublications24_invoker = createInvoker(
    TagController_3.getPublications(fakeValue[String]),
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

  // @LINE:61
  private[this] lazy val controllers_TagController_getTagByPub_id25_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getTag/"), DynamicPart("pub_id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TagController_getTagByPub_id25_invoker = createInvoker(
    TagController_3.getTagByPub_id(fakeValue[Long]),
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

  // @LINE:64
  private[this] lazy val controllers_TagController_addTagpost26_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addtagpost/"), DynamicPart("postid", """[^/]+""",true), StaticPart("/"), DynamicPart("tagpost", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TagController_addTagpost26_invoker = createInvoker(
    TagController_3.addTagpost(fakeValue[Long], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TagController",
      "addTagpost",
      Seq(classOf[Long], classOf[String]),
      "GET",
      """Tagging for post""",
      this.prefix + """addtagpost/""" + "$" + """postid<[^/]+>/""" + "$" + """tagpost<[^/]+>"""
    )
  )

  // @LINE:65
  private[this] lazy val controllers_TagController_deleteTagpost27_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deletetagpost/"), DynamicPart("postid", """[^/]+""",true), StaticPart("/"), DynamicPart("tagpost", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TagController_deleteTagpost27_invoker = createInvoker(
    TagController_3.deleteTagpost(fakeValue[Long], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TagController",
      "deleteTagpost",
      Seq(classOf[Long], classOf[String]),
      "GET",
      """""",
      this.prefix + """deletetagpost/""" + "$" + """postid<[^/]+>/""" + "$" + """tagpost<[^/]+>"""
    )
  )

  // @LINE:66
  private[this] lazy val controllers_TagController_getTagByPost_id28_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getTagpost/"), DynamicPart("post_id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TagController_getTagByPost_id28_invoker = createInvoker(
    TagController_3.getTagByPost_id(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TagController",
      "getTagByPost_id",
      Seq(classOf[Long]),
      "GET",
      """""",
      this.prefix + """getTagpost/""" + "$" + """post_id<[^/]+>"""
    )
  )

  // @LINE:69
  private[this] lazy val controllers_Application_getPublicationWithAuthorsByYear29_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("year/"), DynamicPart("year", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_getPublicationWithAuthorsByYear29_invoker = createInvoker(
    Application_7.getPublicationWithAuthorsByYear(fakeValue[Integer]),
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

  // @LINE:70
  private[this] lazy val controllers_Application_getPublicationWithAuthorsById30_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("id/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_getPublicationWithAuthorsById30_invoker = createInvoker(
    Application_7.getPublicationWithAuthorsById(fakeValue[Integer]),
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

  // @LINE:71
  private[this] lazy val controllers_Application_getPublicationWithAuthorsByTitle31_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("title/"), DynamicPart("title", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_getPublicationWithAuthorsByTitle31_invoker = createInvoker(
    Application_7.getPublicationWithAuthorsByTitle(fakeValue[String]),
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

  // @LINE:76
  private[this] lazy val controllers_UserProfileController_createuserProfileProfile32_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("userprofile/create")))
  )
  private[this] lazy val controllers_UserProfileController_createuserProfileProfile32_invoker = createInvoker(
    UserProfileController_2.createuserProfileProfile(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserProfileController",
      "createuserProfileProfile",
      Nil,
      "POST",
      """## UserProfile""",
      this.prefix + """userprofile/create"""
    )
  )

  // @LINE:77
  private[this] lazy val controllers_UserProfileController_getUserProfile33_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("userprofile/"), DynamicPart("userName", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserProfileController_getUserProfile33_invoker = createInvoker(
    UserProfileController_2.getUserProfile(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserProfileController",
      "getUserProfile",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """userprofile/""" + "$" + """userName<[^/]+>"""
    )
  )

  // @LINE:78
  private[this] lazy val controllers_UserProfileController_refreshUserprofile34_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("userprofile/refresh/"), DynamicPart("userName", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserProfileController_refreshUserprofile34_invoker = createInvoker(
    UserProfileController_2.refreshUserprofile(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserProfileController",
      "refreshUserprofile",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """userprofile/refresh/""" + "$" + """userName<[^/]+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_Application_index0_route(params) =>
      call { 
        controllers_Application_index0_invoker.call(Application_7.index())
      }
  
    // @LINE:9
    case controllers_Assets_at1_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at1_invoker.call(Assets_6.at(path, file))
      }
  
    // @LINE:11
    case controllers_Application_upload2_route(params) =>
      call { 
        controllers_Application_upload2_invoker.call(Application_7.upload())
      }
  
    // @LINE:24
    case controllers_ForumController_addComment3_route(params) =>
      call { 
        controllers_ForumController_addComment3_invoker.call(ForumController_1.addComment())
      }
  
    // @LINE:27
    case controllers_ForumController_updateComment4_route(params) =>
      call { 
        controllers_ForumController_updateComment4_invoker.call(ForumController_1.updateComment())
      }
  
    // @LINE:28
    case controllers_ForumController_uploadFile5_route(params) =>
      call { 
        controllers_ForumController_uploadFile5_invoker.call(ForumController_1.uploadFile())
      }
  
    // @LINE:31
    case controllers_ThumbController_addThumb6_route(params) =>
      call { 
        controllers_ThumbController_addThumb6_invoker.call(ThumbController_5.addThumb())
      }
  
    // @LINE:32
    case controllers_ThumbController_deleteThumb7_route(params) =>
      call(params.fromPath[Integer]("thumb_type", None), params.fromPath[Integer]("sender", None), params.fromPath[Integer]("receiver", None)) { (thumb_type, sender, receiver) =>
        controllers_ThumbController_deleteThumb7_invoker.call(ThumbController_5.deleteThumb(thumb_type, sender, receiver))
      }
  
    // @LINE:33
    case controllers_ThumbController_getThumbSum8_route(params) =>
      call(params.fromPath[String]("user", None), params.fromPath[String]("type", None)) { (user, _pf_escape_type) =>
        controllers_ThumbController_getThumbSum8_invoker.call(ThumbController_5.getThumbSum(user, _pf_escape_type))
      }
  
    // @LINE:37
    case controllers_PostController_addPost9_route(params) =>
      call { 
        controllers_PostController_addPost9_invoker.call(PostController_4.addPost())
      }
  
    // @LINE:38
    case controllers_PostController_getPostById10_route(params) =>
      call(params.fromPath[Long]("postId", None)) { (postId) =>
        controllers_PostController_getPostById10_invoker.call(PostController_4.getPostById(postId))
      }
  
    // @LINE:39
    case controllers_PostController_getAllPosts11_route(params) =>
      call { 
        controllers_PostController_getAllPosts11_invoker.call(PostController_4.getAllPosts())
      }
  
    // @LINE:40
    case controllers_PostController_addComment12_route(params) =>
      call { 
        controllers_PostController_addComment12_invoker.call(PostController_4.addComment())
      }
  
    // @LINE:41
    case controllers_PostController_setAsQuestion13_route(params) =>
      call { 
        controllers_PostController_setAsQuestion13_invoker.call(PostController_4.setAsQuestion())
      }
  
    // @LINE:42
    case controllers_PostController_setAnswer14_route(params) =>
      call { 
        controllers_PostController_setAnswer14_invoker.call(PostController_4.setAnswer())
      }
  
    // @LINE:46
    case controllers_SubscriptionController_loadSubscriptionList15_route(params) =>
      call { 
        controllers_SubscriptionController_loadSubscriptionList15_invoker.call(SubscriptionController_0.loadSubscriptionList())
      }
  
    // @LINE:47
    case controllers_SubscriptionController_loadSubscriptionListByCategory16_route(params) =>
      call(params.fromPath[String]("category", None)) { (category) =>
        controllers_SubscriptionController_loadSubscriptionListByCategory16_invoker.call(SubscriptionController_0.loadSubscriptionListByCategory(category))
      }
  
    // @LINE:48
    case controllers_SubscriptionController_loadTimeline17_route(params) =>
      call { 
        controllers_SubscriptionController_loadTimeline17_invoker.call(SubscriptionController_0.loadTimeline())
      }
  
    // @LINE:49
    case controllers_SubscriptionController_subscribe18_route(params) =>
      call(params.fromPath[Long]("followeeid", None), params.fromPath[String]("category", None)) { (followeeid, category) =>
        controllers_SubscriptionController_subscribe18_invoker.call(SubscriptionController_0.subscribe(followeeid, category))
      }
  
    // @LINE:52
    case controllers_PostController_search19_route(params) =>
      call(params.fromPath[String]("keyword", None)) { (keyword) =>
        controllers_PostController_search19_invoker.call(PostController_4.search(keyword))
      }
  
    // @LINE:53
    case controllers_PostController_getPostByUserId20_route(params) =>
      call(params.fromPath[Long]("userId", None)) { (userId) =>
        controllers_PostController_getPostByUserId20_invoker.call(PostController_4.getPostByUserId(userId))
      }
  
    // @LINE:57
    case controllers_TagController_addTagpub21_route(params) =>
      call(params.fromPath[Long]("pubid", None), params.fromPath[String]("tagpub", None)) { (pubid, tagpub) =>
        controllers_TagController_addTagpub21_invoker.call(TagController_3.addTagpub(pubid, tagpub))
      }
  
    // @LINE:58
    case controllers_TagController_deleteTagpub22_route(params) =>
      call(params.fromPath[Long]("pubid", None), params.fromPath[String]("tagpub", None)) { (pubid, tagpub) =>
        controllers_TagController_deleteTagpub22_invoker.call(TagController_3.deleteTagpub(pubid, tagpub))
      }
  
    // @LINE:59
    case controllers_TagController_getTagpubs23_route(params) =>
      call(params.fromPath[String]("title", None)) { (title) =>
        controllers_TagController_getTagpubs23_invoker.call(TagController_3.getTagpubs(title))
      }
  
    // @LINE:60
    case controllers_TagController_getPublications24_route(params) =>
      call(params.fromPath[String]("tagpub", None)) { (tagpub) =>
        controllers_TagController_getPublications24_invoker.call(TagController_3.getPublications(tagpub))
      }
  
    // @LINE:61
    case controllers_TagController_getTagByPub_id25_route(params) =>
      call(params.fromPath[Long]("pub_id", None)) { (pub_id) =>
        controllers_TagController_getTagByPub_id25_invoker.call(TagController_3.getTagByPub_id(pub_id))
      }
  
    // @LINE:64
    case controllers_TagController_addTagpost26_route(params) =>
      call(params.fromPath[Long]("postid", None), params.fromPath[String]("tagpost", None)) { (postid, tagpost) =>
        controllers_TagController_addTagpost26_invoker.call(TagController_3.addTagpost(postid, tagpost))
      }
  
    // @LINE:65
    case controllers_TagController_deleteTagpost27_route(params) =>
      call(params.fromPath[Long]("postid", None), params.fromPath[String]("tagpost", None)) { (postid, tagpost) =>
        controllers_TagController_deleteTagpost27_invoker.call(TagController_3.deleteTagpost(postid, tagpost))
      }
  
    // @LINE:66
    case controllers_TagController_getTagByPost_id28_route(params) =>
      call(params.fromPath[Long]("post_id", None)) { (post_id) =>
        controllers_TagController_getTagByPost_id28_invoker.call(TagController_3.getTagByPost_id(post_id))
      }
  
    // @LINE:69
    case controllers_Application_getPublicationWithAuthorsByYear29_route(params) =>
      call(params.fromPath[Integer]("year", None)) { (year) =>
        controllers_Application_getPublicationWithAuthorsByYear29_invoker.call(Application_7.getPublicationWithAuthorsByYear(year))
      }
  
    // @LINE:70
    case controllers_Application_getPublicationWithAuthorsById30_route(params) =>
      call(params.fromPath[Integer]("id", None)) { (id) =>
        controllers_Application_getPublicationWithAuthorsById30_invoker.call(Application_7.getPublicationWithAuthorsById(id))
      }
  
    // @LINE:71
    case controllers_Application_getPublicationWithAuthorsByTitle31_route(params) =>
      call(params.fromPath[String]("title", None)) { (title) =>
        controllers_Application_getPublicationWithAuthorsByTitle31_invoker.call(Application_7.getPublicationWithAuthorsByTitle(title))
      }
  
    // @LINE:76
    case controllers_UserProfileController_createuserProfileProfile32_route(params) =>
      call { 
        controllers_UserProfileController_createuserProfileProfile32_invoker.call(UserProfileController_2.createuserProfileProfile())
      }
  
    // @LINE:77
    case controllers_UserProfileController_getUserProfile33_route(params) =>
      call(params.fromPath[String]("userName", None)) { (userName) =>
        controllers_UserProfileController_getUserProfile33_invoker.call(UserProfileController_2.getUserProfile(userName))
      }
  
    // @LINE:78
    case controllers_UserProfileController_refreshUserprofile34_route(params) =>
      call(params.fromPath[String]("userName", None)) { (userName) =>
        controllers_UserProfileController_refreshUserprofile34_invoker.call(UserProfileController_2.refreshUserprofile(userName))
      }
  }
}
