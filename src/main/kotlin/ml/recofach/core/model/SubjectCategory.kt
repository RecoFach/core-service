package ml.recofach.core.model

/**
 * SubjectType.
 *
 * Defines which type is this Subject.
 * Can be  Komplexpraktikum (Praxis)
 *        | Software engineering (Software)
 *        | AI
 *        | Low-Level (LowLevel)
 *        | Security
 *        | Web
 *        | Theoretical
 *
 * @see Subject
 */

enum class SubjectCategory {
    AI,
    LOWLEVEL,
    SECURITY,
    SOFTWARE,
    THEORETICAL,
    WEB
}