
package biblioteka.server.routing

import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*

fun Application.setRouting() {
  routing {
    get("/") {
      call.respondText("App init successful")
    }
  }
}
