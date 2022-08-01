import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.EntityID

class BaseDAO(id: EntityID<Long>): Entity<Long>(id) {
    var deleted by BaseRepo.deleted
    val createdAt by BaseRepo.createdAt
    var updatedAt by BaseRepo.updatedAt

    companion object: EntityClass<Long, BaseDAO>(BaseRepo)
}