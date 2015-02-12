package controllers

import play.api.mvc.{Action, Controller}
import play.api.libs.ws.WS
import play.api.Play.current
import play.api.libs.concurrent.Execution.Implicits._
import views.URL

/**
 *
 * @author ponkotuy
 * Date: 15/02/12.
 */
object Other extends Controller {
  def favicon = Action { Redirect(URL.Favicon) }
  def redirectAssets(path: String) = Action { Redirect(s"${URL.Assets}/${path}") }
  def favCount(path: String) = Action.async {
    WS.url(s"${URL.Host}/rest/v1/fav_count/${path}").get().map(it => Ok(it.body))
  }
}
