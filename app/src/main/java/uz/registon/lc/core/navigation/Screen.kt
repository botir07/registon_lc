package uz.registon.lc.core.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Onboarding : Screen("onboarding")
    object Login : Screen("login")
    object Register : Screen("register")
    object Home : Screen("home")
    object CourseDetails : Screen("course_details/{courseId}") {
        fun createRoute(courseId: String) = "course_details/$courseId"
    }
    object Dashboard : Screen("dashboard")
    object Test : Screen("test")
    object Profile : Screen("profile")
    object Branches : Screen("branches")
}
