package ml.recofach.core.model

import org.springframework.data.mongodb.core.mapping.Document
import java.io.Serializable

/**
 * SubjectType.
 *
 * Defines which type is this Subject.
 * Can be  Komplexpraktikum (Praxis)
 *        | Seminar
 *        | Vorlesung (Lecture)
 *        | Software engineering (Software)
 *        | AI
 *        | Low-Level (LowLevel)
 *        | Security
 *        | Web
 *        | Theoretical
 *
 * @see Subject
 */

enum class SubjectType {
    SEMINAR,
    LECTURE,
    SOFTWARE,
    AI,
    LOWLEVEL,
    SECURITY,
    WEB,
    THEORETICAL
}