import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
   java
   `java-library`
   signing
   `maven-publish`
   kotlin("jvm") version "1.8.21"
}

group = "io.kotest.extensions"
version = Ci.version

dependencies {
   implementation(libs.kotest.framework.api)
   api(libs.mockserver.netty)
   api(libs.mockserver.client.java)
   testImplementation(libs.kotest.assertions.core)
   testImplementation(libs.kotest.runner.junit5)
   testImplementation(libs.fuel)
}

tasks.named<Test>("test") {
   useJUnitPlatform()
   testLogging {
      showExceptions = true
      showStandardStreams = true
      exceptionFormat = TestExceptionFormat.FULL
   }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
   kotlinOptions.jvmTarget = "1.8"
}

java {
   targetCompatibility = JavaVersion.VERSION_1_8
   sourceCompatibility = JavaVersion.VERSION_1_8
}

repositories {
   mavenLocal()
   mavenCentral()
   maven {
      url = uri("https://s01.oss.sonatype.org/content/repositories/snapshots")
   }
}

apply("./publish.gradle.kts")
