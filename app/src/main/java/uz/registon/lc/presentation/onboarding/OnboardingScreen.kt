package uz.registon.lc.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoStories
import androidx.compose.material.icons.filled.Devices
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import uz.registon.lc.core.navigation.Screen
import uz.registon.lc.core.theme.Black
import uz.registon.lc.core.theme.Gold
import uz.registon.lc.core.theme.Grey
import uz.registon.lc.core.theme.LightGold

data class OnboardingPage(
    val title: String,
    val description: String,
    val icon: ImageVector
)

val pages = listOf(
    OnboardingPage(
        "IELTS Preparation",
        "Master the IELTS exam with our premium curriculum and expert instructors from across the world.",
        Icons.Default.AutoStories
    ),
    OnboardingPage(
        "Modern Education",
        "Experience a blend of traditional excellence and modern learning technologies in our branches.",
        Icons.Default.Devices
    ),
    OnboardingPage(
        "Student Success",
        "Join thousands of successful students who achieved their dreams with Registon Learning Center.",
        Icons.Default.EmojiEvents
    )
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(navController: NavController) {
    val pagerState = rememberPagerState(pageCount = { pages.size })
    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Black)
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { position ->
            OnboardingPageUI(pages[position])
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 50.dp, start = 30.dp, end = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                Modifier
                    .height(50.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(pages.size) { iteration ->
                    val color = if (pagerState.currentPage == iteration) Gold else Grey
                    Box(
                        modifier = Modifier
                            .padding(4.dp)
                            .clip(CircleShape)
                            .background(color)
                            .size(if (pagerState.currentPage == iteration) 12.dp else 8.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = {
                    if (pagerState.currentPage < pages.size - 1) {
                        scope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    } else {
                        navController.navigate(Screen.Login.route)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Gold),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    text = if (pagerState.currentPage == pages.size - 1) "GET STARTED" else "NEXT",
                    style = MaterialTheme.typography.titleLarge.copy(
                        color = Black,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.sp
                    )
                )
            }
            
            TextButton(
                onClick = { navController.navigate(Screen.Login.route) },
                modifier = Modifier.padding(top = 10.dp)
            ) {
                Text("SKIP", color = Grey)
            }
        }
    }
}

@Composable
fun OnboardingPageUI(page: OnboardingPage) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(
                    Brush.radialGradient(
                        colors = listOf(Gold.copy(alpha = 0.2f), Color.Transparent)
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = page.icon,
                contentDescription = null,
                tint = Gold,
                modifier = Modifier.size(120.dp)
            )
        }

        Spacer(modifier = Modifier.height(60.dp))

        Text(
            text = page.title.uppercase(),
            style = MaterialTheme.typography.headlineMedium.copy(
                color = Color.White,
                fontWeight = FontWeight.Bold,
                letterSpacing = 2.sp
            ),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = page.description,
            style = MaterialTheme.typography.bodyLarge.copy(
                color = Color.White.copy(alpha = 0.6f),
                lineHeight = 24.sp
            ),
            textAlign = TextAlign.Center
        )
    }
}
