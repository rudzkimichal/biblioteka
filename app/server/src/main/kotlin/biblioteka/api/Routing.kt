
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
      val items = db.getAll()
      if(items.isNotEmpty())
        call.respond(items) else
          call.respondText("No items in database", status = HttpStatusCode.NotFound)
    }
    post {
      val item = call.receive<Item>()
      db.addItem(item)
      call.respondText("Item added ok", status = HttpStatusCode.Created)
    }
  }
}