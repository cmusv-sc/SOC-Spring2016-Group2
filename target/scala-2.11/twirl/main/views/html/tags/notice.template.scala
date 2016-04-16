
package views.html.tags

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object notice_Scope0 {
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

class notice extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,_root_.scala.Function1[String, Html],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(level: String = "error")(body: (String) => Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.51*/("""
"""),_display_(/*2.2*/level/*2.7*/ match/*2.13*/ {/*4.3*/case "success" =>/*4.20*/ {_display_(Seq[Any](format.raw/*4.22*/("""
    """),format.raw/*5.5*/("""<p class="success">
    """),_display_(/*6.6*/body("green")),format.raw/*6.19*/("""
    """),format.raw/*7.5*/("""</p>
  """)))}/*10.3*/case "warning" =>/*10.20*/ {_display_(Seq[Any](format.raw/*10.22*/("""
    """),format.raw/*11.5*/("""<p class="warning">
    """),_display_(/*12.6*/body("orange")),format.raw/*12.20*/("""
    """),format.raw/*13.5*/("""</p>
  """)))}/*16.3*/case "error" =>/*16.18*/ {_display_(Seq[Any](format.raw/*16.20*/("""
    """),format.raw/*17.5*/("""<p class="error">
    """),_display_(/*18.6*/body("red")),format.raw/*18.17*/("""
    """),format.raw/*19.5*/("""</p>
  """)))}}))
      }
    }
  }

  def render(level:String,body:_root_.scala.Function1[String, Html]): play.twirl.api.HtmlFormat.Appendable = apply(level)(body)

  def f:((String) => (_root_.scala.Function1[String, Html]) => play.twirl.api.HtmlFormat.Appendable) = (level) => (body) => apply(level)(body)

  def ref: this.type = this

}


}

/**/
object notice extends notice_Scope0.notice
              /*
                  -- GENERATED --
                  DATE: Sat Apr 16 09:09:40 PDT 2016
                  SOURCE: /home/lunwenh/workspace/SSNetwork/app/views/tags/notice.scala.html
                  HASH: f4aecf48feb51005fa66dd652baa090208cc7b2e
                  MATRIX: 789->1|933->50|960->52|972->57|986->63|995->69|1020->86|1059->88|1090->93|1140->118|1173->131|1204->136|1230->148|1256->165|1296->167|1328->172|1379->197|1414->211|1446->216|1472->228|1496->243|1536->245|1568->250|1617->273|1649->284|1681->289
                  LINES: 27->1|32->1|33->2|33->2|33->2|33->4|33->4|33->4|34->5|35->6|35->6|36->7|37->10|37->10|37->10|38->11|39->12|39->12|40->13|41->16|41->16|41->16|42->17|43->18|43->18|44->19
                  -- GENERATED --
              */
          