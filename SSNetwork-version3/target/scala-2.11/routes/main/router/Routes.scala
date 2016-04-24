
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/yuanyuan/Documents/SSNetwork/SSNetwork-version3/conf/routes
// @DATE:Sat Apr 23 16:53:11 PDT 2016

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
  Application_1: controllers.Application,
  // @LINE:12
  Assets_0: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    Application_1: controllers.Application,
    // @LINE:12
    Assets_0: controllers.Assets
  ) = this(errorHandler, Application_1, Assets_0, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Application_1, Assets_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.Application.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """persons""", """controllers.Application.getPersons()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """year/""" + "$" + """year<[^/]+>""", """controllers.Application.getPaperByYear(year:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """title/""" + "$" + """title<[^/]+>""", """controllers.Application.getPaperByTitle(title:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """all""", """controllers.Application.getAllPublications()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """keyword/""" + "$" + """keyWord<[^/]+>""", """controllers.Application.getPaperBykeyWord(keyWord:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """author/""" + "$" + """author<[^/]+>""", """controllers.Application.getCoAuthors(author:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """keyword/""" + "$" + """author<[^/]+>""", """controllers.Application.getPaperByAuthor(author:String)"""),
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
    Application_1.index(),
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
  private[this] lazy val controllers_Application_getPersons1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("persons")))
  )
  private[this] lazy val controllers_Application_getPersons1_invoker = createInvoker(
    Application_1.getPersons(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getPersons",
      Nil,
      "GET",
      """POST    /person                     controllers.Application.addPerson()
""",
      this.prefix + """persons"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_Assets_at2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at2_invoker = createInvoker(
    Assets_0.at(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """GET     /persons/:id                controllers.Application.getPersonById(id : Long)
# Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/""" + "$" + """file<.+>"""
    )
  )

  // @LINE:24
  private[this] lazy val controllers_Application_getPaperByYear3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("year/"), DynamicPart("year", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_getPaperByYear3_invoker = createInvoker(
    Application_1.getPaperByYear(fakeValue[Integer]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getPaperByYear",
      Seq(classOf[Integer]),
      "GET",
      """##Sprint1""",
      this.prefix + """year/""" + "$" + """year<[^/]+>"""
    )
  )

  // @LINE:25
  private[this] lazy val controllers_Application_getPaperByTitle4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("title/"), DynamicPart("title", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_getPaperByTitle4_invoker = createInvoker(
    Application_1.getPaperByTitle(fakeValue[String]),
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

  // @LINE:26
  private[this] lazy val controllers_Application_getAllPublications5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("all")))
  )
  private[this] lazy val controllers_Application_getAllPublications5_invoker = createInvoker(
    Application_1.getAllPublications(),
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

  // @LINE:28
  private[this] lazy val controllers_Application_getPaperBykeyWord6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("keyword/"), DynamicPart("keyWord", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_getPaperBykeyWord6_invoker = createInvoker(
    Application_1.getPaperBykeyWord(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getPaperBykeyWord",
      Seq(classOf[String]),
      "GET",
      """##Sprint2""",
      this.prefix + """keyword/""" + "$" + """keyWord<[^/]+>"""
    )
  )

  // @LINE:29
  private[this] lazy val controllers_Application_getCoAuthors7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("author/"), DynamicPart("author", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_getCoAuthors7_invoker = createInvoker(
    Application_1.getCoAuthors(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getCoAuthors",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """author/""" + "$" + """author<[^/]+>"""
    )
  )

  // @LINE:30
  private[this] lazy val controllers_Application_getPaperByAuthor8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("keyword/"), DynamicPart("author", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_getPaperByAuthor8_invoker = createInvoker(
    Application_1.getPaperByAuthor(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getPaperByAuthor",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """keyword/""" + "$" + """author<[^/]+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_Application_index0_route(params) =>
      call { 
        controllers_Application_index0_invoker.call(Application_1.index())
      }
  
    // @LINE:9
    case controllers_Application_getPersons1_route(params) =>
      call { 
        controllers_Application_getPersons1_invoker.call(Application_1.getPersons())
      }
  
    // @LINE:12
    case controllers_Assets_at2_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at2_invoker.call(Assets_0.at(path, file))
      }
  
    // @LINE:24
    case controllers_Application_getPaperByYear3_route(params) =>
      call(params.fromPath[Integer]("year", None)) { (year) =>
        controllers_Application_getPaperByYear3_invoker.call(Application_1.getPaperByYear(year))
      }
  
    // @LINE:25
    case controllers_Application_getPaperByTitle4_route(params) =>
      call(params.fromPath[String]("title", None)) { (title) =>
        controllers_Application_getPaperByTitle4_invoker.call(Application_1.getPaperByTitle(title))
      }
  
    // @LINE:26
    case controllers_Application_getAllPublications5_route(params) =>
      call { 
        controllers_Application_getAllPublications5_invoker.call(Application_1.getAllPublications())
      }
  
    // @LINE:28
    case controllers_Application_getPaperBykeyWord6_route(params) =>
      call(params.fromPath[String]("keyWord", None)) { (keyWord) =>
        controllers_Application_getPaperBykeyWord6_invoker.call(Application_1.getPaperBykeyWord(keyWord))
      }
  
    // @LINE:29
    case controllers_Application_getCoAuthors7_route(params) =>
      call(params.fromPath[String]("author", None)) { (author) =>
        controllers_Application_getCoAuthors7_invoker.call(Application_1.getCoAuthors(author))
      }
  
    // @LINE:30
    case controllers_Application_getPaperByAuthor8_route(params) =>
      call(params.fromPath[String]("author", None)) { (author) =>
        controllers_Application_getPaperByAuthor8_invoker.call(Application_1.getPaperByAuthor(author))
      }
  }
}
