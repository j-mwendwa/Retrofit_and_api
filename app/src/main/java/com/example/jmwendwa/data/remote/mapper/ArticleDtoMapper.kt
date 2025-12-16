package com.example.jmwendwa.data.remote.mapper

import com.example.jmwendwa.data.remote.dto.ArticleDto
import com.example.jmwendwa.domain.model.Article

fun ArticleDto.toDomain(): Article {
    return Article(
        title = title ?: "",
        description = description ?: "",
        url = url ?: "",
        imageUrl = urlToImage ?: "",
        sourceName = source?.name ?: ""
    )
}

fun List<ArticleDto>.toDomain(): List<Article> {
    return map { it.toDomain() }
}