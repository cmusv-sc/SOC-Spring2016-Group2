
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/yuanyuan/Documents/SSNetwork/SSNetwork-version3/conf/routes
// @DATE:Sat Apr 23 16:53:11 PDT 2016


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
