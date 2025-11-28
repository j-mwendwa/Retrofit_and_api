package com.example.retrofit_and_api.domain.repository

import com.example.retrofit_and_api.data.dto.PostResponseItem
import com.example.retrofit_and_api.data.remote.PostResponseApi
import com.example.retrofit_and_api.domain.PostRepo
import javax.inject.Inject

class PostRepoImpl @Inject constructor(private val api: PostResponseApi): PostRepo {
    override suspend fun getPosts(): List<PostResponseItem> {
        return api.getPosts()

    }
}