package ml.recofach.core.controller



import ml.recofach.core.model.Subject
import ml.recofach.core.model.User
import ml.recofach.core.request.SubjectR
import ml.recofach.core.request.UserLoginRequest
import ml.recofach.core.request.UserRequest
import ml.recofach.core.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/users")
class UserController(
        val userService: UserService
) : AbstractController() {
    @GetMapping
    fun getAllUser(): ResponseEntity<List<User>> =
            unwrap(userService.findAllUsers())

    @CrossOrigin(origins = arrayOf("http://localhost:8081"))
    @PutMapping
    fun putUser(@RequestBody u: UserRequest): ResponseEntity<User> =
            unwrap(userService.createUser(u), success = HttpStatus.CREATED)

    @CrossOrigin(origins = arrayOf("http://localhost:8081"))
    @PostMapping
    fun login(@RequestBody u: UserLoginRequest): ResponseEntity<User> =
            unwrap(userService.login(u), success = HttpStatus.OK, fail = HttpStatus.NOT_FOUND)
}