package com.example.retrofit_and_api.domain

import android.util.Log
import com.example.retrofit_and_api.common.Resource
import com.example.retrofit_and_api.data.dto.PostResponseItem
import com.example.retrofit_and_api.domain.model.Post
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class PostUseCase @Inject constructor(private val repo: PostRepo) {
    operator fun invoke(): Flow<Resource<List<PostResponseItem>>> = flow {

        try {
            emit(Resource.Loading<List<PostResponseItem>>())
            val posts = repo.getPosts()
            Log.d("PostUseCase", "Posts: $posts")
            println(posts)
            emit(Resource.Success<List<PostResponseItem>>(posts))

        } catch (e: HttpException) {
            emit(
                Resource.Error<List<PostResponseItem>>(
                    e.localizedMessage ?: "An unexpected error occurred"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error<List<PostResponseItem>>("Couldn\'t reach server. Check your internet connection"))
        } catch (e: Exception) {
            emit(Resource.Error<List<PostResponseItem>>(e.localizedMessage ?: "An unexpected error occurred"))
        }
    }
}