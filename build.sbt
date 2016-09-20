name := "qaj"

version := "1-0-SNAPSHOT"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.clulab" %% "processors-corenlp" % "6.0.0",
  "org.clulab" %% "processors-main" % "6.0.0",
  "org.clulab" %% "processors-models" % "6.0.0",
  "org.apache.lucene" % "lucene-core" % "6.2.0"
)
