package com.example.jmwendwa.data.repository

import com.example.jmwendwa.data.local.dao.ArticleDao
import com.example.jmwendwa.data.mapper.toDomain
import com.example.jmwendwa.data.remote.api.NewsApiService
import com.example.jmwendwa.domain.model.Article
import com.example.jmwendwa.domain.repository.ArticleRepository

class ArticleRepositoryImpl(
    private val api: NewsApiService,
    private val dao: ArticleDao
): ArticleRepository {
    override suspend fun getTopHeadlines(
        category: String,
        page: Int,
        pageSize: Int
    ): List<Article> {
        try {
            val remote = api.getTopHeadlines(
                country = "us",
                category = category,
                apiKey = "YOUR_API_KEY",
                page = page,
                pageSize = pageSize
            ).articles.toDomain()
            dao.deleteArticles()
            dao.insertArticles(remote.map { it.toEntity() })

            remote
        } catch (e: Exception) {
            dao.getArticles().map { it.toDomain() }
        }
    }
}
