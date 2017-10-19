name := "boris-bikes"

version := "0.1"

scalaVersion := "2.11.11"

val sparkVersion = "2.2.0"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion % Provided,
  "org.apache.spark" %% "spark-sql" % sparkVersion % Provided,

  "com.lihaoyi" %% "utest" % "0.5.4" % Test,
)

testFrameworks += new TestFramework("utest.runner.Framework")