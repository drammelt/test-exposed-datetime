import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database

object Database {
    lateinit var database: Database
    lateinit var hikari: HikariDataSource

    private val databaseAddress = System.getenv("DATABASE_ADDRESS") ?: "localhost"
    private val databasePassword = System.getenv("DATABASE_PASSWORD") ?: "postgres"

    fun startUp() {
        hikari = HikariDataSource(HikariConfig().apply {
            driverClassName = "org.postgresql.Driver"
            jdbcUrl = "jdbc:postgresql://${databaseAddress}:5432/postgres"
            maximumPoolSize = 5
            username = "postgres"
            password = databasePassword
            leakDetectionThreshold = 30 * 1000
        })
        database = Database.connect(hikari)
    }
}