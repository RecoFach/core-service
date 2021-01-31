package ml.recofach.core.request

import ml.recofach.core.model.SubjectCategory

data class InterestsR(val interests: Set<SubjectCategory>)