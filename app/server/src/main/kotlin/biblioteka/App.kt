package biblioteka.server.app

import io.ktor.server.netty.*
import io.ktor.server.engine.*
import io.ktor.application.*
import io.ktor.routing.*
import io.ktor.serialization.*
import io.ktor.features.*
import kotlinx.serialization.json.Json
import biblioteka.server.routing.*
import biblioteka.server.db.DbClient

fun main() {
  embeddedServer(Netty, port = 8080) {
    val db = DbClient()
    install(ContentNegotiation) {
      json(
        Json {
          prettyPrint = true
        }
      )
    }

    routing {
      setRouting(db)
    }
  }.start(wait = true)
}