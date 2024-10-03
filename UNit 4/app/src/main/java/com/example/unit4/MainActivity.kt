import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties

@Composable
fun MyContextMenu() {
    var expanded by remember { mutableStateOf(false) }
    var offset by remember { mutableStateOf(0.dp to 0.dp) }

    Box(
        modifier = Modifier
            .pointerInput(Unit) {
                detectTapGestures(
                    onLongPress = {
                        // Mở context menu khi long press
                        offset = it.x.dp to it.y.dp
                        expanded = true
                    }
                )
            }
    ) {
        BasicText(text = "Long press to show context menu")

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            offset = offset,
            properties = PopupProperties(focusable = true)
        ) {
            DropdownMenuItem(onClick = { /* Action 1 */ }) {
                BasicText("Action 1")
            }
            DropdownMenuItem(onClick = { /* Action 2 */ }) {
                BasicText("Action 2")
            }
        }
    }
}
