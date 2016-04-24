
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/yuanyuan/Documents/SSNetwork/backend/conf/routes
// @DATE:Sat Apr 23 21:41:34 PDT 2016

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:9
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def at(file:String): Call = {
      implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
    }
  
  }

  // @LINE:46
  class ReverseTagController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:48
    def getTagpubs(title:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "gettagpubs/" + implicitly[PathBindable[String]].unbind("title", dynamicString(title)))
    }
  
    // @LINE:49
    def getPublications(tagpub:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "getpublications/" + implicitly[PathBindable[String]].unbind("tagpub", dynamicString(tagpub)))
    }
  
    // @LINE:46
    def addTagpub(pubid:Long, tagpub:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "addtagpub/" + implicitly[PathBindable[Long]].unbind("pubid", pubid) + "/" + implicitly[PathBindable[String]].unbind("tagpub", dynamicString(tagpub)))
    }
  
    // @LINE:47
    def deleteTagpub(pubid:Long, tagpub:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "deletetagpub/" + implicitly[PathBindable[Long]].unbind("pubid", pubid) + "/" + implicitly[PathBindable[String]].unbind("tagpub", dynamicString(tagpub)))
    }
  
    // @LINE:50
    def getTagByPub_id(pub_id:Long): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "getTag/" + implicitly[PathBindable[Long]].unbind("pub_id", pub_id))
    }
  
  }

  // @LINE:51
  class ReversePublicationController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:51
    def updatePublication(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "updatepub")
    }
  
  }

  // @LINE:31
  class ReverseThumbController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:33
    def getThumbSum(user:String, _pf_escape_type:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "getThumbSum/" + implicitly[PathBindable[String]].unbind("user", dynamicString(user)) + "/" + implicitly[PathBindable[String]].unbind("type", dynamicString(_pf_escape_type)))
    }
  
    // @LINE:32
    def deleteThumb(id:Long): Call = {
      import ReverseRouteContext.empty
      Call("DELETE", _prefix + { _defaultPrefix } + "deleteThumb/" + implicitly[PathBindable[Long]].unbind("id", id))
    }
  
    // @LINE:31
    def addThumb(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "addThumb")
    }
  
  }

  // @LINE:6
  class ReverseApplication(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def upload(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "person/uploadPic")
    }
  
    // @LINE:55
    def getPublicationWithAuthorsById(id:Integer): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "id/" + implicitly[PathBindable[Integer]].unbind("id", id))
    }
  
    // @LINE:54
    def getPublicationWithAuthorsByYear(year:Integer): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "year/" + implicitly[PathBindable[Integer]].unbind("year", year))
    }
  
    // @LINE:56
    def getPublicationWithAuthorsByTitle(title:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "title/" + implicitly[PathBindable[String]].unbind("title", dynamicString(title)))
    }
  
    // @LINE:6
    def index(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix)
    }
  
  }

  // @LINE:37
  class ReversePostController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:38
    def getPostById(postId:Long): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "post/getPostById/" + implicitly[PathBindable[Long]].unbind("postId", postId))
    }
  
    // @LINE:42
    def setAnswer(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "post/setAnswer")
    }
  
    // @LINE:37
    def addPost(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "post/addPost")
    }
  
    // @LINE:39
    def getAllPosts(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "post/getAllPosts")
    }
  
    // @LINE:40
    def addComment(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "post/addComment")
    }
  
    // @LINE:41
    def setAsQuestion(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "post/setAsQuestion")
    }
  
  }

  // @LINE:24
  class ReverseForumController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:28
    def uploadFile(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "upload")
    }
  
    // @LINE:24
    def addComment(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "comment")
    }
  
    // @LINE:27
    def deleteComment(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "deleteComment")
    }
  
    // @LINE:26
    def updateComment(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "updateComment")
    }
  
    // @LINE:25
    def getComments(rootid:Integer, categoryid:Integer): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "comment" + queryString(List(Some(implicitly[QueryStringBindable[Integer]].unbind("rootid", rootid)), Some(implicitly[QueryStringBindable[Integer]].unbind("categoryid", categoryid)))))
    }
  
  }


}
