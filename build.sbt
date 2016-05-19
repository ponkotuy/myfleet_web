
name := "MyFleetGirlsWeb"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  ws,
  "org.scalatest" %% "scalatest" % "2.2.5" % "test"
)

routesGenerator := InjectedRoutesGenerator

lazy val root = (project in file(".")).enablePlugins(PlayScala)

includeFilter in (Assets, LessKeys.less) := "*.less"

LessKeys.compress := true

TwirlKeys.templateImports ++= Seq("views._")

herokuAppName in Compile := "myfleet-web"
