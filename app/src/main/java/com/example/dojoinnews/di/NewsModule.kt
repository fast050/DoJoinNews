package com.example.dojoinnews.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dojoinnews.data.local.db.NewsDao
import com.example.dojoinnews.data.local.db.NewsDatabase
import com.example.dojoinnews.data.remote.NewsApiServices
import com.example.dojoinnews.data.repository.NewsRepositoryImpl
import com.example.dojoinnews.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NewsModule {


    @Provides
    @Singleton
    fun provideNewsDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, NewsDatabase::class.java, NewsDatabase.DATABASE_NAME).build()

    @Provides
    fun provideNewsDao(newDatabase: NewsDatabase) : NewsDao = newDatabase.newsDao()

    @Provides
    @Singleton
    fun provideNewsApiService(): NewsApiServices = Retrofit.Builder()
        .baseUrl(NewsApiServices.BASE_URL).addConverterFactory(GsonConverterFactory.create())
        .build().create(NewsApiServices::class.java)

    @Provides
    @Singleton
    fun provideNewsRepository(api: NewsApiServices, dao: NewsDao): NewsRepository =
        NewsRepositoryImpl(api, dao)

}