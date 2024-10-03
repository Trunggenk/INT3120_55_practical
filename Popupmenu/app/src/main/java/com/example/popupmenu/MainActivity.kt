package com.example.popupmenu
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyPopupMenu() {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Select an option") }

    Box(modifier = Modifier.fillMaxSize()) {
        // Text to open PopupMenu
        TextButton(onClick = { expanded = true }) {
            Text(selectedOption)
        }

        // Popup menu
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.padding(16.dp)
        ) {
            DropdownMenuItem(onClick = {
                selectedOption = "Option 1"
                expanded = false
            }) {
                Text("Option 1")
            }

            DropdownMenuItem(onClick = {
                selectedOption = "Option 2"
                expanded = false
            }) {
                Text("Option 2")
            }

            DropdownMenuItem(onClick = {
                selectedOption = "Option 3"
                expanded = false
            }) {
                Text("Option 3")
            }
        }
    }
}

@Preview
@Composable
fun PreviewMyPopupMenu() {
    MyPopupMenu()
}
