package ml.recofach.core.repo


import ml.recofach.core.model.Subject
import ml.recofach.core.model.User
import ml.recofach.core.request.UserRequest
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : CrudRepository<User, UUID>{
    fun findUserByEmailIsLike(email: String): User?
}