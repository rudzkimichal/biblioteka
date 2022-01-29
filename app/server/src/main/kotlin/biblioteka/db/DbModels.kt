package biblioteka.server.db

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import kotlinx.serialization.Serializable

@Serializable
data class Item(
  @BsonId
  val id: String? = ObjectId().toString(),
  val author: Author?,
  val title: String?,
  val publishedBy: String?,
  val location: String?,
  ) {}

@Serializable
data class Author(val firstName: String?, val lastName: String?)