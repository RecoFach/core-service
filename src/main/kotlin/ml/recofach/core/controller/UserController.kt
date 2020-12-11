package ml.recofach.core.controller

import ml.recofach.core.model.User
import ml.recofach.core.request.UserDeleteRequest
import ml.recofach.core.request.UserR
import ml.recofach.core.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(
        val userService: UserService
) : AbstractController() {

    @GetMapping
    fun getAllUser(): ResponseEntity<List<User>> =
            unwrap(userService.findAllUsers())

    @PostMapping
    fun signUp(@RequestBody user: UserR) =
        userService.save(user)

//    @CrossOrigin(origins = arrayOf("http://localhost:8081"))
//    @PutMapping
//    fun putUser(@RequestBody u: UserRequest): ResponseEntity<User> =
//            unwrap(userService.createUser(u), success = HttpStatus.CREATED)

//    @CrossOrigin(origins = ["http://localhost:8081"])
//    @PostMapping
//    fun login(@RequestBody u: UserLoginRequest): ResponseEntity<User> =
//            unwrap(userService.login(u), fail = HttpStatus.NOT_FOUND)

    @CrossOrigin(origins = arrayOf("http://localhost:8081"))
    @DeleteMapping
    fun deleteUser(@RequestBody u: UserDeleteRequest): ResponseEntity<User> =
            unwrap(userService.deleteUser(u), fail = HttpStatus.NOT_FOUND)
}