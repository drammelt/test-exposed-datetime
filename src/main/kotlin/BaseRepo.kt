import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.LocalDateTime

object BaseRepo: LongIdTable(name = "baserepo") {
    val deleted = bool("deleted")
        .default(false)

    val createdAt = datetime("created_at")
        .clientDefault { LocalDateTime.now() }
    val updatedAt = datetime("updated_at")
        .clientDefault { LocalDateTime.now() }
}