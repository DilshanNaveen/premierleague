// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/dilshannaveen/Documents/GitHub/Course Works/premierleague/conf/routes
// @DATE:Sun Jan 10 12:27:00 IST 2021

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  FrontendController_1: controllers.FrontendController,
  // @LINE:9
  HomeController_0: controllers.HomeController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    FrontendController_1: controllers.FrontendController,
    // @LINE:9
    HomeController_0: controllers.HomeController
  ) = this(errorHandler, FrontendController_1, HomeController_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, FrontendController_1, HomeController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.FrontendController.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/footballclub/""" + "$" + """option<[^/]+>""", """controllers.HomeController.getAllClubs(option:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/playedmatch""", """controllers.HomeController.getAllPlayedMatches"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/randommatch""", """controllers.HomeController.getRandomMatch"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/randommatch/""" + "$" + """date<[^/]+>""", """controllers.HomeController.getFilteredMatches(date:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """file<.+>""", """controllers.FrontendController.assetOrDefault(file:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_FrontendController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_FrontendController_index0_invoker = createInvoker(
    FrontendController_1.index(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FrontendController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ Serve index page from public directory""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_HomeController_getAllClubs1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/footballclub/"), DynamicPart("option", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_getAllClubs1_invoker = createInvoker(
    HomeController_0.getAllClubs(fakeValue[Integer]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getAllClubs",
      Seq(classOf[Integer]),
      "GET",
      this.prefix + """api/footballclub/""" + "$" + """option<[^/]+>""",
      """# Get all clubs data""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_HomeController_getAllPlayedMatches2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/playedmatch")))
  )
  private[this] lazy val controllers_HomeController_getAllPlayedMatches2_invoker = createInvoker(
    HomeController_0.getAllPlayedMatches,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getAllPlayedMatches",
      Nil,
      "GET",
      this.prefix + """api/playedmatch""",
      """# Get all played match data""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_HomeController_getRandomMatch3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/randommatch")))
  )
  private[this] lazy val controllers_HomeController_getRandomMatch3_invoker = createInvoker(
    HomeController_0.getRandomMatch,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getRandomMatch",
      Nil,
      "GET",
      this.prefix + """api/randommatch""",
      """# Get all played match data""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_HomeController_getFilteredMatches4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/randommatch/"), DynamicPart("date", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_getFilteredMatches4_invoker = createInvoker(
    HomeController_0.getFilteredMatches(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getFilteredMatches",
      Seq(classOf[String]),
      "GET",
      this.prefix + """api/randommatch/""" + "$" + """date<[^/]+>""",
      """# Get all played match data""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_FrontendController_assetOrDefault5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_FrontendController_assetOrDefault5_invoker = createInvoker(
    FrontendController_1.assetOrDefault(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FrontendController",
      "assetOrDefault",
      Seq(classOf[String]),
      "GET",
      this.prefix + """""" + "$" + """file<.+>""",
      """ Serve static assets under public directory""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_FrontendController_index0_route(params@_) =>
      call { 
        controllers_FrontendController_index0_invoker.call(FrontendController_1.index())
      }
  
    // @LINE:9
    case controllers_HomeController_getAllClubs1_route(params@_) =>
      call(params.fromPath[Integer]("option", None)) { (option) =>
        controllers_HomeController_getAllClubs1_invoker.call(HomeController_0.getAllClubs(option))
      }
  
    // @LINE:12
    case controllers_HomeController_getAllPlayedMatches2_route(params@_) =>
      call { 
        controllers_HomeController_getAllPlayedMatches2_invoker.call(HomeController_0.getAllPlayedMatches)
      }
  
    // @LINE:15
    case controllers_HomeController_getRandomMatch3_route(params@_) =>
      call { 
        controllers_HomeController_getRandomMatch3_invoker.call(HomeController_0.getRandomMatch)
      }
  
    // @LINE:18
    case controllers_HomeController_getFilteredMatches4_route(params@_) =>
      call(params.fromPath[String]("date", None)) { (date) =>
        controllers_HomeController_getFilteredMatches4_invoker.call(HomeController_0.getFilteredMatches(date))
      }
  
    // @LINE:21
    case controllers_FrontendController_assetOrDefault5_route(params@_) =>
      call(params.fromPath[String]("file", None)) { (file) =>
        controllers_FrontendController_assetOrDefault5_invoker.call(FrontendController_1.assetOrDefault(file))
      }
  }
}
