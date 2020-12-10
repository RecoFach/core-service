package ml.recofach.core.controller

import ml.recofach.core.model.Subject
import ml.recofach.core.request.SubjectR
import ml.recofach.core.service.SubjectService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/subjects")
class SubjectController(
    val subjectService: SubjectService
) : AbstractController() {
    @GetMapping
    fun getAllSubjects(): ResponseEntity<List<Subject>> =
        unwrap(subjectService.findAllSubjects())

    @GetMapping("/{uuid}")
    fun getSubjectById(@PathVariable uuid: UUID): ResponseEntity<Subject> =
        unwrap(subjectService.findSubjectById(uuid), fail = HttpStatus.NOT_FOUND)

    @GetMapping("/find/{name}")
    fun getSubjectsByName(@PathVariable name: String): ResponseEntity<List<Subject>> =
        unwrap(subjectService.findSubjectsByName(name))

    @PutMapping
    fun putSubject(@RequestBody s: SubjectR): ResponseEntity<Subject> =
        unwrap(subjectService.createSubject(s), success = HttpStatus.CREATED)

}
