package ml.recofach.core.controller;

import ml.recofach.core.model.Subject
import ml.recofach.core.model.SubjectLang
import ml.recofach.core.model.SubjectType
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/subjects")
class SubjectController {

    @GetMapping
    fun getSubject(): ResponseEntity<Subject> =
        ResponseEntity(Subject("Test", "google.com" ,3, SubjectType.SECURITY, SubjectLang.DE), HttpStatus.CREATED)

}
