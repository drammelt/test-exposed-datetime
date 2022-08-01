import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeout
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.concurrent.Executors
import kotlin.coroutines.CoroutineContext
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

object Processor: CoroutineScope {
    private val dispatcher = Executors.newFixedThreadPool(128).asCoroutineDispatcher()
    override val coroutineContext: CoroutineContext
        get() = dispatcher

    fun process() {
        val cache = transaction { BaseDAO.all().firstOrNull() }
        val duration = 30L.seconds
        val time = cache?.updatedAt

        cache?.let { baseObject ->
            while(true) {
                launch {
                    withTimeout(timeout = duration) {
                        println("Update input1")
                        BaseService.touch(baseObject = baseObject)
                    }
                }

                launch {
                    withTimeout(timeout = duration) {
                        println("Update input2")
                        BaseService.touch(baseObject = baseObject)
                    }
                }
            }
        }
    }
}