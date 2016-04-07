package controllers

import javax.inject.Inject

import play.api.mvc.{Action, Controller}
import play.api.libs.ws.WSClient
import views.URL

import scala.concurrent.ExecutionContext

/**
 *
 * @author ponkotuy
 * Date: 15/02/12.
 */
class Other @Inject()(implicit val ec: ExecutionContext, ws: WSClient) extends Controller {
  def favicon = Action { Redirect(URL.Favicon) }
  def redirectAssets(path: String) = Action { Redirect(s"${URL.Assets}/${path}") }
  def favCount(path: String) = Action.async {
    ws.url(s"${URL.Host}/rest/v1/fav_count/${path}").get().map(it => Ok(it.body))
  }
}
