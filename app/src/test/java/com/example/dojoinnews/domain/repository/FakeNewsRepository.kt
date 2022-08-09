package com.example.dojoinnews.domain.repository

import com.example.dojoinnews.commen.util.Resources
import com.example.dojoinnews.domain.model.News
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeNewsRepository : NewsRepository {

    private var isResponseSuccessful  = true

    fun setIsResponseSuccessful(isSuccess:Boolean){
        isResponseSuccessful = isSuccess
    }

    override fun getNews(period: Int): Flow<Resources<List<News>>> = flow{
        if (isResponseSuccessful)
             emit(Resources.Success(data = listOfNews))
        else
            emit(Resources.Error(data = null,message = "something wrong"))
    }

    companion object{
        val listOfNews = listOf(
            News(
                "new 1",
                "",
                "use 1",
                "",
                "",
                "",
                "new york",
            ), News(
                "new 2",
                "",
                "use 2",
                "",
                "",
                "",
                "new york",
            )
        )
    }
}