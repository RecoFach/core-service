package ml.recofach.core.request

import java.io.Serializable

data class UserR (
    val name: String?,
    val surname: String?,
    val username: String,
    val email: String?,
    val password: String,
) : Serializable
