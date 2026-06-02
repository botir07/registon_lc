package uz.registon.lc.domain.repository

import uz.registon.lc.domain.model.Course

interface CourseRepository {
    suspend fun getCourses(): List<Course>
    suspend fun getCourseById(id: String): Course
}
