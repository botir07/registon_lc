package uz.registon.lc.presentation.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uz.registon.lc.core.theme.*

@Composable
fun DashboardScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Black)
            .padding(horizontal = 20.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(60.dp))
        Text(
            "Student Dashboard",
            style = MaterialTheme.typography.displayLarge.copy(color = White, fontWeight = FontWeight.Bold)
        )
        Text("Track your progress and activities", color = Grey)
        
        Spacer(modifier = Modifier.height(30.dp))
        
        BalanceCard()
        
        Spacer(modifier = Modifier.height(30.dp))
        
        Text("Learning Progress", style = MaterialTheme.typography.titleLarge, color = White)
        Spacer(modifier = Modifier.height(15.dp))
        ProgressGrid()
        
        Spacer(modifier = Modifier.height(30.dp))
        
        Text("Upcoming Lessons", style = MaterialTheme.typography.titleLarge, color = White)
        Spacer(modifier = Modifier.height(15.dp))
        LessonSchedule()
        
        Spacer(modifier = Modifier.height(100.dp))
    }
}

@Composable
fun BalanceCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(25.dp))
            .background(Brush.linearGradient(listOf(DarkGrey, Black)))
            .border(1.dp, Gold.copy(alpha = 0.3f), RoundedCornerShape(25.dp))
            .padding(25.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text("Current Balance", color = Grey, fontSize = 14.sp)
                    Text("1,250,000 UZS", color = Gold, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
                }
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(Gold.copy(alpha = 0.1f), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.AccountBalanceWallet, contentDescription = null, tint = Gold)
                }
            }
            
            Spacer(modifier = Modifier.height(20.dp))
            Divider(color = White.copy(alpha = 0.1f))
            Spacer(modifier = Modifier.height(20.dp))
            
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                MiniStat("Attendance", "95%")
                MiniStat("Homework", "12/15")
                MiniStat("Rank", "#4")
            }
        }
    }
}

@Composable
fun MiniStat(label: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(value, color = White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Text(label, color = Grey, fontSize = 12.sp)
    }
}

@Composable
fun ProgressGrid() {
    Column(verticalArrangement = Arrangement.spacedBy(15.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(15.dp)) {
            ProgressItem("Reading", "7.5", Icons.Default.MenuBook, Modifier.weight(1f))
            ProgressItem("Listening", "8.0", Icons.Default.Headset, Modifier.weight(1f))
        }
        Row(horizontalArrangement = Arrangement.spacedBy(15.dp)) {
            ProgressItem("Writing", "6.5", Icons.Default.EditNote, Modifier.weight(1f))
            ProgressItem("Speaking", "7.0", Icons.Default.RecordVoiceOver, Modifier.weight(1f))
        }
    }
}

@Composable
fun ProgressItem(title: String, score: String, icon: ImageVector, modifier: Modifier) {
    Row(
        modifier = modifier
            .background(DarkGrey, RoundedCornerShape(15.dp))
            .padding(15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(icon, contentDescription = null, tint = Gold, modifier = Modifier.size(24.dp))
        Spacer(modifier = Modifier.width(15.dp))
        Column {
            Text(title, color = Grey, fontSize = 12.sp)
            Text(score, color = Gold, fontWeight = FontWeight.Bold, fontSize = 18.sp)
        }
    }
}

@Composable
fun LessonSchedule() {
    repeat(2) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
                .background(DarkGrey, RoundedCornerShape(15.dp))
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(Black, RoundedCornerShape(10.dp)),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("14", color = Gold, fontWeight = FontWeight.Bold)
                    Text("OCT", color = Grey, fontSize = 10.sp)
                }
            }
            Spacer(modifier = Modifier.width(20.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text("IELTS Intensive - Room 402", color = White, fontWeight = FontWeight.Bold)
                Text("14:00 - 16:30 • Mr. Jasur", color = Grey, fontSize = 12.sp)
            }
            Icon(Icons.Default.ChevronRight, contentDescription = null, tint = Grey)
        }
    }
}

private fun Modifier.clip(shape: RoundedCornerShape): Modifier = this.then(Modifier.clip(shape))
