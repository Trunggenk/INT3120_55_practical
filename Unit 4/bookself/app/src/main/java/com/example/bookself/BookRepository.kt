package com.example.bookself

import com.example.bookshelf.GoogleBooksApi


interface BookRepository {
    suspend fun searchBooks(query: String): List<Book>
    suspend fun getBookDetails(id: String): Book
}

class BookRepositoryImpl(private val api: GoogleBooksApi) : BookRepository {

    override suspend fun searchBooks(query: String): List<Book> {
        val response = api.searchBooks(query)
        return response.books.map {
            Book(it.id, it.volumeInfo.title, it.volumeInfo.imageLinks?.thumbnail?.replace("http", "https"))
        }
    }

    override suspend fun getBookDetails(id: String): Book {
        val response = api.getBookDetails(id)
        return Book(response.id, response.volumeInfo.title, response.volumeInfo.imageLinks?.thumbnail?.replace("http", "https"))
    }
}
