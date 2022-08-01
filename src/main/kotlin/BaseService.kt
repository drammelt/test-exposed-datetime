import org.jetbrains.exposed.sql.transactions.transaction
import java.time.LocalDateTime

object BaseService {
    fun touch(baseObject: BaseDAO) {
        val updatedSensor = transaction {
            val time = LocalDateTime.now()
//            if (sensor.updatedAt != time) {
                try {
                    return@transaction baseObject.apply {
                        updatedAt = time
                    }
                } catch (ex: IllegalStateException) {
                    ex.printStackTrace()
                }
//            }
            return@transaction null
        }
    }
}