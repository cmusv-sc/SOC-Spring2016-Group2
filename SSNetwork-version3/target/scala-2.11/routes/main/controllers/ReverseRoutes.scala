
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/yuanyuan/Documents/SSNetwork/SSNetwork-version3/conf/routes
// @DATE:Sat Apr 23 16:53:11 PDT 2016

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:12
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def at(file:String): Call = {
      implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
    }
  
  }

  // @LINE:6
  class ReverseApplication(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:26
    def getAllPublications(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "all")
    }
  
    // @LINE:30
    def getPaperByAuthor(author:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "keyword/" + implicitly[PathBindable[String]].unbind("author", dynamicString(author)))
    }
  
    // @LINE:29
    def getCoAuthors(author:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "author/" + implicitly[PathBindable[String]].unbind("author", dynamicString(author)))
    }
  
    // @LINE:9
    def getPersons(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "persons")
    }
  
    // @LINE:28
    def getPaperBykeyWord(keyWord:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "keyword/" + implicitly[PathBindable[String]].unbind("keyWord", dynamicString(keyWord)))
    }
  
    // @LINE:25
    def getPaperByTitle(title:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "title/" + implicitly[PathBindable[String]].unbind("title", dynamicString(title)))
    }
  
    // @LINE:6
    def index(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix)
    }
  
    // @LINE:24
    def getPaperByYear(year:Integer): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "year/" + implicitly[PathBindable[Integer]].unbind("year", year))
    }
  
  }


}
