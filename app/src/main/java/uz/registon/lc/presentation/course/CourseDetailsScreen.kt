package uz.registon.lc.presentation.course

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uz.registon.lc.core.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourseDetailsScreen(navController: NavController, courseId: String) {
    Scaffold(
        containerColor = Black,
        bottomBar = {
            EnrollBottomBar()
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .background(
                        Brush.verticalGradient(
                            listOf(Gold.copy(alpha = 0.3f), Black)
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(Icons.Default.School, contentDescription = null, tint = Gold, modifier = Modifier.size(100.dp))
                IconButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(20.dp)
                        .background(Black.copy(alpha = 0.5f), RoundedCornerShape(12.dp))
                ) {
                    Icon(Icons.Default.ArrowBack, contentDescription = null, tint = White)
                }
            }
            
            Column(modifier = Modifier.padding(25.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Surface(
                        color = Gold.copy(alpha = 0.1f),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(
                            "IELTS INTENSIVE",
                            color = Gold,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Star, contentDescription = null, tint = Gold, modifier = Modifier.size(18.dp))
                        Text(" 4.9 (120 reviews)", color = White, fontSize = 14.sp)
                    }
                }
                
                Spacer(modifier = Modifier.height(20.dp))
                
                Text(
                    "Complete IELTS Preparation Course",
                    style = MaterialTheme.typography.headlineMedium,
                    color = White,
                    fontWeight = FontWeight.Bold
                )
                
                Spacer(modifier = Modifier.height(20.dp))
                
                Text(
                    "Master all 4 sections of the IELTS exam with our certified instructors. This intensive course covers advanced strategies for Academic Writing, Reading, Listening and Speaking.",
                    color = Grey,
                    lineHeight = 24.sp
                )
                
                Spacer(modifier = Modifier.height(30.dp))
                
                CourseInfoRow()
                
                Spacer(modifier = Modifier.height(30.dp))
                
                Text("Instructor", style = MaterialTheme.typography.titleLarge, color = White)
                Spacer(modifier = Modifier.height(15.dp))
                InstructorCard()
            }
        }
    }
}

@Composable
fun CourseInfoRow() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        InfoItem(Icons.Default.Timer, "Duration", "3 Months")
        InfoItem(Icons.Default.Event, "Lessons", "36 Total")
        InfoItem(Icons.Default.Groups, "Class Size", "12 Students")
    }
}

@Composable
fun InfoItem(icon: androidx.compose.ui.graphics.vector.ImageVector, label: String, value: String) {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, contentDescription = null, tint = Gold, modifier = Modifier.size(16.dp))
            Spacer(modifier = Modifier.width(5.dp))
            Text(label, color = Grey, fontSize = 12.sp)
        }
        Text(value, color = White, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 4.dp))
    }
}

@Composable
fun InstructorCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(DarkGrey, RoundedCornerShape(20.dp))
            .padding(15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .background(Gold.copy(alpha = 0.1f), CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(Icons.Default.Person, contentDescription = null, tint = Gold)
        }
        Spacer(modifier = Modifier.width(20.dp))
        Column {
            Text("Dr. Nilufar Karimova", color = White, fontWeight = FontWeight.Bold)
            Text("Senior IELTS Instructor (8.5)", color = Gold, fontSize = 12.sp)
        }
    }
}

@Composable
fun EnrollBottomBar() {
    Surface(
        color = Black,
        border = androidx.compose.foundation.BorderStroke(1.dp, White.copy(alpha = 0.05f))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text("Price", color = Grey, fontSize = 12.sp)
                Text("600,000 UZS/mo", color = Gold, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            }
            Button(
                onClick = { },
                modifier = Modifier
                    .height(55.dp)
                    .width(160.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Gold),
                shape = RoundedCornerShape(15.dp)
            ) {
                Text("ENROLL NOW", color = Black, fontWeight = FontWeight.Bold)
            }
        }
    }
}
