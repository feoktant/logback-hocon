name := "logback-hocon"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  "com.typesafe"      % "config"          % "1.3.1",
  "ch.qos.logback"    % "logback-core"    % "1.2.3",
  "ch.qos.logback"    % "logback-classic" % "1.2.3"
)
