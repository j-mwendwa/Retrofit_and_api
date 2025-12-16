package com.example.jmwendwa.data.remote.dto

data class NewsApiResponse(
    val articles: List<ArticleDto>,
    val status: String,
    val totalResults: Int
)
