
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/lunwenh/workspace/SSNetwork/conf/routes
// @DATE:Sat Apr 16 09:09:41 PDT 2016

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
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """person""", """controllers.Application.addPerson()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """persons""", """controllers.Application.getPersons()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """persons/""" + "$" + """id<[^/]+>""", """controllers.Application.getPersonById(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """sayHello""", """controllers.Application.sayHello()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """sayHello2""", """controllers.Application.sayHello2()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """person/uploadPic""", """controllers.Application.upload()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """paper/""" + "$" + """year<[^/]+>""", """controllers.Application.getPaperByYear(year:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """paper/""" + "$" + """title<[^/]+>""", """controllers.Application.getPaperByTitle(title:String)"""),
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

  // @LINE:7
  private[this] lazy val controllers_Application_addPerson1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("person")))
  )
  private[this] lazy val controllers_Application_addPerson1_invoker = createInvoker(
    Application_1.addPerson(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "addPerson",
      Nil,
      "POST",
      """""",
      this.prefix + """person"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_Application_getPersons2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("persons")))
  )
  private[this] lazy val controllers_Application_getPersons2_invoker = createInvoker(
    Application_1.getPersons(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getPersons",
      Nil,
      "GET",
      """""",
      this.prefix + """persons"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_Application_getPersonById3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("persons/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_getPersonById3_invoker = createInvoker(
    Application_1.getPersonById(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getPersonById",
      Seq(classOf[Long]),
      "GET",
      """""",
      this.prefix + """persons/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_Assets_at4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at4_invoker = createInvoker(
    Assets_0.at(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/""" + "$" + """file<.+>"""
    )
  )

  // @LINE:14
  private[this] lazy val controllers_Application_sayHello5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("sayHello")))
  )
  private[this] lazy val controllers_Application_sayHello5_invoker = createInvoker(
    Application_1.sayHello(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "sayHello",
      Nil,
      "POST",
      """""",
      this.prefix + """sayHello"""
    )
  )

  // @LINE:17
  private[this] lazy val controllers_Application_sayHello26_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("sayHello2")))
  )
  private[this] lazy val controllers_Application_sayHello26_invoker = createInvoker(
    Application_1.sayHello2(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "sayHello2",
      Nil,
      "POST",
      """""",
      this.prefix + """sayHello2"""
    )
  )

  // @LINE:19
  private[this] lazy val controllers_Application_upload7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("person/uploadPic")))
  )
  private[this] lazy val controllers_Application_upload7_invoker = createInvoker(
    Application_1.upload(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "upload",
      Nil,
      "POST",
      """""",
      this.prefix + """person/uploadPic"""
    )
  )

  // @LINE:27
  private[this] lazy val controllers_Application_getPaperByYear8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("paper/"), DynamicPart("year", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_getPaperByYear8_invoker = createInvoker(
    Application_1.getPaperByYear(fakeValue[Integer]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getPaperByYear",
      Seq(classOf[Integer]),
      "GET",
      """##Sprint1""",
      this.prefix + """paper/""" + "$" + """year<[^/]+>"""
    )
  )

  // @LINE:28
  private[this] lazy val controllers_Application_getPaperByTitle9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("paper/"), DynamicPart("title", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_getPaperByTitle9_invoker = createInvoker(
    Application_1.getPaperByTitle(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getPaperByTitle",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """paper/""" + "$" + """title<[^/]+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_Application_index0_route(params) =>
      call { 
        controllers_Application_index0_invoker.call(Application_1.index())
      }
  
    // @LINE:7
    case controllers_Application_addPerson1_route(params) =>
      call { 
        controllers_Application_addPerson1_invoker.call(Application_1.addPerson())
      }
  
    // @LINE:9
    case controllers_Application_getPersons2_route(params) =>
      call { 
        controllers_Application_getPersons2_invoker.call(Application_1.getPersons())
      }
  
    // @LINE:10
    case controllers_Application_getPersonById3_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Application_getPersonById3_invoker.call(Application_1.getPersonById(id))
      }
  
    // @LINE:12
    case controllers_Assets_at4_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at4_invoker.call(Assets_0.at(path, file))
      }
  
    // @LINE:14
    case controllers_Application_sayHello5_route(params) =>
      call { 
        controllers_Application_sayHello5_invoker.call(Application_1.sayHello())
      }
  
    // @LINE:17
    case controllers_Application_sayHello26_route(params) =>
      call { 
        controllers_Application_sayHello26_invoker.call(Application_1.sayHello2())
      }
  
    // @LINE:19
    case controllers_Application_upload7_route(params) =>
      call { 
        controllers_Application_upload7_invoker.call(Application_1.upload())
      }
  
    // @LINE:27
    case controllers_Application_getPaperByYear8_route(params) =>
      call(params.fromPath[Integer]("year", None)) { (year) =>
        controllers_Application_getPaperByYear8_invoker.call(Application_1.getPaperByYear(year))
      }
  
    // @LINE:28
    case controllers_Application_getPaperByTitle9_route(params) =>
      call(params.fromPath[String]("title", None)) { (title) =>
        controllers_Application_getPaperByTitle9_invoker.call(Application_1.getPaperByTitle(title))
      }
  }
}
