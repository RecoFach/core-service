package ml.recofach.core.request

open class UserLoginRequest (
    val email: String,
    val password: String
)

class UserRequest (
    val firstname: String,
    val lastname: String,
    val email: String,
    val password: String
)