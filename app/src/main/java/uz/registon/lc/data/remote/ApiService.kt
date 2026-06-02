package uz.registon.lc.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import uz.registon.lc.domain.model.Course

interface ApiService {
    @GET("courses")
    suspend fun getCourses(): List<Course>

    @GET("courses/{id}")
    suspend fun getCourseDetails(@Path("id") id: String): Course
}
