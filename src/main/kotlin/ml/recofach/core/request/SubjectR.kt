package ml.recofach.core.request

import ml.recofach.core.model.SubjectCategory
import ml.recofach.core.model.SubjectLang
import ml.recofach.core.model.SubjectType

class SubjectR(
    val name: String,
    val link: String,
    val sws: Int,
    val type: SubjectType,
    val lang: SubjectLang,
    val categories: List<SubjectCategory>
)