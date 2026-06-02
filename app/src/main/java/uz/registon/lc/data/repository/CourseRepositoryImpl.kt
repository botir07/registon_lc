package uz.registon.lc.data.repository

import uz.registon.lc.data.remote.ApiService
import uz.registon.lc.domain.model.Course
import uz.registon.lc.domain.repository.CourseRepository

class CourseRepositoryImpl(
    private val apiService: ApiService
) : CourseRepository {
    override suspend fun getCourses(): List<Course> {
        return apiService.getCourses()
    }

    override suspend fun getCourseById(id: String): Course {
        return apiService.getCourseDetails(id)
    }
}
