
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/caoyi/Desktop/SSNetwork/backend/conf/routes
// @DATE:Tue Apr 26 17:06:13 PDT 2016

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
  Assets_5: controllers.Assets,
  // @LINE:29
  ForumController_0: controllers.ForumController,
  // @LINE:35
  ThumbController_4: controllers.ThumbController,
  // @LINE:41
  PostController_3: controllers.PostController,
  // @LINE:52
  TagController_2: controllers.TagController,
  // @LINE:71
  UserProfileController_1: controllers.UserProfileController,
  // @LINE:76
  Popularity_6: controllers.Popularity,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    Application_7: controllers.Application,
    // @LINE:9
    Assets_5: controllers.Assets,
    // @LINE:29
    ForumController_0: controllers.ForumController,
    // @LINE:35
    ThumbController_4: controllers.ThumbController,
    // @LINE:41
    PostController_3: controllers.PostController,
    // @LINE:52
    TagController_2: controllers.TagController,
    // @LINE:71
    UserProfileController_1: controllers.UserProfileController,
    // @LINE:76
    Popularity_6: controllers.Popularity
  ) = this(errorHandler, Application_7, Assets_5, ForumController_0, ThumbController_4, PostController_3, TagController_2, UserProfileController_1, Popularity_6, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Application_7, Assets_5, ForumController_0, ThumbController_4, PostController_3, TagController_2, UserProfileController_1, Popularity_6, prefix)
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
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """author/""" + "$" + """author<[^/]+>""", """controllers.Application.getAuthors(author:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """coauthor/""" + "$" + """author<[^/]+>""", """controllers.Application.getCoAuthors(author:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """comment""", """controllers.ForumController.addComment()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """comment""", """controllers.ForumController.getComments(rootid:Integer, categoryid:Integer, userid:Integer)"""),
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
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getCommentSum/""" + "$" + """rootid<[^/]+>""", """controllers.Popularity.getCommentSum(rootid:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getTagSum/""" + "$" + """pubid<[^/]+>""", """controllers.Popularity.getTagSum(pubid:Long)"""),
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
    Assets_5.at(fakeValue[String], fakeValue[String]),
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

  // @LINE:21
  private[this] lazy val controllers_Application_getPaperByYear3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("year/"), DynamicPart("year", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_getPaperByYear3_invoker = createInvoker(
    Application_7.getPaperByYear(fakeValue[Integer]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getPaperByYear",
      Seq(classOf[Integer]),
      "GET",
      """##Suggestion""",
      this.prefix + """year/""" + "$" + """year<[^/]+>"""
    )
  )

  // @LINE:22
  private[this] lazy val controllers_Application_getPaperByTitle4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("title/"), DynamicPart("title", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_getPaperByTitle4_invoker = createInvoker(
    Application_7.getPaperByTitle(fakeValue[String]),
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

  // @LINE:23
  private[this] lazy val controllers_Application_getAllPublications5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("all")))
  )
  private[this] lazy val controllers_Application_getAllPublications5_invoker = createInvoker(
    Application_7.getAllPublications(),
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

  // @LINE:24
  private[this] lazy val controllers_Application_getPaperBykeyWord6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("keyword/"), DynamicPart("keyWord", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_getPaperBykeyWord6_invoker = createInvoker(
    Application_7.getPaperBykeyWord(fakeValue[String]),
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

  // @LINE:25
  private[this] lazy val controllers_Application_getAuthors7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("author/"), DynamicPart("author", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_getAuthors7_invoker = createInvoker(
    Application_7.getAuthors(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getAuthors",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """author/""" + "$" + """author<[^/]+>"""
    )
  )

  // @LINE:26
  private[this] lazy val controllers_Application_getCoAuthors8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("coauthor/"), DynamicPart("author", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_getCoAuthors8_invoker = createInvoker(
    Application_7.getCoAuthors(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getCoAuthors",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """coauthor/""" + "$" + """author<[^/]+>"""
    )
  )

  // @LINE:29
  private[this] lazy val controllers_ForumController_addComment9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("comment")))
  )
  private[this] lazy val controllers_ForumController_addComment9_invoker = createInvoker(
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

  // @LINE:30
  private[this] lazy val controllers_ForumController_getComments10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("comment")))
  )
  private[this] lazy val controllers_ForumController_getComments10_invoker = createInvoker(
    ForumController_0.getComments(fakeValue[Integer], fakeValue[Integer], fakeValue[Integer]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ForumController",
      "getComments",
      Seq(classOf[Integer], classOf[Integer], classOf[Integer]),
      "GET",
      """""",
      this.prefix + """comment"""
    )
  )

  // @LINE:31
  private[this] lazy val controllers_ForumController_updateComment11_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateComment")))
  )
  private[this] lazy val controllers_ForumController_updateComment11_invoker = createInvoker(
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

  // @LINE:32
  private[this] lazy val controllers_ForumController_uploadFile12_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("upload")))
  )
  private[this] lazy val controllers_ForumController_uploadFile12_invoker = createInvoker(
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

  // @LINE:35
  private[this] lazy val controllers_ThumbController_addThumb13_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addThumb")))
  )
  private[this] lazy val controllers_ThumbController_addThumb13_invoker = createInvoker(
    ThumbController_4.addThumb(),
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

  // @LINE:36
  private[this] lazy val controllers_ThumbController_deleteThumb14_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteThumb/"), DynamicPart("thumb_type", """[^/]+""",true), StaticPart("/"), DynamicPart("sender", """[^/]+""",true), StaticPart("/"), DynamicPart("receiver", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ThumbController_deleteThumb14_invoker = createInvoker(
    ThumbController_4.deleteThumb(fakeValue[Integer], fakeValue[Integer], fakeValue[Integer]),
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

  // @LINE:37
  private[this] lazy val controllers_ThumbController_getThumbSum15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getThumbSum/"), DynamicPart("user", """[^/]+""",true), StaticPart("/"), DynamicPart("type", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ThumbController_getThumbSum15_invoker = createInvoker(
    ThumbController_4.getThumbSum(fakeValue[String], fakeValue[String]),
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

  // @LINE:41
  private[this] lazy val controllers_PostController_addPost16_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/addPost")))
  )
  private[this] lazy val controllers_PostController_addPost16_invoker = createInvoker(
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

  // @LINE:42
  private[this] lazy val controllers_PostController_getPostById17_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/getPostById/"), DynamicPart("postId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PostController_getPostById17_invoker = createInvoker(
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

  // @LINE:43
  private[this] lazy val controllers_PostController_getAllPosts18_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/getAllPosts")))
  )
  private[this] lazy val controllers_PostController_getAllPosts18_invoker = createInvoker(
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

  // @LINE:44
  private[this] lazy val controllers_PostController_addComment19_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/addComment")))
  )
  private[this] lazy val controllers_PostController_addComment19_invoker = createInvoker(
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

  // @LINE:45
  private[this] lazy val controllers_PostController_setAsQuestion20_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/setAsQuestion")))
  )
  private[this] lazy val controllers_PostController_setAsQuestion20_invoker = createInvoker(
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

  // @LINE:46
  private[this] lazy val controllers_PostController_setAnswer21_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/setAnswer")))
  )
  private[this] lazy val controllers_PostController_setAnswer21_invoker = createInvoker(
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

  // @LINE:47
  private[this] lazy val controllers_PostController_search22_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/search/"), DynamicPart("keyword", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PostController_search22_invoker = createInvoker(
    PostController_3.search(fakeValue[String]),
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

  // @LINE:48
  private[this] lazy val controllers_PostController_getPostByUserId23_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/getPostByUserId/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PostController_getPostByUserId23_invoker = createInvoker(
    PostController_3.getPostByUserId(fakeValue[Long]),
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

  // @LINE:52
  private[this] lazy val controllers_TagController_addTagpub24_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addtagpub/"), DynamicPart("pubid", """[^/]+""",true), StaticPart("/"), DynamicPart("tagpub", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TagController_addTagpub24_invoker = createInvoker(
    TagController_2.addTagpub(fakeValue[Long], fakeValue[String]),
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

  // @LINE:53
  private[this] lazy val controllers_TagController_deleteTagpub25_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deletetagpub/"), DynamicPart("pubid", """[^/]+""",true), StaticPart("/"), DynamicPart("tagpub", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TagController_deleteTagpub25_invoker = createInvoker(
    TagController_2.deleteTagpub(fakeValue[Long], fakeValue[String]),
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

  // @LINE:54
  private[this] lazy val controllers_TagController_getTagpubs26_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("gettagpubs/"), DynamicPart("title", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TagController_getTagpubs26_invoker = createInvoker(
    TagController_2.getTagpubs(fakeValue[String]),
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

  // @LINE:55
  private[this] lazy val controllers_TagController_getPublications27_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getpublications/"), DynamicPart("tagpub", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TagController_getPublications27_invoker = createInvoker(
    TagController_2.getPublications(fakeValue[String]),
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

  // @LINE:56
  private[this] lazy val controllers_TagController_getTagByPub_id28_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getTag/"), DynamicPart("pub_id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TagController_getTagByPub_id28_invoker = createInvoker(
    TagController_2.getTagByPub_id(fakeValue[Long]),
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

  // @LINE:59
  private[this] lazy val controllers_TagController_addTagpost29_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addtagpost/"), DynamicPart("postid", """[^/]+""",true), StaticPart("/"), DynamicPart("tagpost", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TagController_addTagpost29_invoker = createInvoker(
    TagController_2.addTagpost(fakeValue[Long], fakeValue[String]),
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

  // @LINE:60
  private[this] lazy val controllers_TagController_deleteTagpost30_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deletetagpost/"), DynamicPart("postid", """[^/]+""",true), StaticPart("/"), DynamicPart("tagpost", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TagController_deleteTagpost30_invoker = createInvoker(
    TagController_2.deleteTagpost(fakeValue[Long], fakeValue[String]),
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

  // @LINE:61
  private[this] lazy val controllers_TagController_getTagByPost_id31_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getTagpost/"), DynamicPart("post_id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TagController_getTagByPost_id31_invoker = createInvoker(
    TagController_2.getTagByPost_id(fakeValue[Long]),
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

  // @LINE:64
  private[this] lazy val controllers_Application_getPublicationWithAuthorsByYear32_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("year/"), DynamicPart("year", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_getPublicationWithAuthorsByYear32_invoker = createInvoker(
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

  // @LINE:65
  private[this] lazy val controllers_Application_getPublicationWithAuthorsById33_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("id/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_getPublicationWithAuthorsById33_invoker = createInvoker(
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

  // @LINE:66
  private[this] lazy val controllers_Application_getPublicationWithAuthorsByTitle34_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("title/"), DynamicPart("title", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_getPublicationWithAuthorsByTitle34_invoker = createInvoker(
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

  // @LINE:71
  private[this] lazy val controllers_UserProfileController_createuserProfileProfile35_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("userprofile/create")))
  )
  private[this] lazy val controllers_UserProfileController_createuserProfileProfile35_invoker = createInvoker(
    UserProfileController_1.createuserProfileProfile(),
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

  // @LINE:72
  private[this] lazy val controllers_UserProfileController_getUserProfile36_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("userprofile/"), DynamicPart("userName", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserProfileController_getUserProfile36_invoker = createInvoker(
    UserProfileController_1.getUserProfile(fakeValue[String]),
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

  // @LINE:73
  private[this] lazy val controllers_UserProfileController_refreshUserprofile37_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("userprofile/refresh/"), DynamicPart("userName", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserProfileController_refreshUserprofile37_invoker = createInvoker(
    UserProfileController_1.refreshUserprofile(fakeValue[String]),
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

  // @LINE:76
  private[this] lazy val controllers_Popularity_getCommentSum38_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getCommentSum/"), DynamicPart("rootid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Popularity_getCommentSum38_invoker = createInvoker(
    Popularity_6.getCommentSum(fakeValue[Integer]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Popularity",
      "getCommentSum",
      Seq(classOf[Integer]),
      "GET",
      """Comments Popularity""",
      this.prefix + """getCommentSum/""" + "$" + """rootid<[^/]+>"""
    )
  )

  // @LINE:77
  private[this] lazy val controllers_Popularity_getTagSum39_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getTagSum/"), DynamicPart("pubid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Popularity_getTagSum39_invoker = createInvoker(
    Popularity_6.getTagSum(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Popularity",
      "getTagSum",
      Seq(classOf[Long]),
      "GET",
      """""",
      this.prefix + """getTagSum/""" + "$" + """pubid<[^/]+>"""
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
        controllers_Assets_at1_invoker.call(Assets_5.at(path, file))
      }
  
    // @LINE:11
    case controllers_Application_upload2_route(params) =>
      call { 
        controllers_Application_upload2_invoker.call(Application_7.upload())
      }
  
    // @LINE:21
    case controllers_Application_getPaperByYear3_route(params) =>
      call(params.fromPath[Integer]("year", None)) { (year) =>
        controllers_Application_getPaperByYear3_invoker.call(Application_7.getPaperByYear(year))
      }
  
    // @LINE:22
    case controllers_Application_getPaperByTitle4_route(params) =>
      call(params.fromPath[String]("title", None)) { (title) =>
        controllers_Application_getPaperByTitle4_invoker.call(Application_7.getPaperByTitle(title))
      }
  
    // @LINE:23
    case controllers_Application_getAllPublications5_route(params) =>
      call { 
        controllers_Application_getAllPublications5_invoker.call(Application_7.getAllPublications())
      }
  
    // @LINE:24
    case controllers_Application_getPaperBykeyWord6_route(params) =>
      call(params.fromPath[String]("keyWord", None)) { (keyWord) =>
        controllers_Application_getPaperBykeyWord6_invoker.call(Application_7.getPaperBykeyWord(keyWord))
      }
  
    // @LINE:25
    case controllers_Application_getAuthors7_route(params) =>
      call(params.fromPath[String]("author", None)) { (author) =>
        controllers_Application_getAuthors7_invoker.call(Application_7.getAuthors(author))
      }
  
    // @LINE:26
    case controllers_Application_getCoAuthors8_route(params) =>
      call(params.fromPath[String]("author", None)) { (author) =>
        controllers_Application_getCoAuthors8_invoker.call(Application_7.getCoAuthors(author))
      }
  
    // @LINE:29
    case controllers_ForumController_addComment9_route(params) =>
      call { 
        controllers_ForumController_addComment9_invoker.call(ForumController_0.addComment())
      }
  
    // @LINE:30
    case controllers_ForumController_getComments10_route(params) =>
      call(params.fromQuery[Integer]("rootid", None), params.fromQuery[Integer]("categoryid", None), params.fromQuery[Integer]("userid", None)) { (rootid, categoryid, userid) =>
        controllers_ForumController_getComments10_invoker.call(ForumController_0.getComments(rootid, categoryid, userid))
      }
  
    // @LINE:31
    case controllers_ForumController_updateComment11_route(params) =>
      call { 
        controllers_ForumController_updateComment11_invoker.call(ForumController_0.updateComment())
      }
  
    // @LINE:32
    case controllers_ForumController_uploadFile12_route(params) =>
      call { 
        controllers_ForumController_uploadFile12_invoker.call(ForumController_0.uploadFile())
      }
  
    // @LINE:35
    case controllers_ThumbController_addThumb13_route(params) =>
      call { 
        controllers_ThumbController_addThumb13_invoker.call(ThumbController_4.addThumb())
      }
  
    // @LINE:36
    case controllers_ThumbController_deleteThumb14_route(params) =>
      call(params.fromPath[Integer]("thumb_type", None), params.fromPath[Integer]("sender", None), params.fromPath[Integer]("receiver", None)) { (thumb_type, sender, receiver) =>
        controllers_ThumbController_deleteThumb14_invoker.call(ThumbController_4.deleteThumb(thumb_type, sender, receiver))
      }
  
    // @LINE:37
    case controllers_ThumbController_getThumbSum15_route(params) =>
      call(params.fromPath[String]("user", None), params.fromPath[String]("type", None)) { (user, _pf_escape_type) =>
        controllers_ThumbController_getThumbSum15_invoker.call(ThumbController_4.getThumbSum(user, _pf_escape_type))
      }
  
    // @LINE:41
    case controllers_PostController_addPost16_route(params) =>
      call { 
        controllers_PostController_addPost16_invoker.call(PostController_3.addPost())
      }
  
    // @LINE:42
    case controllers_PostController_getPostById17_route(params) =>
      call(params.fromPath[Long]("postId", None)) { (postId) =>
        controllers_PostController_getPostById17_invoker.call(PostController_3.getPostById(postId))
      }
  
    // @LINE:43
    case controllers_PostController_getAllPosts18_route(params) =>
      call { 
        controllers_PostController_getAllPosts18_invoker.call(PostController_3.getAllPosts())
      }
  
    // @LINE:44
    case controllers_PostController_addComment19_route(params) =>
      call { 
        controllers_PostController_addComment19_invoker.call(PostController_3.addComment())
      }
  
    // @LINE:45
    case controllers_PostController_setAsQuestion20_route(params) =>
      call { 
        controllers_PostController_setAsQuestion20_invoker.call(PostController_3.setAsQuestion())
      }
  
    // @LINE:46
    case controllers_PostController_setAnswer21_route(params) =>
      call { 
        controllers_PostController_setAnswer21_invoker.call(PostController_3.setAnswer())
      }
  
    // @LINE:47
    case controllers_PostController_search22_route(params) =>
      call(params.fromPath[String]("keyword", None)) { (keyword) =>
        controllers_PostController_search22_invoker.call(PostController_3.search(keyword))
      }
  
    // @LINE:48
    case controllers_PostController_getPostByUserId23_route(params) =>
      call(params.fromPath[Long]("userId", None)) { (userId) =>
        controllers_PostController_getPostByUserId23_invoker.call(PostController_3.getPostByUserId(userId))
      }
  
    // @LINE:52
    case controllers_TagController_addTagpub24_route(params) =>
      call(params.fromPath[Long]("pubid", None), params.fromPath[String]("tagpub", None)) { (pubid, tagpub) =>
        controllers_TagController_addTagpub24_invoker.call(TagController_2.addTagpub(pubid, tagpub))
      }
  
    // @LINE:53
    case controllers_TagController_deleteTagpub25_route(params) =>
      call(params.fromPath[Long]("pubid", None), params.fromPath[String]("tagpub", None)) { (pubid, tagpub) =>
        controllers_TagController_deleteTagpub25_invoker.call(TagController_2.deleteTagpub(pubid, tagpub))
      }
  
    // @LINE:54
    case controllers_TagController_getTagpubs26_route(params) =>
      call(params.fromPath[String]("title", None)) { (title) =>
        controllers_TagController_getTagpubs26_invoker.call(TagController_2.getTagpubs(title))
      }
  
    // @LINE:55
    case controllers_TagController_getPublications27_route(params) =>
      call(params.fromPath[String]("tagpub", None)) { (tagpub) =>
        controllers_TagController_getPublications27_invoker.call(TagController_2.getPublications(tagpub))
      }
  
    // @LINE:56
    case controllers_TagController_getTagByPub_id28_route(params) =>
      call(params.fromPath[Long]("pub_id", None)) { (pub_id) =>
        controllers_TagController_getTagByPub_id28_invoker.call(TagController_2.getTagByPub_id(pub_id))
      }
  
    // @LINE:59
    case controllers_TagController_addTagpost29_route(params) =>
      call(params.fromPath[Long]("postid", None), params.fromPath[String]("tagpost", None)) { (postid, tagpost) =>
        controllers_TagController_addTagpost29_invoker.call(TagController_2.addTagpost(postid, tagpost))
      }
  
    // @LINE:60
    case controllers_TagController_deleteTagpost30_route(params) =>
      call(params.fromPath[Long]("postid", None), params.fromPath[String]("tagpost", None)) { (postid, tagpost) =>
        controllers_TagController_deleteTagpost30_invoker.call(TagController_2.deleteTagpost(postid, tagpost))
      }
  
    // @LINE:61
    case controllers_TagController_getTagByPost_id31_route(params) =>
      call(params.fromPath[Long]("post_id", None)) { (post_id) =>
        controllers_TagController_getTagByPost_id31_invoker.call(TagController_2.getTagByPost_id(post_id))
      }
  
    // @LINE:64
    case controllers_Application_getPublicationWithAuthorsByYear32_route(params) =>
      call(params.fromPath[Integer]("year", None)) { (year) =>
        controllers_Application_getPublicationWithAuthorsByYear32_invoker.call(Application_7.getPublicationWithAuthorsByYear(year))
      }
  
    // @LINE:65
    case controllers_Application_getPublicationWithAuthorsById33_route(params) =>
      call(params.fromPath[Integer]("id", None)) { (id) =>
        controllers_Application_getPublicationWithAuthorsById33_invoker.call(Application_7.getPublicationWithAuthorsById(id))
      }
  
    // @LINE:66
    case controllers_Application_getPublicationWithAuthorsByTitle34_route(params) =>
      call(params.fromPath[String]("title", None)) { (title) =>
        controllers_Application_getPublicationWithAuthorsByTitle34_invoker.call(Application_7.getPublicationWithAuthorsByTitle(title))
      }
  
    // @LINE:71
    case controllers_UserProfileController_createuserProfileProfile35_route(params) =>
      call { 
        controllers_UserProfileController_createuserProfileProfile35_invoker.call(UserProfileController_1.createuserProfileProfile())
      }
  
    // @LINE:72
    case controllers_UserProfileController_getUserProfile36_route(params) =>
      call(params.fromPath[String]("userName", None)) { (userName) =>
        controllers_UserProfileController_getUserProfile36_invoker.call(UserProfileController_1.getUserProfile(userName))
      }
  
    // @LINE:73
    case controllers_UserProfileController_refreshUserprofile37_route(params) =>
      call(params.fromPath[String]("userName", None)) { (userName) =>
        controllers_UserProfileController_refreshUserprofile37_invoker.call(UserProfileController_1.refreshUserprofile(userName))
      }
  
    // @LINE:76
    case controllers_Popularity_getCommentSum38_route(params) =>
      call(params.fromPath[Integer]("rootid", None)) { (rootid) =>
        controllers_Popularity_getCommentSum38_invoker.call(Popularity_6.getCommentSum(rootid))
      }
  
    // @LINE:77
    case controllers_Popularity_getTagSum39_route(params) =>
      call(params.fromPath[Long]("pubid", None)) { (pubid) =>
        controllers_Popularity_getTagSum39_invoker.call(Popularity_6.getTagSum(pubid))
      }
  }
}
