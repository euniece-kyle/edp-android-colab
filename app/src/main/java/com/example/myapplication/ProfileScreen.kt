package com.example.myapplication

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.ProfileTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    val isDark = isSystemInDarkTheme()
    val textColor = if (isDark) Color.White else Color.Black
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My Profile", style = MaterialTheme.typography.titleLarge, color = textColor) },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu", tint = if (isDark) Color.White else LocalContentColor.current)
                    }
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.MoreVert, contentDescription = "More options", tint = if (isDark) Color.White else LocalContentColor.current)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            val appleOpacity = if (isDark) 0.2f else 0.1f

            Box(modifier = Modifier.fillMaxSize()) {
                val dotColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f)
                Box(modifier = Modifier.size(150.dp).offset(x = (-50).dp, y = (-20).dp).clip(CircleShape).background(dotColor))
                Box(modifier = Modifier.size(100.dp).align(Alignment.TopEnd).offset(x = 30.dp, y = 150.dp).clip(CircleShape).background(dotColor))
                Box(modifier = Modifier.size(200.dp).align(Alignment.BottomStart).offset(x = (-80).dp, y = 50.dp).clip(CircleShape).background(dotColor))
                Box(modifier = Modifier.size(120.dp).align(Alignment.BottomEnd).offset(x = 40.dp, y = (-100).dp).clip(CircleShape).background(dotColor))
                Box(modifier = Modifier.size(80.dp).align(Alignment.Center).offset(x = 120.dp, y = (-250).dp).clip(CircleShape).background(dotColor))


                Text("💖", modifier = Modifier.align(Alignment.TopStart).padding(40.dp).graphicsLayer(alpha = appleOpacity), fontSize = 60.sp)
                Text("🍎", modifier = Modifier.align(Alignment.TopEnd).padding(80.dp).graphicsLayer(alpha = appleOpacity), fontSize = 40.sp)
                Text("🖋", modifier = Modifier.align(Alignment.BottomStart).padding(60.dp).graphicsLayer(alpha = appleOpacity), fontSize = 50.sp)
                Text("🍎", modifier = Modifier.align(Alignment.BottomEnd).padding(30.dp).graphicsLayer(alpha = appleOpacity), fontSize = 70.sp)
                Text("🍎", modifier = Modifier.align(Alignment.CenterStart).padding(start = 20.dp, top = 100.dp).graphicsLayer(alpha = appleOpacity), fontSize = 35.sp)
                Text("💗", modifier = Modifier.align(Alignment.CenterEnd).padding(end = 50.dp, bottom = 150.dp).graphicsLayer(alpha = appleOpacity), fontSize = 45.sp)
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                Box(
                    modifier = Modifier
                        .size(120.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.project_photo),
                        contentDescription = "Avatar",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(CircleShape)
                            .border(4.dp, MaterialTheme.colorScheme.primary, CircleShape)
                    )
                    Badge(
                        modifier = Modifier
                            .size(28.dp)
                            .align(Alignment.BottomEnd)
                            .border(3.dp, MaterialTheme.colorScheme.surface, CircleShape),
                        containerColor = Color(0xFF4CAF50)
                    )
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Euniece Kyle P. Puerto",
                        style = MaterialTheme.typography.headlineSmall,
                        color = textColor
                    )
                    Text(
                        text = "Android Developer",
                        style = MaterialTheme.typography.bodyMedium,
                        color = if (isDark) Color.White.copy(alpha = 0.7f) else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = { },
                        modifier = Modifier.weight(1f),
                        shape = ButtonDefaults.shape // default small
                    ) {
                        Text("Message")
                    }
                    OutlinedButton(
                        onClick = { },
                        modifier = Modifier.weight(1f),
                        shape = ButtonDefaults.shape
                    ) {
                        Text("Follow", color = if (isDark) Color.White else MaterialTheme.colorScheme.primary)
                    }
                }

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        StatItem("128", "Posts", textColor)
                        StatItem("4.2k", "Followers", textColor)
                        StatItem("96", "Following", textColor)
                    }
                }

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        ContactInfoRow(Icons.Default.Email, "ekpuerto89843@liceo.edu.ph", textColor)
                        Spacer(modifier = Modifier.height(12.dp))
                        ContactInfoRow(Icons.Default.LocationOn, "Philippines, Cagayan de Oro City", textColor)
                    }
                }
            }
        }
    }
}

@Composable
fun StatItem(count: String, label: String, textColor: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = count, fontWeight = FontWeight.Bold, color = textColor)
        Text(text = label, style = MaterialTheme.typography.bodyMedium, color = if (isSystemInDarkTheme()) Color.White.copy(alpha = 0.7f) else MaterialTheme.colorScheme.onSurfaceVariant)
    }
}

@Composable
fun ContactInfoRow(icon: ImageVector, text: String, textColor: Color) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = if (isSystemInDarkTheme()) Color.White else MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text, style = MaterialTheme.typography.bodyLarge, color = textColor)
    }
}

@Preview(showBackground = true, name = "Light Mode")
@Composable
fun ProfileScreenLightPreview() {
    ProfileTheme(darkTheme = false) {
        ProfileScreen()
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark Mode")
@Composable
fun ProfileScreenDarkPreview() {
    ProfileTheme(darkTheme = true) {
        ProfileScreen()
    }
}
