name := """akkadmey-db"""

version := "1.0"

scalaVersion := "2.11.7"

// Change this to another test framework if you prefer
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"

//  Depedencies
libraryDependencies ++= Seq(
  "com.typesafe.akka" % "akka-actor_2.11" % "2.3.3",
  "com.typesafe.akka" %% "akka-actor" % "2.3.3",
  "com.typesafe.akka" %% "akka-testkit" % "2.3.6" % "test",
  "junit"  % "junit" % "4.11" % "test",
  "com.novocode" % "junit-interface" % "0.10" % "test"
)

