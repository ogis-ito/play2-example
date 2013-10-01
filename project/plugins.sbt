// Comment to get more information during initialization
logLevel := Level.Warn

testOptions += Tests.Argument(TestFrameworks.Specs2, "console", "junitxml")

// The Typesafe repository 
resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

// Use the Play sbt plugin for Play projects
addSbtPlugin("play" % "sbt-plugin" % "2.0.4")

addSbtPlugin("com.github.scct" % "sbt-scct" % "0.2")
