package com.example.jmwendwa.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

//Creating our DB Article Row
@Entity(tableName = "articles")
data class ArticleEntity(
    @PrimaryKey
    val url: String,
    val title: String,
    val description: String,
    val urlToImage: String,
    val sourceName: String
)
