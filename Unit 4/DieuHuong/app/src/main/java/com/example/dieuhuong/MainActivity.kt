package com.example.dieuhuong

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dieuhuong.ui.theme.DieuHuongTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DieuHuongTheme {
                // Set up the NavController
                val navController = rememberNavController()
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text("Lunch Tray") }
                        )
                    }
                ) {
                    // Navigation host
                    LunchNavHost(navController = navController)
                }
            }
        }
    }
}

@Composable
fun LunchNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "choose_entree") {
        composable("choose_entree") { ChooseEntreeScreen(navController) }
        composable("choose_side") { ChooseSideScreen(navController) }
        composable("choose_accompaniment") { ChooseAccompanimentScreen(navController) }
        composable("order_summary") { OrderSummaryScreen(navController) }
    }
}

@Composable
fun OrderSummaryScreen(navController: NavController) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Order Summary", style = MaterialTheme.typography.bodySmall)
        Text("Entrée: Cauliflower") // You can use state to store the selections
        Text("Side Dish: Butternut Squash Soup")
        Text("Accompaniment: Lunch Roll")

        Spacer(modifier = Modifier.height(16.dp))

        Text("Subtotal: $11.50")
        Text("Tax: $0.84")
        Text("Total: $12.34")

        Button(
            onClick = { /* Submit order logic */ },
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        ) {
            Text("Submit Order")
        }
    }
}

@Composable
fun ChooseAccompanimentScreen(navController: NavController) {
    var selectedAccompaniment by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Choose your accompaniment", style = MaterialTheme.typography.bodySmall)
        RadioButtonGroup(
            options = listOf("Lunch Roll", "Mixed Berries", "Pickled Veggies"),
            selectedOption = selectedAccompaniment,
            onOptionSelected = { selectedAccompaniment = it }
        )
        Button(
            onClick = { navController.navigate("order_summary") },
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
            enabled = selectedAccompaniment.isNotEmpty()
        ) {
            Text("Next")
        }
    }
}

@Composable
fun ChooseSideScreen(navController: NavController) {
    var selectedSide by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Choose your side dish", style = MaterialTheme.typography.bodySmall)
        RadioButtonGroup(
            options = listOf("Summer Salad", "Butternut Squash Soup", "Spicy Potatoes", "Coconut Rice"),
            selectedOption = selectedSide,
            onOptionSelected = { selectedSide = it }
        )
        Button(
            onClick = { navController.navigate("choose_accompaniment") },
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
            enabled = selectedSide.isNotEmpty()
        ) {
            Text("Next")
        }
    }
}

@Composable
fun ChooseEntreeScreen(navController: NavController) {
    var selectedEntree by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Choose your entrée", style = MaterialTheme.typography.bodySmall)
        RadioButtonGroup(
            options = listOf("Cauliflower", "Three Bean Chili", "Mushroom Pasta", "Spicy Black Bean Skillet"),
            selectedOption = selectedEntree,
            onOptionSelected = { selectedEntree = it }
        )
        Button(
            onClick = { navController.navigate("choose_side") },
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
            enabled = selectedEntree.isNotEmpty()
        ) {
            Text("Next")
        }
    }
}

@Composable
fun RadioButtonGroup(
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    Column {
        options.forEach { text ->
            Row(
                Modifier.fillMaxWidth().padding(vertical = 8.dp)
            ) {
                RadioButton(
                    selected = text == selectedOption,
                    onClick = { onOptionSelected(text) }
                )
                Text(
                    text = text,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}
