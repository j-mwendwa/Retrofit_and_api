package com.example.jmwendwa.data.mapper

import com.example.jmwendwa.data.local.entity.ArticleEntity
import com.example.jmwendwa.data.remote.dto.ArticleDto
import com.example.jmwendwa.domain.model.Article

fun ArticleDto.toDomain(): Article {
    return Article(
        title = title ?: "No Title",
        description = description ?: "No Description",
        url = url,
        imageUrl = urlToImage ?: "",
        sourceName = source.name
    )
}

fun Article.toEntity(): ArticleEntity {
    return ArticleEntity(
        title = title,
        description = description,
        url = url,
        urlToImage = imageUrl,
        sourceName = sourceName
    )
}

fun ArticleEntity.toDomain(): Article {
    return Article(
        title = title,
        description = description,
        url = url,
        imageUrl = urlToImage,
        sourceName = sourceName
    )
}
