package uz.registon.lc.presentation.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uz.registon.lc.core.navigation.Screen
import uz.registon.lc.core.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        bottomBar = { BottomNav(navController) },
        containerColor = Black
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
        ) {
            HomeAppBar()
            
            Column(modifier = Modifier.padding(horizontal = 20.dp)) {
                PremiumBanner()
                
                Spacer(modifier = Modifier.height(30.dp))
                
                SectionHeader("Popular Courses") { }
                Spacer(modifier = Modifier.height(15.dp))
                CourseList(navController)
                
                Spacer(modifier = Modifier.height(30.dp))
                
                SectionHeader("Our Achievements") { }
                Spacer(modifier = Modifier.height(15.dp))
                StatsGrid()
                
                Spacer(modifier = Modifier.height(30.dp))
                
                SectionHeader("Featured Teachers") { }
                Spacer(modifier = Modifier.height(15.dp))
                TeacherList()
                
                Spacer(modifier = Modifier.height(100.dp))
            }
        }
    }
}

@Composable
fun HomeAppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text("Hello, Student!", color = Grey, style = MaterialTheme.typography.labelMedium)
            Text("Registon LC", color = Gold, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
        }
        
        Box(
            modifier = Modifier
                .size(45.dp)
                .background(DarkGrey, RoundedCornerShape(12.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(Icons.Default.Notifications, contentDescription = null, tint = White)
        }
    }
}

@Composable
fun PremiumBanner() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(Brush.linearGradient(listOf(Gold, LightGold)))
    ) {
        Icon(
            Icons.Default.Star,
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)
                .align(Alignment.BottomEnd)
                .offset(x = 20.dp, y = 20.dp),
            tint = Black.copy(alpha = 0.1f)
        )
        
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(25.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                "IELTS 8.5\nINTENSIVE",
                style = MaterialTheme.typography.headlineMedium.copy(
                    color = Black,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 30.sp
                )
            )
            Spacer(modifier = Modifier.height(15.dp))
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(containerColor = Black),
                shape = RoundedCornerShape(10.dp),
                contentPadding = PaddingValues(horizontal = 20.dp)
            ) {
                Text("Enroll Now", color = Gold, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun SectionHeader(title: String, onSeeAll: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(title, color = White, style = MaterialTheme.typography.titleLarge)
        Text("See All", color = Gold, style = MaterialTheme.typography.labelMedium, modifier = Modifier.clickable { onSeeAll() })
    }
}

@Composable
fun CourseList(navController: NavController) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(15.dp)) {
        items(listOf("General English", "IELTS Intensive", "SAT Math")) { title ->
            CourseCard(title) {
                navController.navigate(Screen.CourseDetails.createRoute("1"))
            }
        }
    }
}

@Composable
fun CourseCard(title: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .width(170.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = DarkGrey),
        border = BorderStroke(1.dp, White.copy(alpha = 0.05f))
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(Gold.copy(alpha = 0.1f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(Icons.Default.Book, contentDescription = null, tint = Gold, modifier = Modifier.size(40.dp))
            }
            Column(modifier = Modifier.padding(12.dp)) {
                Text(title, color = White, fontWeight = FontWeight.Bold, maxLines = 1)
                Text("CEFR A1-C1", color = Grey, fontSize = 12.sp)
                Spacer(modifier = Modifier.height(10.dp))
                Text("450,000 UZS", color = Gold, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun StatsGrid() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(15.dp)) {
        StatCard("10K+", "Students", Modifier.weight(1f))
        StatCard("500+", "IELTS 7.0+", Modifier.weight(1f))
        StatCard("15", "Branches", Modifier.weight(1f))
    }
}

@Composable
fun StatCard(value: String, label: String, modifier: Modifier) {
    Column(
        modifier = modifier
            .background(DarkGrey, RoundedCornerShape(15.dp))
            .border(1.dp, Gold.copy(alpha = 0.2f), RoundedCornerShape(15.dp))
            .padding(vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(value, color = Gold, fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Text(label, color = Grey, fontSize = 12.sp)
    }
}

@Composable
fun TeacherList() {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
        items(5) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    modifier = Modifier
                        .size(65.dp)
                        .clip(CircleShape)
                        .background(Gold.copy(alpha = 0.1f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.Person, contentDescription = null, tint = Gold)
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text("Mr. Jasur", color = White, fontSize = 12.sp)
            }
        }
    }
}

@Composable
fun BottomNav(navController: NavController) {
    NavigationBar(
        containerColor = Black,
        contentColor = Gold,
        tonalElevation = 8.dp
    ) {
        val items = listOf(
            Triple("Home", Icons.Default.Home, Screen.Home.route),
            Triple("Courses", Icons.Default.School, Screen.Home.route),
            Triple("Cabinet", Icons.Default.Dashboard, Screen.Dashboard.route),
            Triple("Profile", Icons.Default.Person, Screen.Profile.route)
        )
        
        items.forEach { (label, icon, route) ->
            NavigationBarItem(
                icon = { Icon(icon, contentDescription = null) },
                label = { Text(label) },
                selected = false,
                onClick = { navController.navigate(route) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Gold,
                    unselectedIconColor = Grey,
                    indicatorColor = DarkGrey
                )
            )
        }
    }
}
