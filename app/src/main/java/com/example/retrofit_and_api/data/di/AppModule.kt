package com.example.retrofit_and_api.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import com.example.retrofit_and_api.data.remote.PostResponseApi
import com.example.retrofit_and_api.domain.PostRepo
import com.example.retrofit_and_api.domain.repository.PostRepoImpl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.jvm.java


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    @Provides
    @Singleton
    fun providePostResponseApi(): PostResponseApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PostResponseApi::class.java)
    }
    @Provides
    @Singleton
    fun providePostRepo(api: PostResponseApi): PostRepo {
        return PostRepoImpl(api)
    }
}


