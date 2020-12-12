package ml.recofach.core.repo

import ml.recofach.core.model.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : CrudRepository<User, UUID> {
    fun deleteUserById(id: UUID): User?
    fun findUserByUsername(username: String): User?
}