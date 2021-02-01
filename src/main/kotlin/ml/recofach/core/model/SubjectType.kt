package ml.recofach.core.model

/**
 * SubjectType.
 *
 * Defines which type is this Subject.
 * Can be  Komplexpraktikum (Praxis)
 *        | Seminar
 *        | Vorlesung (Lecture)
 *
 * @see Subject
 */

enum class SubjectType {
    SEMINAR,
    LECTURE,
    PRAXIS
}