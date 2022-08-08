package com.example.dojoinnews.data.repository


import com.example.dojoinnews.commen.util.Resources
import com.example.dojoinnews.data.local.db.NewsDao
import com.example.dojoinnews.data.mapper.toNewEntity
import com.example.dojoinnews.data.mapper.toNews
import com.example.dojoinnews.data.remote.NewsApiServices
import com.example.dojoinnews.domain.model.News
import com.example.dojoinnews.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException

class NewsRepositoryImpl(
    private val apiServices: NewsApiServices,
    private val newsDao: NewsDao
) : NewsRepository {

    override fun getNews(period: String): Flow<Resources<List<News>>> = flow {

        emit(Resources.Loading())

        val cacheNews = newsDao.getCacheNews().map { it.toNews() }
        emit(Resources.Loading(data = cacheNews))

        try {
            val remoteNews = apiServices.getNews(period)
            newsDao.clearCache()
            newsDao.insertNews(remoteNews.results.map { it.toNewEntity() })

            val news = newsDao.getCacheNews().map { it.toNews() }
            emit(Resources.Success(news))

        } catch (e: HttpException) {
            emit(
                Resources.Error(
                    message = e.message ?: "Opps! something went wrong",
                    data = cacheNews
                )
            )
        } catch (e: IOException) {
            emit(
                Resources.Error(
                    message = e.message ?: "Check your internet connection",
                    data = cacheNews
                )
            )
        }

    }


}