package com.example.danhthiep

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.danhthiep.ui.theme.DanhThiepTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DanhThiepTheme {
                BusinessCard(

                )
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Placeholder for image/logo
        Image(
            painter = painterResource(R.drawable.img),
            contentDescription = "Logo",
            modifier = Modifier.size(100.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Name and Title
        Text(
            text = "Your Name",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3ddc84) // Custom Android Green
        )
        Text(text = "Your Job Title", fontSize = 18.sp, color = Color.Gray)

        Spacer(modifier = Modifier.height(32.dp))

        // Contact Information
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.Phone,
                contentDescription = "Phone",
                tint = Color(0xFF3ddc84)
            )
            Text(text = "+123 456 789", modifier = Modifier.padding(start = 8.dp))
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "Email",
                tint = Color(0xFF3ddc84)
            )
            Text(text = "youremail@example.com", modifier = Modifier.padding(start = 8.dp))
        }
    }
}

