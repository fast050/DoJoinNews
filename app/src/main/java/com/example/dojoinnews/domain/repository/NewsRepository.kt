package com.example.dojoinnews.domain.repository

import com.example.dojoinnews.commen.util.Resources
import com.example.dojoinnews.domain.model.News
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getNews(period: Int): Flow<Resources<List<News>>>
}