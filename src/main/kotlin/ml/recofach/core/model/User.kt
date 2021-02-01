package ml.recofach.core.model

import ml.recofach.core.request.DetailsR
import ml.recofach.core.request.InterestsR
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
    var name: String?,
    var surname: String?,
    val username: String,
    var email: String?,
    val password: String,
    val interests: Set<SubjectCategory>,
    @Id val id: UUID = UUID.randomUUID()
) : Serializable {

    fun update(d: DetailsR): User {
        if (d.name.isNotEmpty()) this.name = d.name
        if (d.surname.isNotEmpty()) this.surname = d.surname
        if (d.email.isNotEmpty()) this.email = d.email
        return this
    }
}
