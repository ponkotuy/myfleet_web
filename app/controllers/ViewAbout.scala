package controllers

import javax.inject.Inject

import play.api.mvc.Controller

import scala.concurrent.ExecutionContext

/**
 *
 * @author ponkotuy
 * Date: 14/10/11.
 \*/
class ViewAbout @Inject()(implicit val ec: ExecutionContext) extends Controller {
  def setup = Common.actionAsync { Ok(views.html.about.setup()) }
  def changeLog = Common.actionAsync { Ok(views.html.about.change_log()) }
  def faq = Common.actionAsync { Ok(views.html.about.faq()) }
  def setupDetail = Common.actionAsync { Ok(views.html.about.setup_detail()) }
  def author = Common.actionAsync { Ok(views.html.about.author()) }
}
