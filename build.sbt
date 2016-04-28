name := """akkadmey-db"""

organization := "com.harmeetsingh13.akkalearning"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.11.7"

// Change this to another test framework if you prefer
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"

//  Depedencies
libraryDependencies ++= Seq(
  "com.typesafe.akka" % "akka-actor_2.11" % "2.3.3",
  "com.typesafe.akka" %% "akka-actor" % "2.3.3",
  "com.typesafe.akka" %% "akka-testkit" % "2.3.6" % "test",
  "com.typesafe.akka" %% "akka-remote" % "2.3.6",
  "junit"  % "junit" % "4.11" % "test",
  "com.novocode" % "junit-interface" % "0.10" % "test"
)

mappings in (Compile, packageBin) ~= { _.filterNot { case (_, name) =>
  Seq("application.conf").contains(name)
}}

pomExtra :=
  <developers>
    <developer>
      <id>harmeetsingh0013</id>
      <name>Harmeet Singh(Taara)</name>
      <email>harmeetsingh.0013@gmail.com</email>
      <url>http://harmeetsingh13.blogspot.in</url>
      <roles>
        <role>Programmer</role>
      </roles>
      <timezone>+05:30</timezone>
    </developer>
  </developers>
