<<<<<<< HEAD
name := """warehouse"""
=======
name := """HelloWorld"""
>>>>>>> 2a403f63898d878a31c4c6c6d6f8e06463ccd5ed

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

<<<<<<< HEAD
libraryDependencies += javaEbean

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  "org.postgresql" % "postgresql" % "9.3-1100-jdbc41",
  cache,
  javaWs,
  filters
=======
libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs
>>>>>>> 2a403f63898d878a31c4c6c6d6f8e06463ccd5ed
)
