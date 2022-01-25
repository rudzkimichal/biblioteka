package biblioteka.server.db

import org.litote.kmongo.*
import org.litote.kmongo.coroutine.*
import org.litote.kmongo.reactivestreams.KMongo
import biblioteka.server.db.Item

class DbClient {
  private val client = KMongo.createClient(DB_DEV_URI).coroutine
  private val database = client.getDatabase("books")
  val coll: CoroutineCollection<Item> = database.getCollection("list")

  suspend fun getAll(): List<Item> = coll.find().toList()
}