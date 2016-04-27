
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/caoyi/Desktop/SSNetwork/backend/conf/routes
// @DATE:Tue Apr 26 17:06:13 PDT 2016

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

  // @LINE:52
  class ReverseTagController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:60
    def deleteTagpost(postid:Long, tagpost:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "deletetagpost/" + implicitly[PathBindable[Long]].unbind("postid", postid) + "/" + implicitly[PathBindable[String]].unbind("tagpost", dynamicString(tagpost)))
    }
  
    // @LINE:54
    def getTagpubs(title:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "gettagpubs/" + implicitly[PathBindable[String]].unbind("title", dynamicString(title)))
    }
  
    // @LINE:61
    def getTagByPost_id(post_id:Long): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "getTagpost/" + implicitly[PathBindable[Long]].unbind("post_id", post_id))
    }
  
    // @LINE:55
    def getPublications(tagpub:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "getpublications/" + implicitly[PathBindable[String]].unbind("tagpub", dynamicString(tagpub)))
    }
  
    // @LINE:52
    def addTagpub(pubid:Long, tagpub:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "addtagpub/" + implicitly[PathBindable[Long]].unbind("pubid", pubid) + "/" + implicitly[PathBindable[String]].unbind("tagpub", dynamicString(tagpub)))
    }
  
    // @LINE:53
    def deleteTagpub(pubid:Long, tagpub:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "deletetagpub/" + implicitly[PathBindable[Long]].unbind("pubid", pubid) + "/" + implicitly[PathBindable[String]].unbind("tagpub", dynamicString(tagpub)))
    }
  
    // @LINE:56
    def getTagByPub_id(pub_id:Long): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "getTag/" + implicitly[PathBindable[Long]].unbind("pub_id", pub_id))
    }
  
    // @LINE:59
    def addTagpost(postid:Long, tagpost:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "addtagpost/" + implicitly[PathBindable[Long]].unbind("postid", postid) + "/" + implicitly[PathBindable[String]].unbind("tagpost", dynamicString(tagpost)))
    }
  
  }

  // @LINE:76
  class ReversePopularity(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:76
    def getCommentSum(rootid:Integer): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "getCommentSum/" + implicitly[PathBindable[Integer]].unbind("rootid", rootid))
    }
  
    // @LINE:77
    def getTagSum(pubid:Long): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "getTagSum/" + implicitly[PathBindable[Long]].unbind("pubid", pubid))
    }
  
  }

  // @LINE:35
  class ReverseThumbController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:37
    def getThumbSum(user:String, _pf_escape_type:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "getThumbSum/" + implicitly[PathBindable[String]].unbind("user", dynamicString(user)) + "/" + implicitly[PathBindable[String]].unbind("type", dynamicString(_pf_escape_type)))
    }
  
    // @LINE:36
    def deleteThumb(thumb_type:Integer, sender:Integer, receiver:Integer): Call = {
      import ReverseRouteContext.empty
      Call("DELETE", _prefix + { _defaultPrefix } + "deleteThumb/" + implicitly[PathBindable[Integer]].unbind("thumb_type", thumb_type) + "/" + implicitly[PathBindable[Integer]].unbind("sender", sender) + "/" + implicitly[PathBindable[Integer]].unbind("receiver", receiver))
    }
  
    // @LINE:35
    def addThumb(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "addThumb")
    }
  
  }

  // @LINE:71
  class ReverseUserProfileController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:72
    def getUserProfile(userName:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "userprofile/" + implicitly[PathBindable[String]].unbind("userName", dynamicString(userName)))
    }
  
    // @LINE:71
    def createuserProfileProfile(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "userprofile/create")
    }
  
    // @LINE:73
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
  
    // @LINE:65
    def getPublicationWithAuthorsById(id:Integer): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "id/" + implicitly[PathBindable[Integer]].unbind("id", id))
    }
  
    // @LINE:64
    def getPublicationWithAuthorsByYear(year:Integer): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "year/" + implicitly[PathBindable[Integer]].unbind("year", year))
    }
  
    // @LINE:23
    def getAllPublications(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "all")
    }
  
    // @LINE:26
    def getCoAuthors(author:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "coauthor/" + implicitly[PathBindable[String]].unbind("author", dynamicString(author)))
    }
  
    // @LINE:66
    def getPublicationWithAuthorsByTitle(title:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "title/" + implicitly[PathBindable[String]].unbind("title", dynamicString(title)))
    }
  
    // @LINE:24
    def getPaperBykeyWord(keyWord:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "keyword/" + implicitly[PathBindable[String]].unbind("keyWord", dynamicString(keyWord)))
    }
  
    // @LINE:22
    def getPaperByTitle(title:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "title/" + implicitly[PathBindable[String]].unbind("title", dynamicString(title)))
    }
  
    // @LINE:25
    def getAuthors(author:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "author/" + implicitly[PathBindable[String]].unbind("author", dynamicString(author)))
    }
  
    // @LINE:6
    def index(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix)
    }
  
    // @LINE:21
    def getPaperByYear(year:Integer): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "year/" + implicitly[PathBindable[Integer]].unbind("year", year))
    }
  
  }

  // @LINE:41
  class ReversePostController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:42
    def getPostById(postId:Long): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "post/getPostById/" + implicitly[PathBindable[Long]].unbind("postId", postId))
    }
  
    // @LINE:46
    def setAnswer(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "post/setAnswer")
    }
  
    // @LINE:41
    def addPost(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "post/addPost")
    }
  
    // @LINE:47
    def search(keyword:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "post/search/" + implicitly[PathBindable[String]].unbind("keyword", dynamicString(keyword)))
    }
  
    // @LINE:43
    def getAllPosts(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "post/getAllPosts")
    }
  
    // @LINE:44
    def addComment(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "post/addComment")
    }
  
    // @LINE:45
    def setAsQuestion(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "post/setAsQuestion")
    }
  
    // @LINE:48
    def getPostByUserId(userId:Long): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "post/getPostByUserId/" + implicitly[PathBindable[Long]].unbind("userId", userId))
    }
  
  }

  // @LINE:29
  class ReverseForumController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:30
    def getComments(rootid:Integer, categoryid:Integer, userid:Integer): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "comment" + queryString(List(Some(implicitly[QueryStringBindable[Integer]].unbind("rootid", rootid)), Some(implicitly[QueryStringBindable[Integer]].unbind("categoryid", categoryid)), Some(implicitly[QueryStringBindable[Integer]].unbind("userid", userid)))))
    }
  
    // @LINE:29
    def addComment(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "comment")
    }
  
    // @LINE:31
    def updateComment(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "updateComment")
    }
  
    // @LINE:32
    def uploadFile(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "upload")
    }
  
  }


}
