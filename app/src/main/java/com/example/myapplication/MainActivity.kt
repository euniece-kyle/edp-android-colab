package com.example.myapplication

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
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
import com.example.myapplication.ui.theme.MyApplicationTheme

object BrandPalette {
    val ScreenBackground = Color(0xFFFFF5F5) 
    val CardBackground = Color(0xFFFFFFFF)
    val PrimaryAccent = Color(0xFFE57373) 
    val TextPrimary = Color(0xFF1A1A1A)
    val TextSecondary = Color(0xFF666666)
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        BusinessCard()
                    }
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    val isDark = isSystemInDarkTheme()
    val bgColor = if (isDark) Color.Black else BrandPalette.ScreenBackground
    val appleOpacity = if (isDark) 0.2f else 0.1f

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(bgColor)
    ) {
        
        Box(modifier = Modifier.fillMaxSize()) {
            Text("🍎", modifier = Modifier.align(Alignment.TopStart).padding(40.dp).graphicsLayer(alpha = appleOpacity), fontSize = 60.sp)
            Text("🍎", modifier = Modifier.align(Alignment.TopEnd).padding(80.dp).graphicsLayer(alpha = appleOpacity), fontSize = 40.sp)
            Text("🍎", modifier = Modifier.align(Alignment.BottomStart).padding(60.dp).graphicsLayer(alpha = appleOpacity), fontSize = 50.sp)
            Text("🍎", modifier = Modifier.align(Alignment.BottomEnd).padding(30.dp).graphicsLayer(alpha = appleOpacity), fontSize = 70.sp)
            Text("🍎", modifier = Modifier.align(Alignment.CenterStart).padding(start = 20.dp, top = 100.dp).graphicsLayer(alpha = appleOpacity), fontSize = 35.sp)
            Text("🍎", modifier = Modifier.align(Alignment.CenterEnd).padding(end = 50.dp, bottom = 150.dp).graphicsLayer(alpha = appleOpacity), fontSize = 45.sp)
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = BrandPalette.CardBackground),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(28.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Step 3: Circular Avatar (Image)
                    Image(
                        painter = painterResource(id = R.drawable.project_photo),
                        contentDescription = "Profile Photo",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(110.dp)
                            .clip(CircleShape)
                            .border(3.dp, BrandPalette.PrimaryAccent.copy(alpha = 0.3f), CircleShape)
                    )



                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "Euniece Kyle P. Puerto",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = BrandPalette.TextPrimary
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "Student Game Developer",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = BrandPalette.TextSecondary
                    )

                    Spacer(modifier = Modifier.height(24.dp))
                    HorizontalDivider(color = Color(0xFFE5E5E5), thickness = 1.dp)
                    Spacer(modifier = Modifier.height(16.dp))

                    ContactRow(
                        icon = Icons.Default.Phone,
                        text = "+63 (912) 345-6767",
                        label = "Call phone number"
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    ContactRow(
                        icon = Icons.Default.Email,
                        text = "ekpuerto89843@liceo.edu.ph",
                        label = "Send an email"
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    ContactRow(
                        icon = Icons.Default.Share,
                        text = "github.com/euniece-puerto",
                        label = "Open GitHub profile"
                    )
                }
            }
        }
    }
}

@Composable
fun ContactRow(
    icon: ImageVector,
    text: String,
    label: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .clickable(onClickLabel = label) { /* Action stub */ }
            .padding(vertical = 12.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = BrandPalette.PrimaryAccent,
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = text,
            fontSize = 15.sp,
            color = BrandPalette.TextPrimary
        )
    }
}

@Preview(showBackground = true, name = "1. Light Mode (Default)")
@Composable
fun BusinessCardLightPreview() {
    MyApplicationTheme {
        BusinessCard()
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "2. Dark Mode Check")
@Composable
fun BusinessCardDarkPreview() {
    MyApplicationTheme {
        BusinessCard()
    }
}

@Preview(showBackground = true, fontScale = 1.5f, name = "3. Accessibility Font Scale 150%")
@Composable
fun BusinessCardFontScalePreview() {
    MyApplicationTheme {
        BusinessCard()
    }
}
