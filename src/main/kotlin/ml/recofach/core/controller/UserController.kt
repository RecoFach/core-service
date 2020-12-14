package ml.recofach.core.controller

import ml.recofach.core.model.User
import ml.recofach.core.request.UserR
import ml.recofach.core.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/users")
class UserController(
    val userService: UserService
) : AbstractController() {

    @GetMapping
    fun getAllUser(): ResponseEntity<List<User>> =
        unwrap(userService.findAll())

    @PutMapping("/signup")
    fun signUp(@RequestBody user: UserR): ResponseEntity<User> =
        unwrap(userService.save(user))

    @GetMapping("/{id}")
    fun findUser(@PathVariable id: UUID): ResponseEntity<User> =
        unwrap(userService.find(id), fail = HttpStatus.NOT_FOUND)

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: UUID): ResponseEntity<User> =
        unwrap(userService.delete(id), fail = HttpStatus.NOT_FOUND)
}
