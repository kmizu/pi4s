organization := "com.github.kmizu"

name := "pi4s"

val Scala211 = "2.11.12"
val Scala212 = "2.12.10"
val Scala213 = "2.13.1"
scalaVersion := Scala213

crossScalaVersions := Seq(Scala211, Scala212, Scala213)

publishMavenStyle := true

val scaladocBranch = settingKey[String]("branch name for scaladoc -doc-source-url")

scaladocBranch := "master"

scalacOptions in (Compile, doc) ++= { Seq(
  "-sourcepath", baseDirectory.value.getAbsolutePath,
  "-doc-source-url", s"https://github.com/kmizu/macro_peg/tree/${scaladocBranch.value}€{FILE_PATH}.scala"
)}

assemblyJarName in assembly := "pi4s.jar"

mainClass in assembly := Some("com.github.kmizu.pi4s.Main")

scalacOptions ++= {
  Seq("-unchecked", "-deprecation", "-feature", "-language:implicitConversions")
}

libraryDependencies ++= Seq(
  "com.pi4j" % "pi4j-core" % "1.2",
  "com.pi4j" % "pi4j-device" % "1.2",
  "com.pi4j" % "pi4j-gpio-extension" % "1.2",
  "com.pi4j" % "pi4j-service" % "1.1",
  "com.pi4j" % "pi4j-native" % "1.2" pomOnly()
)

initialCommands in console += {
  val imports = Iterator(
    "com.pi4j.io.gpio._",
    "com.pi4j.wiringpi._"
  ).map("import "+).mkString("\n")
  val body = Iterator(
    "Gpio.wiringPiSetupGpio()"
  ).mkString("\n")
  s"""
    ${imports}
    ${body}
  """
}


pomExtra := (
  <url>https://github.com/kmizu/macro_peg</url>
  <licenses>
    <license>
      <name>The MIT License</name>
      <url>http://www.opensource.org/licenses/MIT</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:kmizu/macro_peg.git</url>
    <connection>scm:git:git@github.com:kmizu/macro_peg.git</connection>
  </scm>
  <developers>
    <developer>
      <id>kmizu</id>
      <name>Kota Mizushima</name>
      <url>https://github.com/kmizu</url>
    </developer>
  </developers>
)

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (version.value.endsWith("-SNAPSHOT"))
    Some("snapshots" at nexus+"content/repositories/snapshots")
  else
    Some("releases" at nexus+"service/local/staging/deploy/maven2")
}

credentials ++= {
  val sonatype = ("Sonatype Nexus Repository Manager", "oss.sonatype.org")
  def loadMavenCredentials(file: java.io.File) : Seq[Credentials] = {
    xml.XML.loadFile(file) \ "servers" \ "server" map (s => {
      val host = (s \ "id").text
      val realm = if (host == sonatype._2) sonatype._1 else "Unknown"
      Credentials(realm, host, (s \ "username").text, (s \ "password").text)
    })
  }
  val ivyCredentials   = Path.userHome / ".ivy2" / ".credentials"
  val mavenCredentials = Path.userHome / ".m2"   / "settings.xml"
  (ivyCredentials.asFile, mavenCredentials.asFile) match {
    case (ivy, _) if ivy.canRead => Credentials(ivy) :: Nil
    case (_, mvn) if mvn.canRead => loadMavenCredentials(mvn)
    case _ => Nil
  }
}
