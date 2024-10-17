package com.example.bookshelf


import com.example.bookself.BookResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GoogleBooksApi {

    // API tìm kiếm sách theo từ khóa
    @GET("volumes")
    suspend fun searchBooks(@Query("q") query: String): BookResponse

    // API lấy chi tiết một cuốn sách cụ thể
    @GET("volumes/{id}")
    suspend fun getBookDetails(@Path("id") id: String): BookResponse
}
