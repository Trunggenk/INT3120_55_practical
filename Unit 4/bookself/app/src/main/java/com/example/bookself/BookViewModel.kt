package com.example.bookshelf

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookself.Book
import com.example.bookself.BookRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BookViewModel(private val repository: BookRepository) : ViewModel() {

    private val _bookList = MutableStateFlow<List<Book>>(emptyList())
    val bookList: StateFlow<List<Book>> = _bookList

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun searchBooks(query: String) {
        viewModelScope.launch {
            _isLoading.value = true
            val books = repository.searchBooks(query)
            _bookList.value = books
            _isLoading.value = false
        }
    }
}
