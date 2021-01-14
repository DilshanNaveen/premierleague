// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/dilshannaveen/Documents/GitHub/Course Works/premierleague/conf/routes
// @DATE:Sun Jan 10 12:27:00 IST 2021


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
