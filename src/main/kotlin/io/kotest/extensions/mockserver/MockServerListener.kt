package io.kotest.extensions.mockserver

import io.kotest.core.listeners.TestListener
import io.kotest.core.spec.Spec
import org.mockserver.integration.ClientAndServer
import org.mockserver.integration.ClientAndServer.startClientAndServer

/**
 * @param port A mockserver will be launched for each [port]. If empty, a random port
 * will be used (found via [mockServer])
 */
class MockServerListener(
  private vararg val port: Int = intArrayOf()
) : TestListener, AutoCloseable {

   // this has to be a var because MockServer starts the server as soon as you instantiate the instance :(
   lateinit var mockServer: ClientAndServer

   override suspend fun beforeSpec(spec: Spec) {
      super.beforeSpec(spec)
      mockServer = startClientAndServer(*port.toTypedArray())
   }

   override suspend fun afterSpec(spec: Spec) {
      mockServer.stop()
   }

   override fun close() {
      mockServer.stop()
   }
}
