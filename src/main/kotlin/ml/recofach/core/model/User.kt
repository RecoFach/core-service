package ml.recofach.core.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.io.Serializable
import java.util.UUID

/**
 * User model.
 *
 * Stores all needed information about specific user.
 *
 * @constructor Creates a User object
 * @param name contains the first name of the User
 * @param surname contains the surname of the user
 * @param email contains email of the User
 * @param password contains the password of the User
 *
 */
@Document
data class User(
    val name: String?,
    val surname: String?,
    val username: String,
    val email: String,
    val password: String,
    @Id val id: UUID = UUID.randomUUID()
) : Serializable
