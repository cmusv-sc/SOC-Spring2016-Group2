
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object main_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._

class main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[String,Html,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(search:Html)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.45*/("""
"""),format.raw/*2.1*/("""<!DOCTYPE html>
<html>
    <head>
        <title>"""),_display_(/*5.17*/title),format.raw/*5.22*/("""</title>
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*6.59*/routes/*6.65*/.Assets.at("images/favicon.png")),format.raw/*6.97*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(/*7.54*/routes/*7.60*/.Assets.at("stylesheets/styles.css")),format.raw/*7.96*/("""">
        <script src=""""),_display_(/*8.23*/routes/*8.29*/.Assets.at("javascripts/jquery-2.2.0.min.js")),format.raw/*8.74*/("""" type="text/javascript"></script>
    </head>
    <body>
        <div class="container">
        """),_display_(/*12.10*/content),format.raw/*12.17*/("""
        """),_display_(/*13.10*/search),format.raw/*13.16*/("""
        """),format.raw/*14.9*/("""</div>
    </body>
</html>
"""))
      }
    }
  }

  def render(title:String,search:Html,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(search)(content)

  def f:((String) => (Html) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (search) => (content) => apply(title)(search)(content)

  def ref: this.type = this

}


}

/**/
object main extends main_Scope0.main
              /*
                  -- GENERATED --
                  DATE: Sat Apr 16 09:09:40 PDT 2016
                  SOURCE: /home/lunwenh/workspace/SSNetwork/app/views/main.scala.html
                  HASH: 5f0d9955812aaa4ef10287ddeb70185dbc7823b5
                  MATRIX: 753->1|891->44|918->45|994->95|1019->100|1112->167|1126->173|1178->205|1260->261|1274->267|1330->303|1381->328|1395->334|1460->379|1586->478|1614->485|1651->495|1678->501|1714->510
                  LINES: 27->1|32->1|33->2|36->5|36->5|37->6|37->6|37->6|38->7|38->7|38->7|39->8|39->8|39->8|43->12|43->12|44->13|44->13|45->14
                  -- GENERATED --
              */
          