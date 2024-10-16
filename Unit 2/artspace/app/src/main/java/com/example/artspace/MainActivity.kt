package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                    ArtSpaceTheme {
                        ArtSpaceApp()
                    }


        }
    }
}

@Composable
fun ArtSpaceApp() {
    // List các tác phẩm nghệ thuật và thông tin của chúng
    val artworks = listOf(
        Pair(R.drawable.dice_1, "The Starry Night by Vincent van Gogh"),
        Pair(R.drawable.dice_2, "Mona Lisa by Leonardo da Vinci"),
        Pair(R.drawable.dice_3, "The Persistence of Memory by Salvador Dalí")
    )

    // Trạng thái hiện tại của tác phẩm
    var currentArt by remember { mutableStateOf(0) }

    // Layout ứng dụng
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Hiển thị hình ảnh của tác phẩm nghệ thuật
        Image(
            painter = painterResource(id = artworks[currentArt].first),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(300.dp)
                .padding(16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Hiển thị tiêu đề của tác phẩm nghệ thuật
        Text(
            text = artworks[currentArt].second,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Nút "Previous" để xem tác phẩm trước đó
        Button(onClick = {
            currentArt = (currentArt - 1 + artworks.size) % artworks.size
        }) {
            Text(text = "Previous")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Nút "Next" để xem tác phẩm tiếp theo
        Button(onClick = {
            currentArt = (currentArt + 1) % artworks.size
        }) {
            Text(text = "Next")
        }
    }
}