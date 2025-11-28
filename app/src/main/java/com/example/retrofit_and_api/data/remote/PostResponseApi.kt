package com.example.retrofit_and_api.data.remote

import com.example.retrofit_and_api.data.dto.PostResponseItem
import retrofit2.http.GET

interface PostResponseApi {

    @GET("photos")
    suspend fun getPosts(): List<PostResponseItem>
}
