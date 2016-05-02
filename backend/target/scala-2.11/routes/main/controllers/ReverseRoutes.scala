
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/Anna/Documents/graduate2/soc/SSNetwork/backend/conf/routes
// @DATE:Wed Apr 27 23:52:55 PDT 2016

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

  // @LINE:62
  class ReverseTagController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:71
    def deleteTagpost(postid:Long, tagpost:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "deletetagpost/" + implicitly[PathBindable[Long]].unbind("postid", postid) + "/" + implicitly[PathBindable[String]].unbind("tagpost", dynamicString(tagpost)))
    }
  
    // @LINE:64
    def getTagpubs(title:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "gettagpubs/" + implicitly[PathBindable[String]].unbind("title", dynamicString(title)))
    }
  
    // @LINE:72
    def getTagByPost_id(post_id:Long): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "getTagpost/" + implicitly[PathBindable[Long]].unbind("post_id", post_id))
    }
  
    // @LINE:65
    def getPublications(tagpub:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "getpublications/" + implicitly[PathBindable[String]].unbind("tagpub", dynamicString(tagpub)))
    }
  
    // @LINE:62
    def addTagpub(pubid:Long, tagpub:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "addtagpub/" + implicitly[PathBindable[Long]].unbind("pubid", pubid) + "/" + implicitly[PathBindable[String]].unbind("tagpub", dynamicString(tagpub)))
    }
  
    // @LINE:63
    def deleteTagpub(pubid:Long, tagpub:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "deletetagpub/" + implicitly[PathBindable[Long]].unbind("pubid", pubid) + "/" + implicitly[PathBindable[String]].unbind("tagpub", dynamicString(tagpub)))
    }
  
    // @LINE:67
    def updateTagPub(pubid:Long, tagpub:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "updateTag/" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("pubid", pubid)), Some(implicitly[QueryStringBindable[String]].unbind("tagpub", tagpub)))))
    }
  
    // @LINE:66
    def getTagByPub_id(pub_id:Long): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "getTag/" + implicitly[PathBindable[Long]].unbind("pub_id", pub_id))
    }
  
    // @LINE:70
    def addTagpost(postid:Long, tagpost:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "addtagpost/" + implicitly[PathBindable[Long]].unbind("postid", postid) + "/" + implicitly[PathBindable[String]].unbind("tagpost", dynamicString(tagpost)))
    }
  
  }

  // @LINE:18
  class ReversePublicationController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def UpdatePublication(pub_id:Long, title:String, editor:String, year:String, isbn:String, volume:String, pages:String, mdate:String, series:String, publisher:String, booktitle:String, crossref:String, ee:String, author:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "updatepub/" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("pub_id", pub_id)), Some(implicitly[QueryStringBindable[String]].unbind("title", title)), Some(implicitly[QueryStringBindable[String]].unbind("editor", editor)), Some(implicitly[QueryStringBindable[String]].unbind("year", year)), Some(implicitly[QueryStringBindable[String]].unbind("isbn", isbn)), Some(implicitly[QueryStringBindable[String]].unbind("volume", volume)), Some(implicitly[QueryStringBindable[String]].unbind("pages", pages)), Some(implicitly[QueryStringBindable[String]].unbind("mdate", mdate)), Some(implicitly[QueryStringBindable[String]].unbind("series", series)), Some(implicitly[QueryStringBindable[String]].unbind("publisher", publisher)), Some(implicitly[QueryStringBindable[String]].unbind("booktitle", booktitle)), Some(implicitly[QueryStringBindable[String]].unbind("crossref", crossref)), Some(implicitly[QueryStringBindable[String]].unbind("ee", ee)), Some(implicitly[QueryStringBindable[String]].unbind("author", author)))))
    }
  
  }

  // @LINE:87
  class ReversePopularity(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:87
    def getCommentSum(rootid:Integer): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "getCommentSum/" + implicitly[PathBindable[Integer]].unbind("rootid", rootid))
    }
  
    // @LINE:88
    def getTagSum(pubid:Long): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "getTagSum/" + implicitly[PathBindable[Long]].unbind("pubid", pubid))
    }
  
  }

  // @LINE:51
  class ReverseSubscriptionController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:52
    def loadSubscriptionListByCategory(category:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "subscribe/list/" + implicitly[PathBindable[String]].unbind("category", dynamicString(category)))
    }
  
    // @LINE:51
    def loadSubscriptionList(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "subscribe/list/all")
    }
  
    // @LINE:54
    def subscribe(followeeid:Long, category:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "subscribe/" + implicitly[PathBindable[Long]].unbind("followeeid", followeeid) + "/" + implicitly[PathBindable[String]].unbind("category", dynamicString(category)))
    }
  
    // @LINE:53
    def loadTimeline(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "subscribe/timeline")
    }
  
  }

  // @LINE:36
  class ReverseThumbController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:38
    def getThumbSum(user:String, _pf_escape_type:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "getThumbSum/" + implicitly[PathBindable[String]].unbind("user", dynamicString(user)) + "/" + implicitly[PathBindable[String]].unbind("type", dynamicString(_pf_escape_type)))
    }
  
    // @LINE:37
    def deleteThumb(thumb_type:Integer, sender:Integer, receiver:Integer): Call = {
      import ReverseRouteContext.empty
      Call("DELETE", _prefix + { _defaultPrefix } + "deleteThumb/" + implicitly[PathBindable[Integer]].unbind("thumb_type", thumb_type) + "/" + implicitly[PathBindable[Integer]].unbind("sender", sender) + "/" + implicitly[PathBindable[Integer]].unbind("receiver", receiver))
    }
  
    // @LINE:36
    def addThumb(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "addThumb")
    }
  
  }

  // @LINE:91
  class ReverseUserGroupController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:95
    def getNotifcation(userid:Long): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "group/notification/" + implicitly[PathBindable[Long]].unbind("userid", userid))
    }
  
    // @LINE:93
    def saveGroup(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "groups")
    }
  
    // @LINE:96
    def resNotification(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "group/resnotification")
    }
  
    // @LINE:91
    def getGroupList(grouptype:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "groups/" + implicitly[PathBindable[String]].unbind("grouptype", dynamicString(grouptype)))
    }
  
    // @LINE:92
    def getOwnGroup(userid:Long): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "group/own/" + implicitly[PathBindable[Long]].unbind("userid", userid))
    }
  
    // @LINE:97
    def getGroupMessage(groupname:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "group/" + implicitly[PathBindable[String]].unbind("groupname", dynamicString(groupname)) + "/message")
    }
  
    // @LINE:94
    def saveNotification(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "group/notification")
    }
  
    // @LINE:98
    def saveMessage(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "group/message")
    }
  
  }

  // @LINE:82
  class ReverseUserProfileController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:83
    def getUserProfile(userName:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "userprofile/" + implicitly[PathBindable[String]].unbind("userName", dynamicString(userName)))
    }
  
    // @LINE:82
    def createuserProfileProfile(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "userprofile/create")
    }
  
    // @LINE:84
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
  
    // @LINE:76
    def getPublicationWithAuthorsById(id:Integer): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "paper/id/" + implicitly[PathBindable[Integer]].unbind("id", id))
    }
  
    // @LINE:75
    def getPublicationWithAuthorsByYear(year:Integer): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "paper/year/" + implicitly[PathBindable[Integer]].unbind("year", year))
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
  
    // @LINE:77
    def getPublicationWithAuthorsByTitle(title:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "paper/title/" + implicitly[PathBindable[String]].unbind("title", dynamicString(title)))
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

  // @LINE:42
  class ReversePostController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:43
    def getPostById(postId:Long): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "post/getPostById/" + implicitly[PathBindable[Long]].unbind("postId", postId))
    }
  
    // @LINE:47
    def setAnswer(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "post/setAnswer")
    }
  
    // @LINE:42
    def addPost(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "post/addPost")
    }
  
    // @LINE:57
    def search(keyword:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "post/search/" + implicitly[PathBindable[String]].unbind("keyword", dynamicString(keyword)))
    }
  
    // @LINE:44
    def getAllPosts(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "post/getAllPosts")
    }
  
    // @LINE:45
    def addComment(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "post/addComment")
    }
  
    // @LINE:46
    def setAsQuestion(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "post/setAsQuestion")
    }
  
    // @LINE:58
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

  
    // @LINE:29
    def addComment(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "comment")
    }
  
    // @LINE:32
    def updateComment(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "updateComment")
    }
  
    // @LINE:33
    def uploadFile(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "upload")
    }
  
  }


}
