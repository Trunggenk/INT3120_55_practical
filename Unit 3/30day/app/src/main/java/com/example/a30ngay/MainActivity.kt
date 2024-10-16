package com.example.a30ngay
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a30ngay.R
import com.example.a30ngay.ui.theme._30NgayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _30NgayTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    WellnessScreen()
                }
            }
        }
    }
}

@Composable
fun WellnessScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item { DayCard(day = "Day 1", task = "Spend 15 minutes outdoors", imageRes = R.drawable.fashion) }
        item { DayCard(day = "Day 2", task = "Listen to a new podcast or audiobook", imageRes = R.drawable.finance) }
        item { DayCard(day = "Day 3", task = "Try a new recipe", imageRes = R.drawable.film) }
        item { DayCard(day = "Day 4", task = "Meditate for 10 minutes", imageRes = R.drawable.film) }
        item { DayCard(day = "Day 5", task = "Write down 3 things you're grateful for", imageRes = R.drawable.finance) }
        item { DayCard(day = "Day 6", task = "Go for a walk", imageRes = R.drawable.fashion) }
        item { DayCard(day = "Day 7", task = "Do a 30-minute workout", imageRes = R.drawable.film) }
        item { DayCard(day = "Day 8", task = "Spend 15 minutes outdoors", imageRes = R.drawable.finance) }
        item { DayCard(day = "Day 9", task = "Listen to a new podcast or audiobook", imageRes = R.drawable.film) }
        item { DayCard(day = "Day 10", task = "Try a new recipe", imageRes = R.drawable.fashion) }
        item { DayCard(day = "Day 11", task = "Meditate for 10 minutes", imageRes = R.drawable.finance) }
        item { DayCard(day = "Day 12", task = "Write down 3 things you're grateful for", imageRes = R.drawable.film) }
        item { DayCard(day = "Day 1", task = "Spend 15 minutes outdoors", imageRes = R.drawable.fashion) }
        item { DayCard(day = "Day 2", task = "Listen to a new podcast or audiobook", imageRes = R.drawable.finance) }
        item { DayCard(day = "Day 3", task = "Try a new recipe", imageRes = R.drawable.film) }
        item { DayCard(day = "Day 4", task = "Meditate for 10 minutes", imageRes = R.drawable.film) }
        item { DayCard(day = "Day 5", task = "Write down 3 things you're grateful for", imageRes = R.drawable.finance) }
        item { DayCard(day = "Day 6", task = "Go for a walk", imageRes = R.drawable.fashion) }
        item { DayCard(day = "Day 7", task = "Do a 30-minute workout", imageRes = R.drawable.film) }
        item { DayCard(day = "Day 8", task = "Spend 15 minutes outdoors", imageRes = R.drawable.finance) }
        item { DayCard(day = "Day 9", task = "Listen to a new podcast or audiobook", imageRes = R.drawable.film) }
        item { DayCard(day = "Day 10", task = "Try a new recipe", imageRes = R.drawable.fashion) }
        item { DayCard(day = "Day 11", task = "Meditate for 10 minutes", imageRes = R.drawable.finance) }
        item { DayCard(day = "Day 12", task = "Write down 3 things you're grateful for", imageRes = R.drawable.film) }

   }
}

@Composable
fun DayCard(day: String, task: String, imageRes: Int) {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = day,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = task,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWellnessScreen() {
    _30NgayTheme {
        WellnessScreen()
    }
}
