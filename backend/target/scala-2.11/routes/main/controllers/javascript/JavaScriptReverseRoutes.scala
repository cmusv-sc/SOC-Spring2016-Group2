
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/caoyi/Desktop/SSNetwork/backend/conf/routes
// @DATE:Tue Apr 26 17:06:13 PDT 2016

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

  // @LINE:52
  class ReverseTagController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:60
    def deleteTagpost: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TagController.deleteTagpost",
      """
        function(postid0,tagpost1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deletetagpost/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("postid", postid0) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("tagpost", encodeURIComponent(tagpost1))})
        }
      """
    )
  
    // @LINE:54
    def getTagpubs: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TagController.getTagpubs",
      """
        function(title0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "gettagpubs/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("title", encodeURIComponent(title0))})
        }
      """
    )
  
    // @LINE:61
    def getTagByPost_id: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TagController.getTagByPost_id",
      """
        function(post_id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getTagpost/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("post_id", post_id0)})
        }
      """
    )
  
    // @LINE:55
    def getPublications: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TagController.getPublications",
      """
        function(tagpub0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getpublications/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("tagpub", encodeURIComponent(tagpub0))})
        }
      """
    )
  
    // @LINE:52
    def addTagpub: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TagController.addTagpub",
      """
        function(pubid0,tagpub1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "addtagpub/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("pubid", pubid0) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("tagpub", encodeURIComponent(tagpub1))})
        }
      """
    )
  
    // @LINE:53
    def deleteTagpub: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TagController.deleteTagpub",
      """
        function(pubid0,tagpub1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deletetagpub/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("pubid", pubid0) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("tagpub", encodeURIComponent(tagpub1))})
        }
      """
    )
  
    // @LINE:56
    def getTagByPub_id: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TagController.getTagByPub_id",
      """
        function(pub_id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getTag/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("pub_id", pub_id0)})
        }
      """
    )
  
    // @LINE:59
    def addTagpost: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TagController.addTagpost",
      """
        function(postid0,tagpost1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "addtagpost/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("postid", postid0) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("tagpost", encodeURIComponent(tagpost1))})
        }
      """
    )
  
  }

  // @LINE:76
  class ReversePopularity(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:76
    def getCommentSum: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Popularity.getCommentSum",
      """
        function(rootid0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getCommentSum/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("rootid", rootid0)})
        }
      """
    )
  
    // @LINE:77
    def getTagSum: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Popularity.getTagSum",
      """
        function(pubid0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getTagSum/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("pubid", pubid0)})
        }
      """
    )
  
  }

  // @LINE:35
  class ReverseThumbController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:37
    def getThumbSum: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ThumbController.getThumbSum",
      """
        function(user0,type1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getThumbSum/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("user", encodeURIComponent(user0)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("type", encodeURIComponent(type1))})
        }
      """
    )
  
    // @LINE:36
    def deleteThumb: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ThumbController.deleteThumb",
      """
        function(thumb_type0,sender1,receiver2) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteThumb/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("thumb_type", thumb_type0) + "/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("sender", sender1) + "/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("receiver", receiver2)})
        }
      """
    )
  
    // @LINE:35
    def addThumb: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ThumbController.addThumb",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addThumb"})
        }
      """
    )
  
  }

  // @LINE:71
  class ReverseUserProfileController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:72
    def getUserProfile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserProfileController.getUserProfile",
      """
        function(userName0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "userprofile/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("userName", encodeURIComponent(userName0))})
        }
      """
    )
  
    // @LINE:71
    def createuserProfileProfile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserProfileController.createuserProfileProfile",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "userprofile/create"})
        }
      """
    )
  
    // @LINE:73
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
  
    // @LINE:65
    def getPublicationWithAuthorsById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getPublicationWithAuthorsById",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "id/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("id", id0)})
        }
      """
    )
  
    // @LINE:64
    def getPublicationWithAuthorsByYear: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getPublicationWithAuthorsByYear",
      """
        function(year0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "year/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("year", year0)})
        }
      """
    )
  
    // @LINE:23
    def getAllPublications: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getAllPublications",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "all"})
        }
      """
    )
  
    // @LINE:26
    def getCoAuthors: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getCoAuthors",
      """
        function(author0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "coauthor/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("author", encodeURIComponent(author0))})
        }
      """
    )
  
    // @LINE:66
    def getPublicationWithAuthorsByTitle: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getPublicationWithAuthorsByTitle",
      """
        function(title0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "title/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("title", encodeURIComponent(title0))})
        }
      """
    )
  
    // @LINE:24
    def getPaperBykeyWord: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getPaperBykeyWord",
      """
        function(keyWord0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "keyword/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("keyWord", encodeURIComponent(keyWord0))})
        }
      """
    )
  
    // @LINE:22
    def getPaperByTitle: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getPaperByTitle",
      """
        function(title0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "title/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("title", encodeURIComponent(title0))})
        }
      """
    )
  
    // @LINE:25
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
  
    // @LINE:21
    def getPaperByYear: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getPaperByYear",
      """
        function(year0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "year/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("year", year0)})
        }
      """
    )
  
  }

  // @LINE:41
  class ReversePostController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:42
    def getPostById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PostController.getPostById",
      """
        function(postId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "post/getPostById/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("postId", postId0)})
        }
      """
    )
  
    // @LINE:46
    def setAnswer: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PostController.setAnswer",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "post/setAnswer"})
        }
      """
    )
  
    // @LINE:41
    def addPost: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PostController.addPost",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "post/addPost"})
        }
      """
    )
  
    // @LINE:47
    def search: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PostController.search",
      """
        function(keyword0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "post/search/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("keyword", encodeURIComponent(keyword0))})
        }
      """
    )
  
    // @LINE:43
    def getAllPosts: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PostController.getAllPosts",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "post/getAllPosts"})
        }
      """
    )
  
    // @LINE:44
    def addComment: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PostController.addComment",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "post/addComment"})
        }
      """
    )
  
    // @LINE:45
    def setAsQuestion: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PostController.setAsQuestion",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "post/setAsQuestion"})
        }
      """
    )
  
    // @LINE:48
    def getPostByUserId: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PostController.getPostByUserId",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "post/getPostByUserId/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("userId", userId0)})
        }
      """
    )
  
  }

  // @LINE:29
  class ReverseForumController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:30
    def getComments: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ForumController.getComments",
      """
        function(rootid0,categoryid1,userid2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "comment" + _qS([(""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("rootid", rootid0), (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("categoryid", categoryid1), (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("userid", userid2)])})
        }
      """
    )
  
    // @LINE:29
    def addComment: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ForumController.addComment",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "comment"})
        }
      """
    )
  
    // @LINE:31
    def updateComment: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ForumController.updateComment",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateComment"})
        }
      """
    )
  
    // @LINE:32
    def uploadFile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ForumController.uploadFile",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "upload"})
        }
      """
    )
  
  }


}
