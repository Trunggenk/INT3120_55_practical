package com.example.mycity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mycity.ui.theme.MycityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MycityTheme {
                MyCityApp()
            }
        }
    }
}


class MyCityViewModel : ViewModel() {
    private val _activities =
        listOf("Cycling", "Hiking", "Museum Visit", "Food Tour", "Art Gallery")
    val activities: List<String> = _activities

    private val _restaurants = listOf("Restaurant A", "Restaurant B", "Restaurant C")
    val restaurants: List<String> = _restaurants
}

// Hàm tạo ứng dụng chính
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityApp(viewModel: MyCityViewModel = viewModel()) {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("MyCity") })
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("home") { HomeScreen(navController) }
            composable("activities") { ActivitiesScreen(viewModel) }
            composable("restaurants") { RestaurantsScreen(viewModel) }
        }
    }
}

// Màn hình chính với các nút điều hướng
@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(
            onClick = { navController.navigate("activities") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        ) {
            Text(text = "Explore Activities")
        }
        Button(
            onClick = { navController.navigate("restaurants") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Explore Restaurants")
        }
    }
}

@Composable
fun ActivitiesScreen(viewModel: MyCityViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Activities in MyCity", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(viewModel.activities) { activity ->
                ActivityItem(activityName = activity)
            }
        }
    }
}


@Composable
fun RestaurantsScreen(viewModel: MyCityViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Restaurants in MyCity", style = MaterialTheme.typography.titleSmall)
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(viewModel.restaurants) { restaurant ->
                RestaurantItem(restaurantName = restaurant)
            }
        }
    }
}


@Composable
fun ActivityItem(activityName: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),

    ) {
        Text(
            text = activityName,
            modifier = Modifier.padding(16.dp)
        )
    }
}


@Composable
fun RestaurantItem(restaurantName: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),

    ) {
        Text(
            text = restaurantName,
            modifier = Modifier.padding(16.dp)
        )
    }
}

// Bố cục hiển thị thử nghiệm
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MycityTheme {
        MyCityApp()
    }
}
