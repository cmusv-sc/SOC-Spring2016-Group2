
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object index_Scope0 {
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

class index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*32.2*/search/*32.8*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*32.11*/("""


        """),format.raw/*35.9*/("""<div class="container">
            <h1>SOC_NETWORK</h1>

            <form id="searchForm" , action = """"),_display_(/*38.48*/routes/*38.54*/.Application.getPersons()),format.raw/*38.79*/("""", method="GET">
                <fieldset>
                    <input id="s" type="text" />
                     <input type="submit" value="Submit" id="submitButton" />

                    <div id="searchInContainer">
                        <input type="radio" name="check" value="site" id="searchSite" checked />
                          <label for="searchSite" id="siteNameLabel">Search</label>

                          <input type="radio" name="check" value="web" id="searchWeb" />
                          <label for="searchWeb">Search Google</label>
                     </div>
                    <ul class="icons">
                        <li class="web" title="Web Search" data-searchType="web">Web</li>
                          <li class="images" title="Image Search" data-searchType="images">Images</li>
                          <li class="news" title="News Search" data-searchType="news">News</li>
                          <li class="videos" title="Video Search" data-searchType="video">Videos</li>
                    </ul>
                </fieldset>
            </form>

            <div id="resultsDiv"></div>

        </div>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
""")))};
Seq[Any](_display_(/*1.2*/main("Home")/*1.14*/(search)/*1.22*/{_display_(Seq[Any](format.raw/*1.23*/("""
   """),format.raw/*2.96*/("""
    """),format.raw/*3.27*/("""
    """),format.raw/*4.5*/("""<ul id="persons"></ul>


    """),format.raw/*7.70*/("""
        """),format.raw/*8.45*/("""
        """),format.raw/*9.40*/("""
    """),format.raw/*10.16*/("""

    """),format.raw/*12.44*/("""
        """),format.raw/*13.55*/("""
        """),format.raw/*14.74*/("""
        """),format.raw/*15.59*/("""
        """),format.raw/*16.49*/("""
        """),format.raw/*17.43*/("""
        """),format.raw/*18.53*/("""
    """),format.raw/*19.14*/("""


    """),format.raw/*22.103*/("""

        """),format.raw/*24.47*/("""

        """),format.raw/*26.16*/("""
            """),format.raw/*27.38*/("""
        """),format.raw/*28.17*/("""


""")))}),format.raw/*31.2*/("""
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


}

/**/
object index extends index_Scope0.index
              /*
                  -- GENERATED --
                  DATE: Fri Apr 15 14:08:43 PDT 2016
                  SOURCE: /home/lunwenh/workspace/SSNetwork/app/views/index.scala.html
                  HASH: 88640da2aa1e443efa6a8e33aa9ff68a061222db
                  MATRIX: 812->968|826->974|907->977|945->988|1077->1093|1092->1099|1138->1124|2425->1|2445->13|2461->21|2499->22|2530->118|2562->145|2593->150|2649->244|2685->289|2721->329|2754->345|2788->390|2825->445|2862->519|2899->578|2936->627|2973->670|3010->723|3043->737|3079->842|3117->890|3155->907|3196->945|3233->962|3267->966
                  LINES: 31->32|31->32|33->32|36->35|39->38|39->38|39->38|65->1|65->1|65->1|65->1|66->2|67->3|68->4|71->7|72->8|73->9|74->10|76->12|77->13|78->14|79->15|80->16|81->17|82->18|83->19|86->22|88->24|90->26|91->27|92->28|95->31
                  -- GENERATED --
              */
          