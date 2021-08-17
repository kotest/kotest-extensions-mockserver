object Libs {

   const val kotlinVersion = "1.4.32"
   const val org = "io.kotest.extensions"

   object Kotest {
      private const val version = "4.6.1"
      const val Junit5 = "io.kotest:kotest-runner-junit5-jvm:$version"
      const val Assertions = "io.kotest:kotest-assertions-core:$version"
      const val Api = "io.kotest:kotest-framework-api:$version"
   }

   object MockServer {
      private const val version = "5.11.2"
      const val netty = "org.mock-server:mockserver-netty:$version"
      const val javaClient = "org.mock-server:mockserver-client-java:$version"
   }

   object Coroutines {
      private const val version = "1.4.3"
      const val coreCommon = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
      const val coreJvm = "org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:$version"
   }
}
