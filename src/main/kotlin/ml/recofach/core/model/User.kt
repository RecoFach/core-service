package ml.recofach.core.model

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.io.Serializable
import java.util.*

/**
 * Subject model.
 *
 * Stores all needed information about specific subject.
 *
 * @constructor Creates a Subject object
 * @param first_name contains the first name of the User
 * @param last_name contains the last name of the user
 * @param email contains email of the User
 * @param password contains the password of the User
 *
 */

@Document
data class User(
        val firstname: String,
        val lastname: String,
        val email: String,
        var password: String,
        @Id val id: UUID = UUID.randomUUID()

)


