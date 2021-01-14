// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/dilshannaveen/Documents/GitHub/Course Works/premierleague/conf/routes
// @DATE:Sun Jan 10 12:27:00 IST 2021

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:9
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def getFilteredMatches: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getFilteredMatches",
      """
        function(date0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/randommatch/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("date", date0))})
        }
      """
    )
  
    // @LINE:12
    def getAllPlayedMatches: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getAllPlayedMatches",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/playedmatch"})
        }
      """
    )
  
    // @LINE:9
    def getAllClubs: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getAllClubs",
      """
        function(option0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/footballclub/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Integer]].javascriptUnbind + """)("option", option0))})
        }
      """
    )
  
    // @LINE:15
    def getRandomMatch: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getRandomMatch",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/randommatch"})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseFrontendController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def assetOrDefault: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FrontendController.assetOrDefault",
      """
        function(file0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + (""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("file", file0)})
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FrontendController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }


}
