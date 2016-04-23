
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/ThomasHsu/Desktop/SSNetwork/backend/conf/routes
// @DATE:Sat Apr 23 14:56:47 PDT 2016


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
