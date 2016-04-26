
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/Anna/Documents/graduate2/soc/SSNetwork/backend/conf/routes
// @DATE:Tue Apr 26 03:28:51 PDT 2016

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

  // @LINE:57
  class ReverseTagController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:65
    def deleteTagpost(postid:Long, tagpost:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "deletetagpost/" + implicitly[PathBindable[Long]].unbind("postid", postid) + "/" + implicitly[PathBindable[String]].unbind("tagpost", dynamicString(tagpost)))
    }
  
    // @LINE:59
    def getTagpubs(title:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "gettagpubs/" + implicitly[PathBindable[String]].unbind("title", dynamicString(title)))
    }
  
    // @LINE:66
    def getTagByPost_id(post_id:Long): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "getTagpost/" + implicitly[PathBindable[Long]].unbind("post_id", post_id))
    }
  
    // @LINE:60
    def getPublications(tagpub:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "getpublications/" + implicitly[PathBindable[String]].unbind("tagpub", dynamicString(tagpub)))
    }
  
    // @LINE:57
    def addTagpub(pubid:Long, tagpub:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "addtagpub/" + implicitly[PathBindable[Long]].unbind("pubid", pubid) + "/" + implicitly[PathBindable[String]].unbind("tagpub", dynamicString(tagpub)))
    }
  
    // @LINE:58
    def deleteTagpub(pubid:Long, tagpub:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "deletetagpub/" + implicitly[PathBindable[Long]].unbind("pubid", pubid) + "/" + implicitly[PathBindable[String]].unbind("tagpub", dynamicString(tagpub)))
    }
  
    // @LINE:61
    def getTagByPub_id(pub_id:Long): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "getTag/" + implicitly[PathBindable[Long]].unbind("pub_id", pub_id))
    }
  
    // @LINE:64
    def addTagpost(postid:Long, tagpost:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "addtagpost/" + implicitly[PathBindable[Long]].unbind("postid", postid) + "/" + implicitly[PathBindable[String]].unbind("tagpost", dynamicString(tagpost)))
    }
  
  }

  // @LINE:46
  class ReverseSubscriptionController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:47
    def loadSubscriptionListByCategory(category:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "subscribe/list/" + implicitly[PathBindable[String]].unbind("category", dynamicString(category)))
    }
  
    // @LINE:46
    def loadSubscriptionList(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "subscribe/list/all")
    }
  
    // @LINE:49
    def subscribe(followeeid:Long, category:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "subscribe/" + implicitly[PathBindable[Long]].unbind("followeeid", followeeid) + "/" + implicitly[PathBindable[String]].unbind("category", dynamicString(category)))
    }
  
    // @LINE:48
    def loadTimeline(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "subscribe/timeline")
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
    def deleteThumb(thumb_type:Integer, sender:Integer, receiver:Integer): Call = {
      import ReverseRouteContext.empty
      Call("DELETE", _prefix + { _defaultPrefix } + "deleteThumb/" + implicitly[PathBindable[Integer]].unbind("thumb_type", thumb_type) + "/" + implicitly[PathBindable[Integer]].unbind("sender", sender) + "/" + implicitly[PathBindable[Integer]].unbind("receiver", receiver))
    }
  
    // @LINE:31
    def addThumb(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "addThumb")
    }
  
  }

  // @LINE:76
  class ReverseUserProfileController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:77
    def getUserProfile(userName:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "userprofile/" + implicitly[PathBindable[String]].unbind("userName", dynamicString(userName)))
    }
  
    // @LINE:76
    def createuserProfileProfile(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "userprofile/create")
    }
  
    // @LINE:78
    def refreshUserprofile(userName:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "userprofile/refresh/" + implicitly[PathBindable[String]].unbind("userName", dynamicString(userName)))
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
  
    // @LINE:70
    def getPublicationWithAuthorsById(id:Integer): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "id/" + implicitly[PathBindable[Integer]].unbind("id", id))
    }
  
    // @LINE:69
    def getPublicationWithAuthorsByYear(year:Integer): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "year/" + implicitly[PathBindable[Integer]].unbind("year", year))
    }
  
    // @LINE:71
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
  
    // @LINE:52
    def search(keyword:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "post/search/" + implicitly[PathBindable[String]].unbind("keyword", dynamicString(keyword)))
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
  
    // @LINE:53
    def getPostByUserId(userId:Long): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "post/getPostByUserId/" + implicitly[PathBindable[Long]].unbind("userId", userId))
    }
  
  }

  // @LINE:24
  class ReverseForumController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:24
    def addComment(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "comment")
    }
  
    // @LINE:27
    def updateComment(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "updateComment")
    }
  
    // @LINE:28
    def uploadFile(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "upload")
    }
  
  }


}
