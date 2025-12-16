package com.example.jmwendwa.core.di

import com.example.jmwendwa.data.remote.api.NewsApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideMoshi(): Moshi =
        Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
//Alternative to the GSONConverterFactory

    //Provide my Retrofit Instance
    @Provides
    @Singleton
    fun provideRetrofit(moshi: Moshi): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()


    //Provide my Api Service
    @Provides
    @Singleton
    fun provideNewsApiService(retrofit: Retrofit): NewsApiService =
        retrofit.create(NewsApiService::class.java)
}
//Singleton creates a single instance of a class that is re used in the whole app
//Provides is used for custom object creation.