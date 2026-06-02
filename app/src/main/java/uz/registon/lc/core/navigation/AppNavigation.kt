package uz.registon.lc.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import uz.registon.lc.presentation.splash.SplashScreen
import uz.registon.lc.presentation.onboarding.OnboardingScreen
import uz.registon.lc.presentation.auth.LoginScreen
import uz.registon.lc.presentation.home.HomeScreen
import uz.registon.lc.presentation.course.CourseDetailsScreen
import uz.registon.lc.presentation.dashboard.DashboardScreen
import uz.registon.lc.presentation.profile.ProfileScreen
import uz.registon.lc.presentation.branches.BranchesScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(navController)
        }
        composable(Screen.Onboarding.route) {
            OnboardingScreen(navController)
        }
        composable(Screen.Login.route) {
            LoginScreen(navController)
        }
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(Screen.CourseDetails.route) { backStackEntry ->
            val courseId = backStackEntry.arguments?.getString("courseId") ?: ""
            CourseDetailsScreen(navController, courseId)
        }
        composable(Screen.Dashboard.route) {
            DashboardScreen(navController)
        }
        composable(Screen.Profile.route) {
            ProfileScreen(navController)
        }
        composable(Screen.Branches.route) {
            BranchesScreen(navController)
        }
    }
}
