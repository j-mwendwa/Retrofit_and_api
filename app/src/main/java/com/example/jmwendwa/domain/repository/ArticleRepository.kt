package com.example.jmwendwa.domain.repository

import com.example.jmwendwa.domain.model.Article

interface ArticleRepository {
    suspend fun getTopHeadlines(category: String,page:Int,pageSize:Int): List<Article>
}