// File: com/example/superheroes/product/Product.kt
package com.example.superheroes.product

data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val imageRes: Int // Sử dụng ID tài nguyên thay vì URL
)
