package biblioteka.server.app

import io.ktor.server.netty.*
import io.ktor.server.engine.*
import io.ktor.application.*
import io.ktor.routing.*
import io.ktor.gson.*
import io.ktor.features.*
import biblioteka.server.routing.*
import biblioteka.server.db.DbClient

fun main() {
  embeddedServer(Netty, port = 8080) {
    val db = DbClient()
    install(ContentNegotiation) {
      gson {
        setPrettyPrinting()
      }
    }

    routing {
      setRouting(db)
    }
  }.start(wait = true)
}