package com.example.bookself

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bookself.ui.theme.BookSelfTheme
import com.example.bookshelf.BookViewModel
import com.example.bookshelf.GoogleBooksApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : ComponentActivity() {

    // ViewModel được khởi tạo bằng ViewModelProvider.Factory
    private val bookViewModel: BookViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val api = provideGoogleBooksApi()
                val repository = BookRepositoryImpl(api)
                return BookViewModel(repository) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookSelfTheme {
                MainScreen(viewModel = bookViewModel) // Gọi màn hình chính
            }
        }
    }

    // Cấu hình Retrofit cho Google Books API
    private fun provideGoogleBooksApi(): GoogleBooksApi {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/books/v1/")
            .client(OkHttpClient.Builder().build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(GoogleBooksApi::class.java)
    }
}
