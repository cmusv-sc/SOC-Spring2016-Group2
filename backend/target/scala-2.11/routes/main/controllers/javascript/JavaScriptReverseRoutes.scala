
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/ThomasHsu/Desktop/SSNetwork/backend/conf/routes
// @DATE:Sat Apr 23 13:33:00 PDT 2016

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

  // @LINE:45
  class ReverseTagController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:47
    def getTagpubs: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TagController.getTagpubs",
      """
        function(title0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "gettagpubs/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("title", encodeURIComponent(title0))})
        }
      """
    )
  
    // @LINE:48
    def getPublications: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TagController.getPublications",
      """
        function(tagpub0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getpublications/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("tagpub", encodeURIComponent(tagpub0))})
        }
      """
    )
  
    // @LINE:46
    def deleteTagpub: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TagController.deleteTagpub",
      """
        function(pubid0,tagpub1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deletetagpub/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("pubid", pubid0) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("tagpub", encodeURIComponent(tagpub1))})
        }
      """
    )
  
    // @LINE:45
    def addTagpub: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TagController.addTagpub",
      """
        function(pubid0,tagpub1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "addtagpub/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("pubid", pubid0) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("tagpub", encodeURIComponent(tagpub1))})
        }
      """
    )
  
  }

  // @LINE:30
  class ReverseThumbController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:32
    def getThumbSum: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ThumbController.getThumbSum",
      """
        function(user0,type1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getThumbSum/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("user", encodeURIComponent(user0)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("type", encodeURIComponent(type1))})
        }
      """
    )
  
    // @LINE:31
    def deleteThumb: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ThumbController.deleteThumb",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteThumb/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id0)})
        }
      """
    )
  
    // @LINE:30
    def addThumb: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ThumbController.addThumb",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addThumb"})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseApplication(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:20
    def getPaperByTitle: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getPaperByTitle",
      """
        function(title0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "title/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("title", encodeURIComponent(title0))})
        }
      """
    )
  
    // @LINE:19
    def getPaperByYear: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getPaperByYear",
      """
        function(year0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "year/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("year", year0)})
        }
      """
    )
  
    // @LINE:11
    def upload: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.upload",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "person/uploadPic"})
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
  
  }

  // @LINE:36
  class ReversePostController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:37
    def getPostById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PostController.getPostById",
      """
        function(postId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "post/getPostById/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("postId", postId0)})
        }
      """
    )
  
    // @LINE:41
    def setAnswer: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PostController.setAnswer",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "post/setAnswer"})
        }
      """
    )
  
    // @LINE:36
    def addPost: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PostController.addPost",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "post/addPost"})
        }
      """
    )
  
    // @LINE:38
    def getAllPosts: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PostController.getAllPosts",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "post/getAllPosts"})
        }
      """
    )
  
    // @LINE:39
    def addComment: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PostController.addComment",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "post/addComment"})
        }
      """
    )
  
    // @LINE:40
    def setAsQuestion: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PostController.setAsQuestion",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "post/setAsQuestion"})
        }
      """
    )
  
  }

  // @LINE:24
  class ReverseForumController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:24
    def addComment: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ForumController.addComment",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "comment"})
        }
      """
    )
  
    // @LINE:26
    def updateComment: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ForumController.updateComment",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateComment"})
        }
      """
    )
  
    // @LINE:25
    def getComments: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ForumController.getComments",
      """
        function(rootid0,categoryid1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "comment" + _qS([(""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("rootid", rootid0), (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("categoryid", categoryid1)])})
        }
      """
    )
  
    // @LINE:27
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
