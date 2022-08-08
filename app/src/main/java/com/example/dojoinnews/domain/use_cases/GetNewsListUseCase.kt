package com.example.dojoinnews.domain.use_cases

import com.example.dojoinnews.commen.util.Resources
import com.example.dojoinnews.domain.model.News
import com.example.dojoinnews.domain.repository.NewsRepository
import com.example.dojoinnews.domain.util.NewsPeriod
import kotlinx.coroutines.flow.Flow

class GetNewsListUseCase(private val repository: NewsRepository) {
    operator fun invoke(period: NewsPeriod): Flow<Resources<List<News>>> =
        repository.getNews(period.value)
}