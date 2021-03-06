package ml.recofach.core.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.UUID

/**
 * Subject model.
 *
 * Stores all needed information about specific subject.
 *
 * @constructor Creates a Subject object
 * @param name contains a name for this Subject
 * @param link contains a URL for this subject
 * @param sws contains amount sws for this subject
 * @param lang indicates the language of this subject
 * @param type indicates the type of this subject
 *
 * @see SubjectType
 * @see SubjectLang
 */

@Document
data class Subject(
    val name: String,
    val link: String,
    val sws: Int,
    val type: SubjectType,
    val lang: SubjectLang,
    val categories: List<SubjectCategory>,
    @Id val id: UUID = UUID.randomUUID()
)
