package ml.recofach.core.request

open class UserLoginRequest (
    val email: String,
    val password: String
)

open class UserDeleteRequest (
        val email: String,
)

class UserRequest (
    val firstname: String,
    val lastname: String,
    val email: String,
    val password: String
)