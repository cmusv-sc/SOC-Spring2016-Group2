
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/Anna/Documents/graduate2/soc/SSNetwork/backend/conf/routes
// @DATE:Mon May 02 03:38:14 PDT 2016

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
  Application_9: controllers.Application,
  // @LINE:9
  Assets_7: controllers.Assets,
  // @LINE:18
  PublicationController_10: controllers.PublicationController,
  // @LINE:19
  ForumController_1: controllers.ForumController,
  // @LINE:37
  ThumbController_6: controllers.ThumbController,
  // @LINE:43
  PostController_5: controllers.PostController,
  // @LINE:52
  SubscriptionController_0: controllers.SubscriptionController,
  // @LINE:63
  TagController_4: controllers.TagController,
  // @LINE:82
  UserProfileController_2: controllers.UserProfileController,
  // @LINE:88
  Popularity_8: controllers.Popularity,
  // @LINE:95
  UserGroupController_3: controllers.UserGroupController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    Application_9: controllers.Application,
    // @LINE:9
    Assets_7: controllers.Assets,
    // @LINE:18
    PublicationController_10: controllers.PublicationController,
    // @LINE:19
    ForumController_1: controllers.ForumController,
    // @LINE:37
    ThumbController_6: controllers.ThumbController,
    // @LINE:43
    PostController_5: controllers.PostController,
    // @LINE:52
    SubscriptionController_0: controllers.SubscriptionController,
    // @LINE:63
    TagController_4: controllers.TagController,
    // @LINE:82
    UserProfileController_2: controllers.UserProfileController,
    // @LINE:88
    Popularity_8: controllers.Popularity,
    // @LINE:95
    UserGroupController_3: controllers.UserGroupController
  ) = this(errorHandler, Application_9, Assets_7, PublicationController_10, ForumController_1, ThumbController_6, PostController_5, SubscriptionController_0, TagController_4, UserProfileController_2, Popularity_8, UserGroupController_3, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Application_9, Assets_7, PublicationController_10, ForumController_1, ThumbController_6, PostController_5, SubscriptionController_0, TagController_4, UserProfileController_2, Popularity_8, UserGroupController_3, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.Application.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """person/uploadPic""", """controllers.Application.upload()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updatepub/""", """controllers.PublicationController.UpdatePublication(pub_id:Long, title:String, editor:String, year:String, isbn:String, volume:String, pages:String, mdate:String, series:String, publisher:String, booktitle:String, crossref:String, ee:String, author:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """upcommentstatus/""" + "$" + """pub_id<[^/]+>/""" + "$" + """status<[^/]+>""", """controllers.ForumController.updateCommentStatus(pub_id:Long, status:Boolean)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """commentatus/""" + "$" + """pub_id<[^/]+>""", """controllers.ForumController.getCommentStatusByID(pub_id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """year/""" + "$" + """year<[^/]+>""", """controllers.Application.getPaperByYear(year:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """title/""" + "$" + """title<[^/]+>""", """controllers.Application.getPaperByTitle(title:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """all""", """controllers.Application.getAllPublications()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """keyword/""" + "$" + """keyWord<[^/]+>""", """controllers.Application.getPaperBykeyWord(keyWord:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """author/""" + "$" + """author<[^/]+>""", """controllers.Application.getAuthors(author:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """coauthor/""" + "$" + """author<[^/]+>""", """controllers.Application.getCoAuthors(author:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """comment""", """controllers.ForumController.addComment()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """comment""", """controllers.ForumController.getComments(rootid:Integer, categoryid:Integer, userid:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateComment""", """controllers.ForumController.updateComment()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """upload""", """controllers.ForumController.uploadFile()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addThumb""", """controllers.ThumbController.addThumb()"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteThumb/""" + "$" + """thumb_type<[^/]+>/""" + "$" + """sender<[^/]+>/""" + "$" + """receiver<[^/]+>""", """controllers.ThumbController.deleteThumb(thumb_type:Integer, sender:String, receiver:Integer)"""),
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
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateTag/""", """controllers.TagController.updateTagPub(pubid:Long, tagpub:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addtagpost/""" + "$" + """postid<[^/]+>/""" + "$" + """tagpost<[^/]+>""", """controllers.TagController.addTagpost(postid:Long, tagpost:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deletetagpost/""" + "$" + """postid<[^/]+>/""" + "$" + """tagpost<[^/]+>""", """controllers.TagController.deleteTagpost(postid:Long, tagpost:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getTagpost/""" + "$" + """post_id<[^/]+>""", """controllers.TagController.getTagByPost_id(post_id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """paper/year/""" + "$" + """year<[^/]+>""", """controllers.Application.getPublicationWithAuthorsByYear(year:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """paper/id/""" + "$" + """id<[^/]+>""", """controllers.Application.getPublicationWithAuthorsById(id:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """paper/title/""" + "$" + """title<[^/]+>""", """controllers.Application.getPublicationWithAuthorsByTitle(title:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """userprofile/create""", """controllers.UserProfileController.createuserProfileProfile()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """userprofile/""" + "$" + """userName<[^/]+>""", """controllers.UserProfileController.getUserProfile(userName:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """userprofile/refresh/""" + "$" + """userName<[^/]+>""", """controllers.UserProfileController.refreshUserprofile(userName:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getCommentSum/""" + "$" + """rootid<[^/]+>""", """controllers.Popularity.getCommentSum(rootid:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getTagSum/""" + "$" + """pubid<[^/]+>""", """controllers.Popularity.getTagSum(pubid:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getPopularityByYear/""" + "$" + """year<[^/]+>""", """controllers.Popularity.getPopularityByYear(year:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getMostPopularity""", """controllers.Popularity.getMostPopularity()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAuthorPopularity/""" + "$" + """author<[^/]+>""", """controllers.Popularity.getAuthorPopularity(author:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """groups/""" + "$" + """grouptype<[^/]+>""", """controllers.UserGroupController.getGroupList(grouptype:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """group/own/""" + "$" + """userid<[^/]+>""", """controllers.UserGroupController.getOwnGroup(userid:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """groups""", """controllers.UserGroupController.saveGroup()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """group/notification""", """controllers.UserGroupController.saveNotification()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """group/notification/""" + "$" + """userid<[^/]+>""", """controllers.UserGroupController.getNotifcation(userid:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """group/resnotification""", """controllers.UserGroupController.resNotification()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """group/""" + "$" + """groupname<[^/]+>/message""", """controllers.UserGroupController.getGroupMessage(groupname:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """group/message""", """controllers.UserGroupController.saveMessage()"""),
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
    Application_9.index(),
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
    Assets_7.at(fakeValue[String], fakeValue[String]),
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
    Application_9.upload(),
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

  // @LINE:18
  private[this] lazy val controllers_PublicationController_UpdatePublication3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updatepub/")))
  )
  private[this] lazy val controllers_PublicationController_UpdatePublication3_invoker = createInvoker(
    PublicationController_10.UpdatePublication(fakeValue[Long], fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PublicationController",
      "UpdatePublication",
      Seq(classOf[Long], classOf[String], classOf[String], classOf[String], classOf[String], classOf[String], classOf[String], classOf[String], classOf[String], classOf[String], classOf[String], classOf[String], classOf[String], classOf[String]),
      "GET",
      """ update publication information.""",
      this.prefix + """updatepub/"""
    )
  )

  // @LINE:19
  private[this] lazy val controllers_ForumController_updateCommentStatus4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("upcommentstatus/"), DynamicPart("pub_id", """[^/]+""",true), StaticPart("/"), DynamicPart("status", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ForumController_updateCommentStatus4_invoker = createInvoker(
    ForumController_1.updateCommentStatus(fakeValue[Long], fakeValue[Boolean]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ForumController",
      "updateCommentStatus",
      Seq(classOf[Long], classOf[Boolean]),
      "GET",
      """""",
      this.prefix + """upcommentstatus/""" + "$" + """pub_id<[^/]+>/""" + "$" + """status<[^/]+>"""
    )
  )

  // @LINE:21
  private[this] lazy val controllers_ForumController_getCommentStatusByID5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("commentatus/"), DynamicPart("pub_id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ForumController_getCommentStatusByID5_invoker = createInvoker(
    ForumController_1.getCommentStatusByID(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ForumController",
      "getCommentStatusByID",
      Seq(classOf[Long]),
      "GET",
      """""",
      this.prefix + """commentatus/""" + "$" + """pub_id<[^/]+>"""
    )
  )

  // @LINE:23
  private[this] lazy val controllers_Application_getPaperByYear6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("year/"), DynamicPart("year", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_getPaperByYear6_invoker = createInvoker(
    Application_9.getPaperByYear(fakeValue[Integer]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getPaperByYear",
      Seq(classOf[Integer]),
      "GET",
      """""",
      this.prefix + """year/""" + "$" + """year<[^/]+>"""
    )
  )

  // @LINE:24
  private[this] lazy val controllers_Application_getPaperByTitle7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("title/"), DynamicPart("title", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_getPaperByTitle7_invoker = createInvoker(
    Application_9.getPaperByTitle(fakeValue[String]),
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

  // @LINE:25
  private[this] lazy val controllers_Application_getAllPublications8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("all")))
  )
  private[this] lazy val controllers_Application_getAllPublications8_invoker = createInvoker(
    Application_9.getAllPublications(),
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

  // @LINE:26
  private[this] lazy val controllers_Application_getPaperBykeyWord9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("keyword/"), DynamicPart("keyWord", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_getPaperBykeyWord9_invoker = createInvoker(
    Application_9.getPaperBykeyWord(fakeValue[String]),
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

  // @LINE:27
  private[this] lazy val controllers_Application_getAuthors10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("author/"), DynamicPart("author", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_getAuthors10_invoker = createInvoker(
    Application_9.getAuthors(fakeValue[String]),
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

  // @LINE:28
  private[this] lazy val controllers_Application_getCoAuthors11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("coauthor/"), DynamicPart("author", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_getCoAuthors11_invoker = createInvoker(
    Application_9.getCoAuthors(fakeValue[String]),
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

  // @LINE:31
  private[this] lazy val controllers_ForumController_addComment12_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("comment")))
  )
  private[this] lazy val controllers_ForumController_addComment12_invoker = createInvoker(
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

  // @LINE:32
  private[this] lazy val controllers_ForumController_getComments13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("comment")))
  )
  private[this] lazy val controllers_ForumController_getComments13_invoker = createInvoker(
    ForumController_1.getComments(fakeValue[Integer], fakeValue[Integer], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ForumController",
      "getComments",
      Seq(classOf[Integer], classOf[Integer], classOf[String]),
      "GET",
      """""",
      this.prefix + """comment"""
    )
  )

  // @LINE:33
  private[this] lazy val controllers_ForumController_updateComment14_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateComment")))
  )
  private[this] lazy val controllers_ForumController_updateComment14_invoker = createInvoker(
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

  // @LINE:34
  private[this] lazy val controllers_ForumController_uploadFile15_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("upload")))
  )
  private[this] lazy val controllers_ForumController_uploadFile15_invoker = createInvoker(
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

  // @LINE:37
  private[this] lazy val controllers_ThumbController_addThumb16_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addThumb")))
  )
  private[this] lazy val controllers_ThumbController_addThumb16_invoker = createInvoker(
    ThumbController_6.addThumb(),
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

  // @LINE:38
  private[this] lazy val controllers_ThumbController_deleteThumb17_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteThumb/"), DynamicPart("thumb_type", """[^/]+""",true), StaticPart("/"), DynamicPart("sender", """[^/]+""",true), StaticPart("/"), DynamicPart("receiver", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ThumbController_deleteThumb17_invoker = createInvoker(
    ThumbController_6.deleteThumb(fakeValue[Integer], fakeValue[String], fakeValue[Integer]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ThumbController",
      "deleteThumb",
      Seq(classOf[Integer], classOf[String], classOf[Integer]),
      "DELETE",
      """""",
      this.prefix + """deleteThumb/""" + "$" + """thumb_type<[^/]+>/""" + "$" + """sender<[^/]+>/""" + "$" + """receiver<[^/]+>"""
    )
  )

  // @LINE:39
  private[this] lazy val controllers_ThumbController_getThumbSum18_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getThumbSum/"), DynamicPart("user", """[^/]+""",true), StaticPart("/"), DynamicPart("type", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ThumbController_getThumbSum18_invoker = createInvoker(
    ThumbController_6.getThumbSum(fakeValue[String], fakeValue[String]),
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

  // @LINE:43
  private[this] lazy val controllers_PostController_addPost19_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/addPost")))
  )
  private[this] lazy val controllers_PostController_addPost19_invoker = createInvoker(
    PostController_5.addPost(),
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

  // @LINE:44
  private[this] lazy val controllers_PostController_getPostById20_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/getPostById/"), DynamicPart("postId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PostController_getPostById20_invoker = createInvoker(
    PostController_5.getPostById(fakeValue[Long]),
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

  // @LINE:45
  private[this] lazy val controllers_PostController_getAllPosts21_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/getAllPosts")))
  )
  private[this] lazy val controllers_PostController_getAllPosts21_invoker = createInvoker(
    PostController_5.getAllPosts(),
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

  // @LINE:46
  private[this] lazy val controllers_PostController_addComment22_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/addComment")))
  )
  private[this] lazy val controllers_PostController_addComment22_invoker = createInvoker(
    PostController_5.addComment(),
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

  // @LINE:47
  private[this] lazy val controllers_PostController_setAsQuestion23_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/setAsQuestion")))
  )
  private[this] lazy val controllers_PostController_setAsQuestion23_invoker = createInvoker(
    PostController_5.setAsQuestion(),
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

  // @LINE:48
  private[this] lazy val controllers_PostController_setAnswer24_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/setAnswer")))
  )
  private[this] lazy val controllers_PostController_setAnswer24_invoker = createInvoker(
    PostController_5.setAnswer(),
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

  // @LINE:52
  private[this] lazy val controllers_SubscriptionController_loadSubscriptionList25_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("subscribe/list/all")))
  )
  private[this] lazy val controllers_SubscriptionController_loadSubscriptionList25_invoker = createInvoker(
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

  // @LINE:53
  private[this] lazy val controllers_SubscriptionController_loadSubscriptionListByCategory26_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("subscribe/list/"), DynamicPart("category", """[^/]+""",true)))
  )
  private[this] lazy val controllers_SubscriptionController_loadSubscriptionListByCategory26_invoker = createInvoker(
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

  // @LINE:54
  private[this] lazy val controllers_SubscriptionController_loadTimeline27_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("subscribe/timeline")))
  )
  private[this] lazy val controllers_SubscriptionController_loadTimeline27_invoker = createInvoker(
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

  // @LINE:55
  private[this] lazy val controllers_SubscriptionController_subscribe28_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("subscribe/"), DynamicPart("followeeid", """[^/]+""",true), StaticPart("/"), DynamicPart("category", """[^/]+""",true)))
  )
  private[this] lazy val controllers_SubscriptionController_subscribe28_invoker = createInvoker(
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

  // @LINE:58
  private[this] lazy val controllers_PostController_search29_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/search/"), DynamicPart("keyword", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PostController_search29_invoker = createInvoker(
    PostController_5.search(fakeValue[String]),
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

  // @LINE:59
  private[this] lazy val controllers_PostController_getPostByUserId30_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/getPostByUserId/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PostController_getPostByUserId30_invoker = createInvoker(
    PostController_5.getPostByUserId(fakeValue[Long]),
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

  // @LINE:63
  private[this] lazy val controllers_TagController_addTagpub31_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addtagpub/"), DynamicPart("pubid", """[^/]+""",true), StaticPart("/"), DynamicPart("tagpub", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TagController_addTagpub31_invoker = createInvoker(
    TagController_4.addTagpub(fakeValue[Long], fakeValue[String]),
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

  // @LINE:64
  private[this] lazy val controllers_TagController_deleteTagpub32_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deletetagpub/"), DynamicPart("pubid", """[^/]+""",true), StaticPart("/"), DynamicPart("tagpub", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TagController_deleteTagpub32_invoker = createInvoker(
    TagController_4.deleteTagpub(fakeValue[Long], fakeValue[String]),
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

  // @LINE:65
  private[this] lazy val controllers_TagController_getTagpubs33_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("gettagpubs/"), DynamicPart("title", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TagController_getTagpubs33_invoker = createInvoker(
    TagController_4.getTagpubs(fakeValue[String]),
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

  // @LINE:66
  private[this] lazy val controllers_TagController_getPublications34_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getpublications/"), DynamicPart("tagpub", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TagController_getPublications34_invoker = createInvoker(
    TagController_4.getPublications(fakeValue[String]),
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

  // @LINE:67
  private[this] lazy val controllers_TagController_getTagByPub_id35_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getTag/"), DynamicPart("pub_id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TagController_getTagByPub_id35_invoker = createInvoker(
    TagController_4.getTagByPub_id(fakeValue[Long]),
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

  // @LINE:68
  private[this] lazy val controllers_TagController_updateTagPub36_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateTag/")))
  )
  private[this] lazy val controllers_TagController_updateTagPub36_invoker = createInvoker(
    TagController_4.updateTagPub(fakeValue[Long], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TagController",
      "updateTagPub",
      Seq(classOf[Long], classOf[String]),
      "GET",
      """""",
      this.prefix + """updateTag/"""
    )
  )

  // @LINE:71
  private[this] lazy val controllers_TagController_addTagpost37_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addtagpost/"), DynamicPart("postid", """[^/]+""",true), StaticPart("/"), DynamicPart("tagpost", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TagController_addTagpost37_invoker = createInvoker(
    TagController_4.addTagpost(fakeValue[Long], fakeValue[String]),
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

  // @LINE:72
  private[this] lazy val controllers_TagController_deleteTagpost38_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deletetagpost/"), DynamicPart("postid", """[^/]+""",true), StaticPart("/"), DynamicPart("tagpost", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TagController_deleteTagpost38_invoker = createInvoker(
    TagController_4.deleteTagpost(fakeValue[Long], fakeValue[String]),
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

  // @LINE:73
  private[this] lazy val controllers_TagController_getTagByPost_id39_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getTagpost/"), DynamicPart("post_id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TagController_getTagByPost_id39_invoker = createInvoker(
    TagController_4.getTagByPost_id(fakeValue[Long]),
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

  // @LINE:76
  private[this] lazy val controllers_Application_getPublicationWithAuthorsByYear40_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("paper/year/"), DynamicPart("year", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_getPublicationWithAuthorsByYear40_invoker = createInvoker(
    Application_9.getPublicationWithAuthorsByYear(fakeValue[Integer]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getPublicationWithAuthorsByYear",
      Seq(classOf[Integer]),
      "GET",
      """""",
      this.prefix + """paper/year/""" + "$" + """year<[^/]+>"""
    )
  )

  // @LINE:77
  private[this] lazy val controllers_Application_getPublicationWithAuthorsById41_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("paper/id/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_getPublicationWithAuthorsById41_invoker = createInvoker(
    Application_9.getPublicationWithAuthorsById(fakeValue[Integer]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getPublicationWithAuthorsById",
      Seq(classOf[Integer]),
      "GET",
      """""",
      this.prefix + """paper/id/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:78
  private[this] lazy val controllers_Application_getPublicationWithAuthorsByTitle42_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("paper/title/"), DynamicPart("title", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_getPublicationWithAuthorsByTitle42_invoker = createInvoker(
    Application_9.getPublicationWithAuthorsByTitle(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getPublicationWithAuthorsByTitle",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """paper/title/""" + "$" + """title<[^/]+>"""
    )
  )

  // @LINE:82
  private[this] lazy val controllers_UserProfileController_createuserProfileProfile43_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("userprofile/create")))
  )
  private[this] lazy val controllers_UserProfileController_createuserProfileProfile43_invoker = createInvoker(
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

  // @LINE:83
  private[this] lazy val controllers_UserProfileController_getUserProfile44_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("userprofile/"), DynamicPart("userName", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserProfileController_getUserProfile44_invoker = createInvoker(
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

  // @LINE:84
  private[this] lazy val controllers_UserProfileController_refreshUserprofile45_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("userprofile/refresh/"), DynamicPart("userName", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserProfileController_refreshUserprofile45_invoker = createInvoker(
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

  // @LINE:88
  private[this] lazy val controllers_Popularity_getCommentSum46_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getCommentSum/"), DynamicPart("rootid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Popularity_getCommentSum46_invoker = createInvoker(
    Popularity_8.getCommentSum(fakeValue[Integer]),
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

  // @LINE:89
  private[this] lazy val controllers_Popularity_getTagSum47_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getTagSum/"), DynamicPart("pubid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Popularity_getTagSum47_invoker = createInvoker(
    Popularity_8.getTagSum(fakeValue[Long]),
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

  // @LINE:90
  private[this] lazy val controllers_Popularity_getPopularityByYear48_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getPopularityByYear/"), DynamicPart("year", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Popularity_getPopularityByYear48_invoker = createInvoker(
    Popularity_8.getPopularityByYear(fakeValue[Integer]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Popularity",
      "getPopularityByYear",
      Seq(classOf[Integer]),
      "GET",
      """""",
      this.prefix + """getPopularityByYear/""" + "$" + """year<[^/]+>"""
    )
  )

  // @LINE:91
  private[this] lazy val controllers_Popularity_getMostPopularity49_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getMostPopularity")))
  )
  private[this] lazy val controllers_Popularity_getMostPopularity49_invoker = createInvoker(
    Popularity_8.getMostPopularity(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Popularity",
      "getMostPopularity",
      Nil,
      "GET",
      """""",
      this.prefix + """getMostPopularity"""
    )
  )

  // @LINE:92
  private[this] lazy val controllers_Popularity_getAuthorPopularity50_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAuthorPopularity/"), DynamicPart("author", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Popularity_getAuthorPopularity50_invoker = createInvoker(
    Popularity_8.getAuthorPopularity(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Popularity",
      "getAuthorPopularity",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """getAuthorPopularity/""" + "$" + """author<[^/]+>"""
    )
  )

  // @LINE:95
  private[this] lazy val controllers_UserGroupController_getGroupList51_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("groups/"), DynamicPart("grouptype", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserGroupController_getGroupList51_invoker = createInvoker(
    UserGroupController_3.getGroupList(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserGroupController",
      "getGroupList",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """groups/""" + "$" + """grouptype<[^/]+>"""
    )
  )

  // @LINE:96
  private[this] lazy val controllers_UserGroupController_getOwnGroup52_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("group/own/"), DynamicPart("userid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserGroupController_getOwnGroup52_invoker = createInvoker(
    UserGroupController_3.getOwnGroup(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserGroupController",
      "getOwnGroup",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """group/own/""" + "$" + """userid<[^/]+>"""
    )
  )

  // @LINE:97
  private[this] lazy val controllers_UserGroupController_saveGroup53_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("groups")))
  )
  private[this] lazy val controllers_UserGroupController_saveGroup53_invoker = createInvoker(
    UserGroupController_3.saveGroup(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserGroupController",
      "saveGroup",
      Nil,
      "POST",
      """""",
      this.prefix + """groups"""
    )
  )

  // @LINE:98
  private[this] lazy val controllers_UserGroupController_saveNotification54_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("group/notification")))
  )
  private[this] lazy val controllers_UserGroupController_saveNotification54_invoker = createInvoker(
    UserGroupController_3.saveNotification(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserGroupController",
      "saveNotification",
      Nil,
      "POST",
      """""",
      this.prefix + """group/notification"""
    )
  )

  // @LINE:99
  private[this] lazy val controllers_UserGroupController_getNotifcation55_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("group/notification/"), DynamicPart("userid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserGroupController_getNotifcation55_invoker = createInvoker(
    UserGroupController_3.getNotifcation(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserGroupController",
      "getNotifcation",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """group/notification/""" + "$" + """userid<[^/]+>"""
    )
  )

  // @LINE:100
  private[this] lazy val controllers_UserGroupController_resNotification56_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("group/resnotification")))
  )
  private[this] lazy val controllers_UserGroupController_resNotification56_invoker = createInvoker(
    UserGroupController_3.resNotification(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserGroupController",
      "resNotification",
      Nil,
      "POST",
      """""",
      this.prefix + """group/resnotification"""
    )
  )

  // @LINE:101
  private[this] lazy val controllers_UserGroupController_getGroupMessage57_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("group/"), DynamicPart("groupname", """[^/]+""",true), StaticPart("/message")))
  )
  private[this] lazy val controllers_UserGroupController_getGroupMessage57_invoker = createInvoker(
    UserGroupController_3.getGroupMessage(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserGroupController",
      "getGroupMessage",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """group/""" + "$" + """groupname<[^/]+>/message"""
    )
  )

  // @LINE:102
  private[this] lazy val controllers_UserGroupController_saveMessage58_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("group/message")))
  )
  private[this] lazy val controllers_UserGroupController_saveMessage58_invoker = createInvoker(
    UserGroupController_3.saveMessage(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserGroupController",
      "saveMessage",
      Nil,
      "POST",
      """""",
      this.prefix + """group/message"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_Application_index0_route(params) =>
      call { 
        controllers_Application_index0_invoker.call(Application_9.index())
      }
  
    // @LINE:9
    case controllers_Assets_at1_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at1_invoker.call(Assets_7.at(path, file))
      }
  
    // @LINE:11
    case controllers_Application_upload2_route(params) =>
      call { 
        controllers_Application_upload2_invoker.call(Application_9.upload())
      }
  
    // @LINE:18
    case controllers_PublicationController_UpdatePublication3_route(params) =>
      call(params.fromQuery[Long]("pub_id", None), params.fromQuery[String]("title", None), params.fromQuery[String]("editor", None), params.fromQuery[String]("year", None), params.fromQuery[String]("isbn", None), params.fromQuery[String]("volume", None), params.fromQuery[String]("pages", None), params.fromQuery[String]("mdate", None), params.fromQuery[String]("series", None), params.fromQuery[String]("publisher", None), params.fromQuery[String]("booktitle", None), params.fromQuery[String]("crossref", None), params.fromQuery[String]("ee", None), params.fromQuery[String]("author", None)) { (pub_id, title, editor, year, isbn, volume, pages, mdate, series, publisher, booktitle, crossref, ee, author) =>
        controllers_PublicationController_UpdatePublication3_invoker.call(PublicationController_10.UpdatePublication(pub_id, title, editor, year, isbn, volume, pages, mdate, series, publisher, booktitle, crossref, ee, author))
      }
  
    // @LINE:19
    case controllers_ForumController_updateCommentStatus4_route(params) =>
      call(params.fromPath[Long]("pub_id", None), params.fromPath[Boolean]("status", None)) { (pub_id, status) =>
        controllers_ForumController_updateCommentStatus4_invoker.call(ForumController_1.updateCommentStatus(pub_id, status))
      }
  
    // @LINE:21
    case controllers_ForumController_getCommentStatusByID5_route(params) =>
      call(params.fromPath[Long]("pub_id", None)) { (pub_id) =>
        controllers_ForumController_getCommentStatusByID5_invoker.call(ForumController_1.getCommentStatusByID(pub_id))
      }
  
    // @LINE:23
    case controllers_Application_getPaperByYear6_route(params) =>
      call(params.fromPath[Integer]("year", None)) { (year) =>
        controllers_Application_getPaperByYear6_invoker.call(Application_9.getPaperByYear(year))
      }
  
    // @LINE:24
    case controllers_Application_getPaperByTitle7_route(params) =>
      call(params.fromPath[String]("title", None)) { (title) =>
        controllers_Application_getPaperByTitle7_invoker.call(Application_9.getPaperByTitle(title))
      }
  
    // @LINE:25
    case controllers_Application_getAllPublications8_route(params) =>
      call { 
        controllers_Application_getAllPublications8_invoker.call(Application_9.getAllPublications())
      }
  
    // @LINE:26
    case controllers_Application_getPaperBykeyWord9_route(params) =>
      call(params.fromPath[String]("keyWord", None)) { (keyWord) =>
        controllers_Application_getPaperBykeyWord9_invoker.call(Application_9.getPaperBykeyWord(keyWord))
      }
  
    // @LINE:27
    case controllers_Application_getAuthors10_route(params) =>
      call(params.fromPath[String]("author", None)) { (author) =>
        controllers_Application_getAuthors10_invoker.call(Application_9.getAuthors(author))
      }
  
    // @LINE:28
    case controllers_Application_getCoAuthors11_route(params) =>
      call(params.fromPath[String]("author", None)) { (author) =>
        controllers_Application_getCoAuthors11_invoker.call(Application_9.getCoAuthors(author))
      }
  
    // @LINE:31
    case controllers_ForumController_addComment12_route(params) =>
      call { 
        controllers_ForumController_addComment12_invoker.call(ForumController_1.addComment())
      }
  
    // @LINE:32
    case controllers_ForumController_getComments13_route(params) =>
      call(params.fromQuery[Integer]("rootid", None), params.fromQuery[Integer]("categoryid", None), params.fromQuery[String]("userid", None)) { (rootid, categoryid, userid) =>
        controllers_ForumController_getComments13_invoker.call(ForumController_1.getComments(rootid, categoryid, userid))
      }
  
    // @LINE:33
    case controllers_ForumController_updateComment14_route(params) =>
      call { 
        controllers_ForumController_updateComment14_invoker.call(ForumController_1.updateComment())
      }
  
    // @LINE:34
    case controllers_ForumController_uploadFile15_route(params) =>
      call { 
        controllers_ForumController_uploadFile15_invoker.call(ForumController_1.uploadFile())
      }
  
    // @LINE:37
    case controllers_ThumbController_addThumb16_route(params) =>
      call { 
        controllers_ThumbController_addThumb16_invoker.call(ThumbController_6.addThumb())
      }
  
    // @LINE:38
    case controllers_ThumbController_deleteThumb17_route(params) =>
      call(params.fromPath[Integer]("thumb_type", None), params.fromPath[String]("sender", None), params.fromPath[Integer]("receiver", None)) { (thumb_type, sender, receiver) =>
        controllers_ThumbController_deleteThumb17_invoker.call(ThumbController_6.deleteThumb(thumb_type, sender, receiver))
      }
  
    // @LINE:39
    case controllers_ThumbController_getThumbSum18_route(params) =>
      call(params.fromPath[String]("user", None), params.fromPath[String]("type", None)) { (user, _pf_escape_type) =>
        controllers_ThumbController_getThumbSum18_invoker.call(ThumbController_6.getThumbSum(user, _pf_escape_type))
      }
  
    // @LINE:43
    case controllers_PostController_addPost19_route(params) =>
      call { 
        controllers_PostController_addPost19_invoker.call(PostController_5.addPost())
      }
  
    // @LINE:44
    case controllers_PostController_getPostById20_route(params) =>
      call(params.fromPath[Long]("postId", None)) { (postId) =>
        controllers_PostController_getPostById20_invoker.call(PostController_5.getPostById(postId))
      }
  
    // @LINE:45
    case controllers_PostController_getAllPosts21_route(params) =>
      call { 
        controllers_PostController_getAllPosts21_invoker.call(PostController_5.getAllPosts())
      }
  
    // @LINE:46
    case controllers_PostController_addComment22_route(params) =>
      call { 
        controllers_PostController_addComment22_invoker.call(PostController_5.addComment())
      }
  
    // @LINE:47
    case controllers_PostController_setAsQuestion23_route(params) =>
      call { 
        controllers_PostController_setAsQuestion23_invoker.call(PostController_5.setAsQuestion())
      }
  
    // @LINE:48
    case controllers_PostController_setAnswer24_route(params) =>
      call { 
        controllers_PostController_setAnswer24_invoker.call(PostController_5.setAnswer())
      }
  
    // @LINE:52
    case controllers_SubscriptionController_loadSubscriptionList25_route(params) =>
      call { 
        controllers_SubscriptionController_loadSubscriptionList25_invoker.call(SubscriptionController_0.loadSubscriptionList())
      }
  
    // @LINE:53
    case controllers_SubscriptionController_loadSubscriptionListByCategory26_route(params) =>
      call(params.fromPath[String]("category", None)) { (category) =>
        controllers_SubscriptionController_loadSubscriptionListByCategory26_invoker.call(SubscriptionController_0.loadSubscriptionListByCategory(category))
      }
  
    // @LINE:54
    case controllers_SubscriptionController_loadTimeline27_route(params) =>
      call { 
        controllers_SubscriptionController_loadTimeline27_invoker.call(SubscriptionController_0.loadTimeline())
      }
  
    // @LINE:55
    case controllers_SubscriptionController_subscribe28_route(params) =>
      call(params.fromPath[Long]("followeeid", None), params.fromPath[String]("category", None)) { (followeeid, category) =>
        controllers_SubscriptionController_subscribe28_invoker.call(SubscriptionController_0.subscribe(followeeid, category))
      }
  
    // @LINE:58
    case controllers_PostController_search29_route(params) =>
      call(params.fromPath[String]("keyword", None)) { (keyword) =>
        controllers_PostController_search29_invoker.call(PostController_5.search(keyword))
      }
  
    // @LINE:59
    case controllers_PostController_getPostByUserId30_route(params) =>
      call(params.fromPath[Long]("userId", None)) { (userId) =>
        controllers_PostController_getPostByUserId30_invoker.call(PostController_5.getPostByUserId(userId))
      }
  
    // @LINE:63
    case controllers_TagController_addTagpub31_route(params) =>
      call(params.fromPath[Long]("pubid", None), params.fromPath[String]("tagpub", None)) { (pubid, tagpub) =>
        controllers_TagController_addTagpub31_invoker.call(TagController_4.addTagpub(pubid, tagpub))
      }
  
    // @LINE:64
    case controllers_TagController_deleteTagpub32_route(params) =>
      call(params.fromPath[Long]("pubid", None), params.fromPath[String]("tagpub", None)) { (pubid, tagpub) =>
        controllers_TagController_deleteTagpub32_invoker.call(TagController_4.deleteTagpub(pubid, tagpub))
      }
  
    // @LINE:65
    case controllers_TagController_getTagpubs33_route(params) =>
      call(params.fromPath[String]("title", None)) { (title) =>
        controllers_TagController_getTagpubs33_invoker.call(TagController_4.getTagpubs(title))
      }
  
    // @LINE:66
    case controllers_TagController_getPublications34_route(params) =>
      call(params.fromPath[String]("tagpub", None)) { (tagpub) =>
        controllers_TagController_getPublications34_invoker.call(TagController_4.getPublications(tagpub))
      }
  
    // @LINE:67
    case controllers_TagController_getTagByPub_id35_route(params) =>
      call(params.fromPath[Long]("pub_id", None)) { (pub_id) =>
        controllers_TagController_getTagByPub_id35_invoker.call(TagController_4.getTagByPub_id(pub_id))
      }
  
    // @LINE:68
    case controllers_TagController_updateTagPub36_route(params) =>
      call(params.fromQuery[Long]("pubid", None), params.fromQuery[String]("tagpub", None)) { (pubid, tagpub) =>
        controllers_TagController_updateTagPub36_invoker.call(TagController_4.updateTagPub(pubid, tagpub))
      }
  
    // @LINE:71
    case controllers_TagController_addTagpost37_route(params) =>
      call(params.fromPath[Long]("postid", None), params.fromPath[String]("tagpost", None)) { (postid, tagpost) =>
        controllers_TagController_addTagpost37_invoker.call(TagController_4.addTagpost(postid, tagpost))
      }
  
    // @LINE:72
    case controllers_TagController_deleteTagpost38_route(params) =>
      call(params.fromPath[Long]("postid", None), params.fromPath[String]("tagpost", None)) { (postid, tagpost) =>
        controllers_TagController_deleteTagpost38_invoker.call(TagController_4.deleteTagpost(postid, tagpost))
      }
  
    // @LINE:73
    case controllers_TagController_getTagByPost_id39_route(params) =>
      call(params.fromPath[Long]("post_id", None)) { (post_id) =>
        controllers_TagController_getTagByPost_id39_invoker.call(TagController_4.getTagByPost_id(post_id))
      }
  
    // @LINE:76
    case controllers_Application_getPublicationWithAuthorsByYear40_route(params) =>
      call(params.fromPath[Integer]("year", None)) { (year) =>
        controllers_Application_getPublicationWithAuthorsByYear40_invoker.call(Application_9.getPublicationWithAuthorsByYear(year))
      }
  
    // @LINE:77
    case controllers_Application_getPublicationWithAuthorsById41_route(params) =>
      call(params.fromPath[Integer]("id", None)) { (id) =>
        controllers_Application_getPublicationWithAuthorsById41_invoker.call(Application_9.getPublicationWithAuthorsById(id))
      }
  
    // @LINE:78
    case controllers_Application_getPublicationWithAuthorsByTitle42_route(params) =>
      call(params.fromPath[String]("title", None)) { (title) =>
        controllers_Application_getPublicationWithAuthorsByTitle42_invoker.call(Application_9.getPublicationWithAuthorsByTitle(title))
      }
  
    // @LINE:82
    case controllers_UserProfileController_createuserProfileProfile43_route(params) =>
      call { 
        controllers_UserProfileController_createuserProfileProfile43_invoker.call(UserProfileController_2.createuserProfileProfile())
      }
  
    // @LINE:83
    case controllers_UserProfileController_getUserProfile44_route(params) =>
      call(params.fromPath[String]("userName", None)) { (userName) =>
        controllers_UserProfileController_getUserProfile44_invoker.call(UserProfileController_2.getUserProfile(userName))
      }
  
    // @LINE:84
    case controllers_UserProfileController_refreshUserprofile45_route(params) =>
      call(params.fromPath[String]("userName", None)) { (userName) =>
        controllers_UserProfileController_refreshUserprofile45_invoker.call(UserProfileController_2.refreshUserprofile(userName))
      }
  
    // @LINE:88
    case controllers_Popularity_getCommentSum46_route(params) =>
      call(params.fromPath[Integer]("rootid", None)) { (rootid) =>
        controllers_Popularity_getCommentSum46_invoker.call(Popularity_8.getCommentSum(rootid))
      }
  
    // @LINE:89
    case controllers_Popularity_getTagSum47_route(params) =>
      call(params.fromPath[Long]("pubid", None)) { (pubid) =>
        controllers_Popularity_getTagSum47_invoker.call(Popularity_8.getTagSum(pubid))
      }
  
    // @LINE:90
    case controllers_Popularity_getPopularityByYear48_route(params) =>
      call(params.fromPath[Integer]("year", None)) { (year) =>
        controllers_Popularity_getPopularityByYear48_invoker.call(Popularity_8.getPopularityByYear(year))
      }
  
    // @LINE:91
    case controllers_Popularity_getMostPopularity49_route(params) =>
      call { 
        controllers_Popularity_getMostPopularity49_invoker.call(Popularity_8.getMostPopularity())
      }
  
    // @LINE:92
    case controllers_Popularity_getAuthorPopularity50_route(params) =>
      call(params.fromPath[String]("author", None)) { (author) =>
        controllers_Popularity_getAuthorPopularity50_invoker.call(Popularity_8.getAuthorPopularity(author))
      }
  
    // @LINE:95
    case controllers_UserGroupController_getGroupList51_route(params) =>
      call(params.fromPath[String]("grouptype", None)) { (grouptype) =>
        controllers_UserGroupController_getGroupList51_invoker.call(UserGroupController_3.getGroupList(grouptype))
      }
  
    // @LINE:96
    case controllers_UserGroupController_getOwnGroup52_route(params) =>
      call(params.fromPath[String]("userid", None)) { (userid) =>
        controllers_UserGroupController_getOwnGroup52_invoker.call(UserGroupController_3.getOwnGroup(userid))
      }
  
    // @LINE:97
    case controllers_UserGroupController_saveGroup53_route(params) =>
      call { 
        controllers_UserGroupController_saveGroup53_invoker.call(UserGroupController_3.saveGroup())
      }
  
    // @LINE:98
    case controllers_UserGroupController_saveNotification54_route(params) =>
      call { 
        controllers_UserGroupController_saveNotification54_invoker.call(UserGroupController_3.saveNotification())
      }
  
    // @LINE:99
    case controllers_UserGroupController_getNotifcation55_route(params) =>
      call(params.fromPath[String]("userid", None)) { (userid) =>
        controllers_UserGroupController_getNotifcation55_invoker.call(UserGroupController_3.getNotifcation(userid))
      }
  
    // @LINE:100
    case controllers_UserGroupController_resNotification56_route(params) =>
      call { 
        controllers_UserGroupController_resNotification56_invoker.call(UserGroupController_3.resNotification())
      }
  
    // @LINE:101
    case controllers_UserGroupController_getGroupMessage57_route(params) =>
      call(params.fromPath[String]("groupname", None)) { (groupname) =>
        controllers_UserGroupController_getGroupMessage57_invoker.call(UserGroupController_3.getGroupMessage(groupname))
      }
  
    // @LINE:102
    case controllers_UserGroupController_saveMessage58_route(params) =>
      call { 
        controllers_UserGroupController_saveMessage58_invoker.call(UserGroupController_3.saveMessage())
      }
  }
}
