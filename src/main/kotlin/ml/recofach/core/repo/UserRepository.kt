package ml.recofach.core.repo

import ml.recofach.core.model.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : CrudRepository<User, UUID> {
    fun findUserById(id: UUID): User?
    fun findUserByUsername(username: String): User?
    fun existsUserById(id: UUID): Boolean
    fun existsUserByUsername(username: String): Boolean
    fun deleteUserById(id: UUID): User?
}
