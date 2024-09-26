import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SimpleCard() {
    Card(
    ) {
        Column {
            Text(text = "Họ tên: Nguyễn Văn A")
            Text(text = "Tuổi: 25")
            Text(text = "Địa chỉ: Hà Nội, Việt Nam")
            Text(text = "Email: example@example.com")
        }
    }
}

@Preview
@Composable
fun PreviewSimpleCard() {
    SimpleCard()
}
