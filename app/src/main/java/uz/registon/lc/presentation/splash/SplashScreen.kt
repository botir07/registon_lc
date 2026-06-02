package uz.registon.lc.presentation.splash

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import uz.registon.lc.core.navigation.Screen
import uz.registon.lc.core.theme.Gold

@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember { Animatable(0f) }
    val alpha = remember { Animatable(0f) }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 1000, easing = OvershootInterpolator(2f).let { 
                Easing { fraction -> it.getInterpolation(fraction) } 
            })
        )
        alpha.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 1000)
        )
        delay(2000)
        navController.navigate(Screen.Onboarding.route) {
            popUpTo(Screen.Splash.route) { inclusive = true }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.scale(scale.value).alpha(alpha.value)
        ) {
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .border(2.dp, Gold, CircleShape)
                    .padding(20.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.School,
                    contentDescription = "Logo",
                    tint = Gold,
                    modifier = Modifier.size(60.dp)
                )
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            Text(
                text = "REGISTON",
                style = MaterialTheme.typography.displayLarge.copy(
                    color = Gold,
                    letterSpacing = 8.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            
            Text(
                text = "LEARNING CENTER",
                style = MaterialTheme.typography.labelMedium.copy(
                    color = Color.White.copy(alpha = 0.6f),
                    letterSpacing = 4.sp
                )
            )
        }
    }
}

// Simple OvershootInterpolator wrapper for Compose Easing
private class OvershootInterpolator(private val tension: Float) {
    fun getInterpolation(t: Float): Float {
        var time = t
        time -= 1.0f
        return time * time * ((tension + 1) * time + tension) + 1.0f
    }
}
