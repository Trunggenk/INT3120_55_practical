package com.example.bookself

import com.google.gson.annotations.SerializedName

data class BookResponse(
    @SerializedName("items") val books: List<BookItem>
)

data class BookItem(
    @SerializedName("id") val id: String,
    @SerializedName("volumeInfo") val volumeInfo: VolumeInfo
)

data class VolumeInfo(
    @SerializedName("title") val title: String,
    @SerializedName("imageLinks") val imageLinks: ImageLinks?
)

data class ImageLinks(
    @SerializedName("thumbnail") val thumbnail: String
)

data class Book(
    val id: String,
    val title: String,
    val thumbnailUrl: String?
)
