
package biblioteka.server.routing

import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import biblioteka.server.db.*

fun Route.setRouting(db: DbClient) {
  route("/") {
    get {
      call.respond(db.getAll())
    }
    post {
      val item = call.receive<Item>()
      db.addItem(item)
      call.respondText("Item added ok", status = HttpStatusCode.Created)
    }
  }
}