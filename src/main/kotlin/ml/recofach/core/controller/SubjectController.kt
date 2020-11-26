package ml.recofach.core.controller

import ml.recofach.core.model.Subject
import ml.recofach.core.request.SubjectR
import ml.recofach.core.service.SubjectService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/subjects")
class SubjectController (
    val subjectService: SubjectService
) {
    @GetMapping
    fun getAllSubjects(): ResponseEntity<List<Subject>> =
        ResponseEntity(subjectService.findAllSubjects(), HttpStatus.OK)

    @PutMapping
    fun putSubject(@RequestBody s : SubjectR): ResponseEntity<Subject> =
        subjectService.createSubject(s)
            ?.let { subject -> ResponseEntity(subject, HttpStatus.OK) }
            ?: ResponseEntity(HttpStatus.BAD_REQUEST)
}
