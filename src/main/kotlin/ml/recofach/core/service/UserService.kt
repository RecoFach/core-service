package ml.recofach.core.service

import ml.recofach.core.model.User
import ml.recofach.core.repo.UserRepository
import ml.recofach.core.request.UserDeleteRequest
import ml.recofach.core.request.UserR
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service


@Service
class UserService(
        val userRepository: UserRepository,
        val bCryptPasswordEncoder: BCryptPasswordEncoder
) {
    fun findAllUsers(): List<User> =
            userRepository
                    .findAll()
                    .toList()

//
//    fun createUser(u: UserRequest): User? =
//            userRepository
//                    .save(User(u.firstname, u.lastname, u.email, u.password.plus("pidhirrumskatpagum").reversed()))

//    fun login(u: UserLoginRequest): User? {
//        val user = userRepository.findUserByEmailIsLike(u.email) ?: return null
//
//        val cryptedPassword = u.password.plus("pidhirrumskatpagum").reversed()
//
//        if (user.password == cryptedPassword) {
//            user.password = ""
//            return user
//        }
//        return null
//    }

    fun deleteUser(u: UserDeleteRequest): User? =
            userRepository
                    .deleteUserByEmailIsLike(u.email)

    fun save(u: UserR): User {
        val password: String = bCryptPasswordEncoder.encode(u.password)
        val user = User(u.name, u.surname,u.username, u.email, password)
        return userRepository.save(user)
    }
}
