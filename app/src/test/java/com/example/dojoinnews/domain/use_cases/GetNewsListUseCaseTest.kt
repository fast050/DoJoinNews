package com.example.dojoinnews.domain.use_cases

import com.example.dojoinnews.domain.repository.FakeNewsRepository
import com.example.dojoinnews.domain.util.NewsPeriod
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.*
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetNewsListUseCaseTest {

    private lateinit var fakeRepository: FakeNewsRepository
    private lateinit var getNewsListUseCase: GetNewsListUseCase

    @Before
    fun setup() {
        fakeRepository = FakeNewsRepository()
        getNewsListUseCase = GetNewsListUseCase(fakeRepository)
    }

    @Test
    fun `get newsList successful , return non null List same as listOfNews`()= runBlocking{
        fakeRepository.setIsResponseSuccessful(true)

        val result = getNewsListUseCase(NewsPeriod.ONE_DAY).first().data
        assertEquals(result, FakeNewsRepository.listOfNews)
    }

    @Test
    fun `get newsList Error , return null list`() = runBlocking {
        fakeRepository.setIsResponseSuccessful(false)

        val result = getNewsListUseCase(NewsPeriod.ONE_DAY).first().data
        assertEquals(result,null)
    }

}