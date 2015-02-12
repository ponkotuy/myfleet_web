package controllers

import play.api.mvc._
import play.api.libs.concurrent.Execution.Implicits._
import scala.concurrent.Future

/**
 *
 * @author ponkotuy
 * Date: 14/02/25
 */
object Common extends Controller {
  type Req = Map[String, Seq[String]]

  def reqHead(request: Req)(key: String): Option[String] = {
    for {
      results <- request.get(key)
      one <- results.headOption
    } yield one
  }

  def returnString[A](f: => A) = actionAsync { Ok(f.toString) }

  def actionAsync(f: => Result) = Action.async { request =>
    Future {
      try {
        f
      } catch {
        case e: IllegalArgumentException => BadRequest(e.getMessage)
      }
    }
  }

  def actionAsync(f: (Request[AnyContent]) => Result) = Action.async { request =>
    Future {
      try {
        f(request)
      } catch {
        case e: IllegalArgumentException => BadRequest(e.getMessage)
      }
    }
  }

  def formAsync(f: Request[Map[String, Seq[String]]] => Result) = Action.async(parse.urlFormEncoded) { request =>
    Future {
      try {
        f(request)
      } catch {
        case e: IllegalArgumentException => BadRequest(e.getMessage)
      }
    }
  }
}
