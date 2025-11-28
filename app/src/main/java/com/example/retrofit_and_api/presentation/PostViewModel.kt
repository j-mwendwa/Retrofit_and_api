package com.example.retrofit_and_api.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit_and_api.common.Resource
import com.example.retrofit_and_api.domain.PostUseCase
import com.example.retrofit_and_api.domain.model.Post
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import android.util.Log
import com.example.retrofit_and_api.domain.PostState

@HiltViewModel
class PostViewModel @Inject constructor(
    private val getPostsUseCase: PostUseCase
) : ViewModel() {

    private val _state = mutableStateOf<Resource<List<Post>>>(Resource.Loading())
    val state: State<Resource<List<Post>>> = _state
    
    init {
        getPosts()
    }
    
    private fun getPosts() {    
        viewModelScope.launch {
            getPostsUseCase().collect { result ->
                when (result) {
                    is Resource.Loading -> {
                        _state.value = Resource.Loading()
                    }
                    is Resource.Success -> {
                        _state.value = PostState(postList = result.data)
                        Log.d("viewModel", result.data.toString())

                    }
                    is Resource.Error -> {
                        _state.value = Resource.Error(result.errorMessage ?: "An unexpected error occurred")
                        Log.d("PostViewModel", "Error: ${result.errorMessage}")
                        println(result.errorMessage)
                    }
                }
            }
        }
    }
}