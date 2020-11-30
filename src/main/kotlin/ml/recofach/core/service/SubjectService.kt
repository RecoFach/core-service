package ml.recofach.core.service

import ml.recofach.core.model.Subject
import ml.recofach.core.repo.SubjectRepository
import ml.recofach.core.request.SubjectR
import org.springframework.stereotype.Service
import java.util.*


@Service
class SubjectService(
    val subjectRepository: SubjectRepository
) {
    fun findAllSubjects(): List<Subject> =
        subjectRepository
            .findAll()
            .toList()

    fun findSubjectById(uuid: UUID): Subject? =
        subjectRepository
            .findById(uuid)
            .get()

    fun createSubject(s : SubjectR): Subject? =
        subjectRepository
            .save(Subject(s.name, s.link, s.sws, s.type, s.lang))
}