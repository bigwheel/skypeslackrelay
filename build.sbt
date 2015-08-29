name := "skypeslackrelay"

version := "1.0"

scalaVersion := "2.11.7"

lazy val root = project.in(file("."))

libraryDependencies ++= Seq(
  "com.github.taksan" % "skype-java-api" % "1.7",
  "com.github.gilbertw1" %% "slack-scala-client" % "0.1.2",
  "com.twitter" % "util-eval_2.11" % "6.26.0",
  "org.scalaz" %% "scalaz-core" % "7.1.3"
)
