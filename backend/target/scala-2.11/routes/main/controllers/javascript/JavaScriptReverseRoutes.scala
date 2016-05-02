
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/Anna/Documents/graduate2/soc/SSNetwork/backend/conf/routes
// @DATE:Mon May 02 03:38:14 PDT 2016

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:9
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:63
  class ReverseTagController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:72
    def deleteTagpost: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TagController.deleteTagpost",
      """
        function(postid0,tagpost1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deletetagpost/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("postid", postid0) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("tagpost", encodeURIComponent(tagpost1))})
        }
      """
    )
  
    // @LINE:65
    def getTagpubs: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TagController.getTagpubs",
      """
        function(title0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "gettagpubs/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("title", encodeURIComponent(title0))})
        }
      """
    )
  
    // @LINE:73
    def getTagByPost_id: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TagController.getTagByPost_id",
      """
        function(post_id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getTagpost/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("post_id", post_id0)})
        }
      """
    )
  
    // @LINE:66
    def getPublications: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TagController.getPublications",
      """
        function(tagpub0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getpublications/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("tagpub", encodeURIComponent(tagpub0))})
        }
      """
    )
  
    // @LINE:63
    def addTagpub: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TagController.addTagpub",
      """
        function(pubid0,tagpub1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "addtagpub/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("pubid", pubid0) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("tagpub", encodeURIComponent(tagpub1))})
        }
      """
    )
  
    // @LINE:64
    def deleteTagpub: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TagController.deleteTagpub",
      """
        function(pubid0,tagpub1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deletetagpub/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("pubid", pubid0) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("tagpub", encodeURIComponent(tagpub1))})
        }
      """
    )
  
    // @LINE:68
    def updateTagPub: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TagController.updateTagPub",
      """
        function(pubid0,tagpub1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "updateTag/" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("pubid", pubid0), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("tagpub", tagpub1)])})
        }
      """
    )
  
    // @LINE:67
    def getTagByPub_id: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TagController.getTagByPub_id",
      """
        function(pub_id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getTag/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("pub_id", pub_id0)})
        }
      """
    )
  
    // @LINE:71
    def addTagpost: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TagController.addTagpost",
      """
        function(postid0,tagpost1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "addtagpost/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("postid", postid0) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("tagpost", encodeURIComponent(tagpost1))})
        }
      """
    )
  
  }

  // @LINE:18
  class ReversePublicationController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def UpdatePublication: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PublicationController.UpdatePublication",
      """
        function(pub_id0,title1,editor2,year3,isbn4,volume5,pages6,mdate7,series8,publisher9,booktitle10,crossref11,ee12,author13) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "updatepub/" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("pub_id", pub_id0), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("title", title1), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("editor", editor2), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("year", year3), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("isbn", isbn4), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("volume", volume5), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("pages", pages6), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("mdate", mdate7), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("series", series8), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("publisher", publisher9), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("booktitle", booktitle10), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("crossref", crossref11), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("ee", ee12), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("author", author13)])})
        }
      """
    )
  
  }

  // @LINE:88
  class ReversePopularity(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:90
    def getPopularityByYear: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Popularity.getPopularityByYear",
      """
        function(year0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getPopularityByYear/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("year", year0)})
        }
      """
    )
  
    // @LINE:92
    def getAuthorPopularity: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Popularity.getAuthorPopularity",
      """
        function(author0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getAuthorPopularity/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("author", encodeURIComponent(author0))})
        }
      """
    )
  
    // @LINE:88
    def getCommentSum: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Popularity.getCommentSum",
      """
        function(rootid0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getCommentSum/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("rootid", rootid0)})
        }
      """
    )
  
    // @LINE:91
    def getMostPopularity: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Popularity.getMostPopularity",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getMostPopularity"})
        }
      """
    )
  
    // @LINE:89
    def getTagSum: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Popularity.getTagSum",
      """
        function(pubid0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getTagSum/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("pubid", pubid0)})
        }
      """
    )
  
  }

  // @LINE:52
  class ReverseSubscriptionController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:53
    def loadSubscriptionListByCategory: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SubscriptionController.loadSubscriptionListByCategory",
      """
        function(category0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "subscribe/list/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("category", encodeURIComponent(category0))})
        }
      """
    )
  
    // @LINE:52
    def loadSubscriptionList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SubscriptionController.loadSubscriptionList",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "subscribe/list/all"})
        }
      """
    )
  
    // @LINE:55
    def subscribe: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SubscriptionController.subscribe",
      """
        function(followeeid0,category1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "subscribe/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("followeeid", followeeid0) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("category", encodeURIComponent(category1))})
        }
      """
    )
  
    // @LINE:54
    def loadTimeline: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SubscriptionController.loadTimeline",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "subscribe/timeline"})
        }
      """
    )
  
  }

  // @LINE:37
  class ReverseThumbController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:39
    def getThumbSum: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ThumbController.getThumbSum",
      """
        function(user0,type1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getThumbSum/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("user", encodeURIComponent(user0)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("type", encodeURIComponent(type1))})
        }
      """
    )
  
    // @LINE:38
    def deleteThumb: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ThumbController.deleteThumb",
      """
        function(thumb_type0,sender1,receiver2) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteThumb/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("thumb_type", thumb_type0) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("sender", encodeURIComponent(sender1)) + "/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("receiver", receiver2)})
        }
      """
    )
  
    // @LINE:37
    def addThumb: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ThumbController.addThumb",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addThumb"})
        }
      """
    )
  
  }

  // @LINE:95
  class ReverseUserGroupController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:97
    def saveGroup: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserGroupController.saveGroup",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "groups"})
        }
      """
    )
  
    // @LINE:100
    def resNotification: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserGroupController.resNotification",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "group/resnotification"})
        }
      """
    )
  
    // @LINE:96
    def getOwnGroup: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserGroupController.getOwnGroup",
      """
        function(userid0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "group/own/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("userid", encodeURIComponent(userid0))})
        }
      """
    )
  
    // @LINE:95
    def getGroupList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserGroupController.getGroupList",
      """
        function(grouptype0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "groups/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("grouptype", encodeURIComponent(grouptype0))})
        }
      """
    )
  
    // @LINE:101
    def getGroupMessage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserGroupController.getGroupMessage",
      """
        function(groupname0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "group/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("groupname", encodeURIComponent(groupname0)) + "/message"})
        }
      """
    )
  
    // @LINE:98
    def saveNotification: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserGroupController.saveNotification",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "group/notification"})
        }
      """
    )
  
    // @LINE:99
    def getNotifcation: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserGroupController.getNotifcation",
      """
        function(userid0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "group/notification/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("userid", encodeURIComponent(userid0))})
        }
      """
    )
  
    // @LINE:102
    def saveMessage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserGroupController.saveMessage",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "group/message"})
        }
      """
    )
  
  }

  // @LINE:82
  class ReverseUserProfileController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:83
    def getUserProfile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserProfileController.getUserProfile",
      """
        function(userName0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "userprofile/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("userName", encodeURIComponent(userName0))})
        }
      """
    )
  
    // @LINE:82
    def createuserProfileProfile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserProfileController.createuserProfileProfile",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "userprofile/create"})
        }
      """
    )
  
    // @LINE:84
    def refreshUserprofile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserProfileController.refreshUserprofile",
      """
        function(userName0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "userprofile/refresh/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("userName", encodeURIComponent(userName0))})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseApplication(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def upload: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.upload",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "person/uploadPic"})
        }
      """
    )
  
    // @LINE:77
    def getPublicationWithAuthorsById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getPublicationWithAuthorsById",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "paper/id/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("id", id0)})
        }
      """
    )
  
    // @LINE:76
    def getPublicationWithAuthorsByYear: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getPublicationWithAuthorsByYear",
      """
        function(year0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "paper/year/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("year", year0)})
        }
      """
    )
  
    // @LINE:25
    def getAllPublications: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getAllPublications",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "all"})
        }
      """
    )
  
    // @LINE:28
    def getCoAuthors: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getCoAuthors",
      """
        function(author0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "coauthor/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("author", encodeURIComponent(author0))})
        }
      """
    )
  
    // @LINE:78
    def getPublicationWithAuthorsByTitle: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getPublicationWithAuthorsByTitle",
      """
        function(title0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "paper/title/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("title", encodeURIComponent(title0))})
        }
      """
    )
  
    // @LINE:26
    def getPaperBykeyWord: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getPaperBykeyWord",
      """
        function(keyWord0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "keyword/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("keyWord", encodeURIComponent(keyWord0))})
        }
      """
    )
  
    // @LINE:24
    def getPaperByTitle: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getPaperByTitle",
      """
        function(title0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "title/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("title", encodeURIComponent(title0))})
        }
      """
    )
  
    // @LINE:27
    def getAuthors: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getAuthors",
      """
        function(author0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "author/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("author", encodeURIComponent(author0))})
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:23
    def getPaperByYear: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getPaperByYear",
      """
        function(year0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "year/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("year", year0)})
        }
      """
    )
  
  }

  // @LINE:43
  class ReversePostController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:44
    def getPostById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PostController.getPostById",
      """
        function(postId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "post/getPostById/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("postId", postId0)})
        }
      """
    )
  
    // @LINE:48
    def setAnswer: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PostController.setAnswer",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "post/setAnswer"})
        }
      """
    )
  
    // @LINE:43
    def addPost: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PostController.addPost",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "post/addPost"})
        }
      """
    )
  
    // @LINE:58
    def search: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PostController.search",
      """
        function(keyword0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "post/search/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("keyword", encodeURIComponent(keyword0))})
        }
      """
    )
  
    // @LINE:45
    def getAllPosts: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PostController.getAllPosts",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "post/getAllPosts"})
        }
      """
    )
  
    // @LINE:46
    def addComment: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PostController.addComment",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "post/addComment"})
        }
      """
    )
  
    // @LINE:47
    def setAsQuestion: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PostController.setAsQuestion",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "post/setAsQuestion"})
        }
      """
    )
  
    // @LINE:59
    def getPostByUserId: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PostController.getPostByUserId",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "post/getPostByUserId/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("userId", userId0)})
        }
      """
    )
  
  }

  // @LINE:19
  class ReverseForumController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def getCommentStatusByID: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ForumController.getCommentStatusByID",
      """
        function(pub_id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "commentatus/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("pub_id", pub_id0)})
        }
      """
    )
  
    // @LINE:34
    def uploadFile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ForumController.uploadFile",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "upload"})
        }
      """
    )
  
    // @LINE:19
    def updateCommentStatus: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ForumController.updateCommentStatus",
      """
        function(pub_id0,status1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "upcommentstatus/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("pub_id", pub_id0) + "/" + (""" + implicitly[PathBindable[Boolean]].javascriptUnbind + """)("status", status1)})
        }
      """
    )
  
    // @LINE:31
    def addComment: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ForumController.addComment",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "comment"})
        }
      """
    )
  
    // @LINE:32
    def getComments: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ForumController.getComments",
      """
        function(rootid0,categoryid1,userid2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "comment" + _qS([(""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("rootid", rootid0), (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("categoryid", categoryid1), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("userid", userid2)])})
        }
      """
    )
  
    // @LINE:33
    def updateComment: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ForumController.updateComment",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateComment"})
        }
      """
    )
  
  }


}
