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
    var interests: MutableSet<SubjectCategory>,
    @Id val id: UUID = UUID.randomUUID()
) : Serializable {
    fun update(i: InterestsR): User {
        this.interests.clear()
        this.interests.addAll(i.interests)
        return this
    }

    fun update(d: DetailsR): User {
        this.name = d.name
        this.surname = d.surname
        this.email = d.email
        return this
    }
}
