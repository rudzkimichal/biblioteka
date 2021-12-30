package biblioteka.server.app

import io.ktor.server.netty.*
import io.ktor.server.engine.*
import biblioteka.server.routing.*

fun main() {
    embeddedServer(Netty, port = 8080) {
      configureRouting()
    }.start(wait = true)
}