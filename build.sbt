
name := "MyFleetGirlsWeb"

scalaVersion := "2.11.5"

libraryDependencies ++= Seq(
  ws,
  "org.scalatest" %% "scalatest" % "2.2.3" % "test"
)

lazy val root = (project in file(".")).enablePlugins(PlayScala)

includeFilter in (Assets, LessKeys.less) := "*.less"

LessKeys.compress := true

TwirlKeys.templateImports ++= Seq("views._")

herokuAppName in Compile := "myfleet-web"
