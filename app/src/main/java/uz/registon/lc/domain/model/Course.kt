package uz.registon.lc.domain.model

data class Course(
    val id: String,
    val title: String,
    val description: String,
    val price: String,
    val duration: String,
    val level: String,
    val rating: Double,
    val instructorName: String
)
