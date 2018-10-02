name := """enroll-me"""
organization := "edu.sdsu.cs532.softwhere"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.4"

libraryDependencies += guice

libraryDependencies += "io.ebean" % "ebean" % "11.22.6"
libraryDependencies += "io.ebean.test" % "ebean-test-config" % "11.20.1"
libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.11"
