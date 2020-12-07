package ml.recofach.core.request

open class UserLoginRequest (
    val email: String,
    val password: String
)

class UserRequest (
    val first_name: String,
    val last_name: String,
    val email: String,
    val password: String
)