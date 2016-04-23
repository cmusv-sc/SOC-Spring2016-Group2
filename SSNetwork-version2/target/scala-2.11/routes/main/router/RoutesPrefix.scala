
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/caoyi/Tutorial/conf/routes
// @DATE:Wed Apr 13 18:06:30 PDT 2016


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
