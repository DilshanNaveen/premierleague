// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/dilshannaveen/Documents/GitHub/Course Works/premierleague/conf/routes
// @DATE:Sun Jan 10 12:27:00 IST 2021

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:9
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def getFilteredMatches(date:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/randommatch/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("date", date)))
    }
  
    // @LINE:12
    def getAllPlayedMatches(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/playedmatch")
    }
  
    // @LINE:9
    def getAllClubs(option:Integer): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/footballclub/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("option", option)))
    }
  
    // @LINE:15
    def getRandomMatch(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/randommatch")
    }
  
  }

  // @LINE:6
  class ReverseFrontendController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def assetOrDefault(file:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }


}
