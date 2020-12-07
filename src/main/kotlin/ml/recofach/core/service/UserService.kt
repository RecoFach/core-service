package ml.recofach.core.service


import ml.recofach.core.model.User
import ml.recofach.core.repo.UserRepository
import ml.recofach.core.request.UserLoginRequest
import ml.recofach.core.request.UserRequest
import org.springframework.stereotype.Service


@Service
class UserService(
        val userRepository: UserRepository
) {
    fun findAllUsers(): List<User> =
            userRepository
                    .findAll()
                    .toList()


    fun createUser(u: UserRequest): User? =
            userRepository
                    .save(User(u.first_name, u.last_name, u.email, u.password.plus("pidhirrumskatpagum").reversed()))

    fun login(u: UserLoginRequest): User? {
        val user = userRepository.findUserByEmailIsLike(u.email) ?: return null

        val cryptedPassword = u.password.plus("pidhirrumskatpagum").reversed()
        user.password = ""

        if (user.password == cryptedPassword) return user
        return null
    }

}
