package uz.registon.lc.presentation.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uz.registon.lc.core.navigation.Screen
import uz.registon.lc.core.theme.Black
import uz.registon.lc.core.theme.DarkGrey
import uz.registon.lc.core.theme.Gold
import uz.registon.lc.core.theme.Grey

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
    var phone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Black)
            .padding(horizontal = 30.dp)
    ) {
        Spacer(modifier = Modifier.height(80.dp))
        
        Icon(
            imageVector = Icons.Default.School,
            contentDescription = null,
            tint = Gold,
            modifier = Modifier.size(60.dp)
        )
        
        Spacer(modifier = Modifier.height(30.dp))
        
        Text(
            text = "Welcome to\nRegiston LC",
            style = MaterialTheme.typography.displayLarge.copy(
                fontWeight = FontWeight.Bold,
                color = Color.White,
                lineHeight = 40.sp
            )
        )
        
        Text(
            text = "Sign in to continue your journey",
            style = MaterialTheme.typography.bodyLarge.copy(
                color = Grey
            ),
            modifier = Modifier.padding(top = 8.dp)
        )
        
        Spacer(modifier = Modifier.height(60.dp))
        
        AuthTextField(
            value = phone,
            onValueChange = { phone = it },
            label = "Phone Number",
            placeholder = "+998 90 123 45 67",
            icon = Icons.Default.PhoneAndroid
        )
        
        Spacer(modifier = Modifier.height(20.dp))
        
        AuthTextField(
            value = password,
            onValueChange = { password = it },
            label = "Password",
            placeholder = "••••••••",
            icon = Icons.Default.Lock,
            isPassword = true
        )
        
        AlignRight {
            TextButton(onClick = { }) {
                Text("Forgot Password?", color = Gold)
            }
        }
        
        Spacer(modifier = Modifier.height(40.dp))
        
        Button(
            onClick = { navController.navigate(Screen.Home.route) },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Gold),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                "SIGN IN",
                style = MaterialTheme.typography.titleLarge.copy(
                    color = Black,
                    fontWeight = FontWeight.Bold
                )
            )
        }
        
        Spacer(modifier = Modifier.weight(1f))
        
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 30.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Don't have an account? ", color = Grey)
            TextButton(onClick = { }) {
                Text("Register", color = Gold, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    isPassword: Boolean = false
) {
    Column {
        Text(
            text = label,
            color = Color.White,
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.White.copy(alpha = 0.1f), RoundedCornerShape(16.dp)),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = DarkGrey,
                unfocusedContainerColor = DarkGrey,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
            ),
            shape = RoundedCornerShape(16.dp),
            placeholder = { Text(placeholder, color = Grey.copy(alpha = 0.5f)) },
            leadingIcon = { Icon(icon, contentDescription = null, tint = Gold) },
            visualTransformation = if (isPassword) PasswordVisualTransformation() else androidx.compose.ui.text.input.VisualTransformation.None
        )
    }
}

@Composable
fun AlignRight(content: @Composable () -> Unit) {
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
        content()
    }
}
