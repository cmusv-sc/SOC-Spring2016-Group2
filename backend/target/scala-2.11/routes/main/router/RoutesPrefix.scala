
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/caoyi/Desktop/SSNetwork/backend/conf/routes
// @DATE:Tue Apr 26 17:06:13 PDT 2016


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
