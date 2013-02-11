// Comment to get more information during initialization
logLevel := Level.Warn

testOptions += Tests.Argument(TestFrameworks.Specs2, "console", "junitxml")

// The Typesafe repository 
resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "scct-github-repository" at "http://mtkopone.github.com/scct/maven-repo/"

// Use the Play sbt plugin for Play projects
addSbtPlugin("play" % "sbt-plugin" % "2.0.4")

addSbtPlugin("reaktor" %% "sbt-scct" % "0.2-SNAPSHOT")
