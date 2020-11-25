package ml.recofach.core.model

import java.io.Serializable

/**
 * SubjectLang.
 *
 * Defines available languages for Subject.
 * Can be English | German
 *
 * @see Subject
 */

enum class SubjectLang : Serializable {
    EN,
    DE
}