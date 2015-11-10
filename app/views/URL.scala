package views

/**
 *
 * @author ponkotuy
 * Date: 15/02/09.
 */
object URL {
  val Host = "https://myfleet.moe"
  def Index = Host
  val Entire = s"${Host}/entire"
  val Entire = s"${Host}/passwd/entire"
  val Statistics = s"${Entire}/activities"
  val Login = s"${Entire}/passwd/login"
  val Favicon = s"${Host}/favicon.ico"
  val Assets = s"${Host}/assets"
}
