package ml.recofach.core.service

import ml.recofach.core.model.SubjectCategory
import ml.recofach.core.model.User
import ml.recofach.core.repo.UserRepository
import ml.recofach.core.request.InterestsR
import ml.recofach.core.request.UserR
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.UUID
import kotlin.collections.ArrayList

@Service
class UserService(
    val userRepository: UserRepository,
    val bCryptPasswordEncoder: BCryptPasswordEncoder
) : UserDetailsService {
    fun findAll(): List<User> =
        userRepository
            .findAll()
            .toList()

    fun find(username: String): User? =
        userRepository.findUserByUsername(username)

    fun find(id: UUID): User? =
        userRepository.findUserById(id)

    fun delete(id: UUID): User? =
        userRepository.deleteUserById(id)

    fun save(u: UserR): User? =
        if (u.username.isNotEmpty() && !userRepository.existsUserByUsername(u.username)) {
            val password: String = bCryptPasswordEncoder.encode(u.password)
            val user = User(u.name, u.surname, u.username, u.email, password, mutableSetOf())
            userRepository.save(user)
        } else null

    fun update(id: UUID, i: InterestsR): User? =
        this.find(id)?.let { user ->  this.userRepository.save(user.update(i)) }

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        val user: User = userRepository.findUserByUsername(username) ?: throw UsernameNotFoundException(username)
        return org.springframework.security.core.userdetails.User(user.username, user.password, ArrayList())
    }
}
