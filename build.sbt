name := "autoprefixer"

//version := "2017.6.0-SNAPSHOT"

enablePlugins(ScalaJSPlugin)

val scala211 = "2.11.11"

val scala212 = "2.12.2"

scalaVersion := scala211

crossScalaVersions := Seq(scala211, scala212)

scalacOptions ++= Seq(
  "-feature",
  "-deprecation",
  "-unchecked",
  "-language:implicitConversions"
)

//deps

libraryDependencies ++= Seq(
  "scalajs-css" %%% "core" % "2017.6.24-RC" % Provided,
  "org.scala-js" %%% "scalajs-dom" % "0.9.1" % Provided)

//bintray
resolvers += Resolver.jcenterRepo

organization := "scalajs-css"

licenses += ("Apache-2.0", url(
  "https://www.apache.org/licenses/LICENSE-2.0.html"))

bintrayOrganization := Some("scalajs-css")

bintrayRepository := "maven"

publishArtifact in Test := false

//Test
resolvers += Resolver.bintrayRepo("scalajs-css", "maven")
libraryDependencies += "org.scalatest" %%% "scalatest" % "3.0.0" % Test
scalaJSStage in Global := FastOptStage
