package com.example.retrofit_and_api.domain.model

data class Post(
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String
)