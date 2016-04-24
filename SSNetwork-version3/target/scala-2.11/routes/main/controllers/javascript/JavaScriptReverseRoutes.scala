
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/yuanyuan/Documents/SSNetwork/SSNetwork-version3/conf/routes
// @DATE:Sat Apr 23 16:53:11 PDT 2016

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:12
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseApplication(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:26
    def getAllPublications: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getAllPublications",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "all"})
        }
      """
    )
  
    // @LINE:30
    def getPaperByAuthor: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getPaperByAuthor",
      """
        function(author0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "keyword/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("author", encodeURIComponent(author0))})
        }
      """
    )
  
    // @LINE:29
    def getCoAuthors: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getCoAuthors",
      """
        function(author0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "author/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("author", encodeURIComponent(author0))})
        }
      """
    )
  
    // @LINE:9
    def getPersons: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getPersons",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "persons"})
        }
      """
    )
  
    // @LINE:28
    def getPaperBykeyWord: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getPaperBykeyWord",
      """
        function(keyWord0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "keyword/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("keyWord", encodeURIComponent(keyWord0))})
        }
      """
    )
  
    // @LINE:25
    def getPaperByTitle: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getPaperByTitle",
      """
        function(title0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "title/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("title", encodeURIComponent(title0))})
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
  
    // @LINE:24
    def getPaperByYear: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getPaperByYear",
      """
        function(year0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "year/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("year", year0)})
        }
      """
    )
  
  }


}
