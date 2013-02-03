import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

  val appName       = "play2-example"
  val appVersion    = "1.0-SNAPSHOT"

  val appDependencies =
    Seq(
      // Add your project dependencies here
      "mysql" % "mysql-connector-java" % "5.1.21",
      "org.squeryl" %% "squeryl" % "0.9.5-2",
      "org.scalatest" %% "scalatest" % "1.8" % "test"
    )

  val main =
    PlayProject(appName, appVersion, appDependencies, mainLang = SCALA)
      .settings(
        // Add your own project settings here
        testOptions in Test := Nil
      )

}
