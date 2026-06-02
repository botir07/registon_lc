package uz.registon.lc.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uz.registon.lc.core.theme.*

@Composable
fun ProfileScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Black)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))
        
        Box(contentAlignment = Alignment.BottomEnd) {
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .border(2.dp, Gold, CircleShape)
                    .padding(5.dp)
            ) {
                Icon(
                    Icons.Default.Person,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape)
                        .background(DarkGrey),
                    tint = Gold
                )
            }
            Box(
                modifier = Modifier
                    .size(35.dp)
                    .background(Gold, CircleShape)
                    .border(3.dp, Black, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(Icons.Default.Edit, contentDescription = null, tint = Black, modifier = Modifier.size(16.dp))
            }
        }
        
        Spacer(modifier = Modifier.height(20.dp))
        
        Text("Asadbek Toshmatov", color = White, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
        Text("IELTS Student • Level B2", color = Grey)
        
        Spacer(modifier = Modifier.height(40.dp))
        
        ProfileMenu()
        
        Spacer(modifier = Modifier.height(40.dp))
        
        OutlinedButton(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .height(55.dp),
            shape = RoundedCornerShape(15.dp),
            border = androidx.compose.foundation.BorderStroke(1.dp, Color.Red.copy(alpha = 0.5f))
        ) {
            Text("LOGOUT", color = Color.Red, fontWeight = FontWeight.Bold, letterSpacing = 1.2.sp)
        }
        
        Spacer(modifier = Modifier.height(50.dp))
    }
}

@Composable
fun ProfileMenu() {
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .background(DarkGrey, RoundedCornerShape(25.dp))
    ) {
        ProfileMenuItem(Icons.Outlined.Person, "Personal Information")
        ProfileMenuItem(Icons.Outlined.Language, "Language Settings", "Uzbek")
        ProfileMenuItem(Icons.Outlined.Notifications, "Notifications")
        ProfileMenuItem(Icons.Outlined.Security, "Security & Password")
        ProfileMenuItem(Icons.Outlined.DarkMode, "Dark Mode", isSwitch = true)
        ProfileMenuItem(Icons.Outlined.HelpOutline, "Support & FAQ", isLast = true)
    }
}

@Composable
fun ProfileMenuItem(
    icon: ImageVector,
    title: String,
    trailing: String? = null,
    isSwitch: Boolean = false,
    isLast: Boolean = false
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp, vertical = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(icon, contentDescription = null, tint = Gold)
            Spacer(modifier = Modifier.width(20.dp))
            Text(title, color = White, modifier = Modifier.weight(1f))
            
            if (isSwitch) {
                Switch(checked = true, onCheckedChange = { }, colors = SwitchDefaults.colors(checkedThumbColor = Gold))
            } else {
                if (trailing != null) {
                    Text(trailing, color = Grey, fontSize = 14.sp, modifier = Modifier.padding(end = 10.dp))
                }
                Icon(Icons.Default.ChevronRight, contentDescription = null, tint = Grey, modifier = Modifier.size(16.dp))
            }
        }
        if (!isLast) {
            Divider(modifier = Modifier.padding(horizontal = 25.dp), color = White.copy(alpha = 0.05f), thickness = 1.dp)
        }
    }
}
