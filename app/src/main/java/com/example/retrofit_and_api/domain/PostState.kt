package com.example.retrofit_and_api.domain

import com.example.retrofit_and_api.data.dto.PostResponseItem

data class PostState(
    val isLoading: Boolean? = false,
    val postsList: List<PostResponseItem>? = emptyList(),
    val error: String? = null

)