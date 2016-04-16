
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/lunwenh/workspace/SSNetwork/conf/routes
// @DATE:Sat Apr 16 09:09:41 PDT 2016


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
