package biblioteka.server.app

import io.ktor.server.netty.*
import io.ktor.server.engine.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.application.*

fun main() {
    embeddedServer(Netty, port = 8080) {
        routing {
          get("/") {
            call.respondText("App init OK")
          }
        }
    }.start(wait = true)
}