package biblioteka.server.db

import org.litote.kmongo.*
import org.litote.kmongo.coroutine.*
import com.mongodb.client.result.InsertOneResult
import org.litote.kmongo.reactivestreams.KMongo
import io.github.cdimascio.dotenv.dotenv
import biblioteka.server.db.Item

class DbClient {
  val env = dotenv()
  private val client = KMongo.createClient("${env["MONGODB_DEV_URI"]}").coroutine
  private val database = client.getDatabase("books")
  val coll: CoroutineCollection<Item> = database.getCollection("list")

  suspend fun getAll(): List<Item> = coll.find().toList()
  suspend fun addItem(item: Item): InsertOneResult = coll.insertOne(item)
}