package controllers

import play.api.mvc.Controller
import views.URL

/**
 *
 * @author ponkotuy
 * Date: 15/02/12.
 */
object Other extends Controller {
  def favicon = Redirect(URL.Host, SEE_OTHER)
}
