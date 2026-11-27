package com.example.bhajansagar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                BhajanScreen()
            }
        }
    }
}

@Composable
fun BhajanScreen() {
    val bhajans = listOf("Achyutam Keshavam", "Hanuman Chalisa", "Vaishnav Jan To", "Om Jai Jagdish", "Shiv Tandav")
    val gradient = Brush.verticalGradient(colors = listOf(Color(0xFFFF8C00), Color(0xFFFF4500)))

    Column(modifier = Modifier.fillMaxSize().background(Color(0xFFF9F9F9))) {
        Box(modifier = Modifier.fillMaxWidth().background(gradient).padding(24.dp)) {
            Column {
                Text("Bhajan Sagar", fontSize = 32.sp, fontWeight = FontWeight.Bold, color = Color.White)
                Text("Peaceful Devotional Songs", fontSize = 16.sp, color = Color.White.copy(alpha = 0.8f))
            }
        }
        LazyColumn(modifier = Modifier.padding(16.dp)) {
            items(bhajans) { bhajan ->
                Card(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Filled.PlayArrow, contentDescription = null, tint = Color(0xFFFF4500), modifier = Modifier.size(32.dp))
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(text = bhajan, fontSize = 18.sp, fontWeight = FontWeight.Medium)
                    }
                }
            }
        }
    }
}
