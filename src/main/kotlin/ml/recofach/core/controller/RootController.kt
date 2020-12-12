package ml.recofach.core.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


/**
 * Main controller for all request coming to *root / *.
 */
@RestController
@RequestMapping("/")
class RootController {

    /**
     * Controller for * /hello-world * path
     *
     * @return String "Hello World, Kotlin!"
     */
    @GetMapping("hello-world")
    fun getHelloWorld(): String = "Hello World, Kotlin!"
}
