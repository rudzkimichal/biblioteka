
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
      val items: List<Item> = db.getAll()
      if(items.isNotEmpty())
        call.respond(items) else
          call.respondText("No items in database.", status = HttpStatusCode.NotFound)
    }
    post {
      val item = call.receive<Item>()
      db.addItem(item)
      call.respondText("Item added.", status = HttpStatusCode.Created)
    }
  }

  route("/{id}") {
    get {
      val id = call.parameters["id"] ?: return@get call.respondText("Invalid id.", status = HttpStatusCode.BadRequest)
      val item = db.getById(id) ?: return@get call.respondText("No item with given id: $id.", status = HttpStatusCode.NotFound)
      call.respond(item)
    }
  }
}