package com.example.retrofit_and_api.domain

import com.example.retrofit_and_api.data.dto.PostResponseItem
import com.example.retrofit_and_api.domain.model.Post

interface PostRepo {
    suspend fun getPosts(): List<PostResponseItem>
}