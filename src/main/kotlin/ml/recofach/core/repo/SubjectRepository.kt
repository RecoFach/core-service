package ml.recofach.core.repo

import ml.recofach.core.model.Subject
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface SubjectRepository : CrudRepository<Subject, UUID> {
    fun findSubjectsByNameIsLike(name: String): List<Subject>
}