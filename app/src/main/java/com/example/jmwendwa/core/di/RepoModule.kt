package com.example.jmwendwa.core.di

import com.example.jmwendwa.data.repository.ArticleRepositoryImpl
import com.example.jmwendwa.domain.repository.ArticleRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule{
    @Binds
    @Singleton

    abstract fun bindNewsRepository(
        newsRepositoryImpl: ArticleRepositoryImpl
    ): ArticleRepository
    }
//Binds Interface in NewsRepo to ite implementation as a Singleton class that is only created once