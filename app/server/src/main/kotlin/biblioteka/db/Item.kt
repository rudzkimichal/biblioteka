package biblioteka.server.db

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class Item(
  @BsonId
  val id: String? = ObjectId().toString(),
  val author: Any?,
  val title: String?,
  val publishedBy: String?,
  val location: String?,

  )