import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

  val appName       = "play2-example"
  val appVersion    = "1.0-SNAPSHOT"

  val appDependencies =
    Seq(
      // Add your project dependencies here
      "org.squeryl" %% "squeryl" % "0.9.5-2",
      "mysql" % "mysql-connector-java" % "5.1.21"
    )

  lazy val s = Defaults.defaultSettings ++
    Seq(ScctPlugin.instrumentSettings: _*)

  val main =
    PlayProject(appName, appVersion, appDependencies,
       mainLang = SCALA, settings = s)
      .settings(
        // Add your own project settings here
        parallelExecution in test := false
      )

}
