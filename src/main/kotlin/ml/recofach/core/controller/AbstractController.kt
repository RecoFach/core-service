package ml.recofach.core.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
abstract class AbstractController {
    fun <A> unwrap(
        a: A?,
        fail: HttpStatus = HttpStatus.BAD_REQUEST,
        success: HttpStatus = HttpStatus.OK
    ): ResponseEntity<A> =
        when (a) {
            null -> ResponseEntity(fail)
            else -> ResponseEntity(a, success)
        }
}
