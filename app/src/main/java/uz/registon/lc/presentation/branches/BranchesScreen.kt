package uz.registon.lc.presentation.branches

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Directions
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uz.registon.lc.core.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BranchesScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Our Branches", color = Gold, fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Black)
            )
        },
        containerColor = Black
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 20.dp)
        ) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .background(DarkGrey, RoundedCornerShape(20.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Map View Placeholder", color = Grey)
                    Icon(Icons.Default.LocationOn, contentDescription = null, tint = Gold, modifier = Modifier.size(40.dp))
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
            
            items(listOf("Registon Grand", "Registon Chilanzar", "Registon Yunusabad")) { branch ->
                BranchCard(branch)
                Spacer(modifier = Modifier.height(15.dp))
            }
        }
    }
}

@Composable
fun BranchCard(name: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = DarkGrey),
        shape = RoundedCornerShape(20.dp)
    ) {
        Row(
            modifier = Modifier.padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(name, color = Gold, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text("Tashkent, Uzbekistan", color = Grey, fontSize = 12.sp)
                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    IconButton(onClick = { }) { Icon(Icons.Default.Call, contentDescription = null, tint = Gold) }
                    IconButton(onClick = { }) { Icon(Icons.Default.Directions, contentDescription = null, tint = Gold) }
                }
            }
            Icon(Icons.Default.LocationOn, contentDescription = null, tint = Gold.copy(alpha = 0.3f), modifier = Modifier.size(50.dp))
        }
    }
}
