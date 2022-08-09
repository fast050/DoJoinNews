package com.example.dojoinnews.data.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.google.gson.Gson
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.InputStreamReader


class NewsApiTest {

        private val server: MockWebServer = MockWebServer()
        private val MOCK_WEBSERVER_PORT = 8000

        lateinit var newsApi: NewsApiServices

        @get:Rule
        val instance = InstantTaskExecutorRule()

        @Before
        fun init() {
            server.start(MOCK_WEBSERVER_PORT)

            newsApi = Retrofit.Builder()
                .baseUrl(server.url("/"))
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .build()
                .create(NewsApiServices::class.java)
        }

        @After
        fun shutdown() {
            server.shutdown()
        }

        @Test
        fun `APIs parse correctly`() = runBlocking {
            server.apply {
                enqueue(MockResponse().setBody(MockResponseFileReader("news_response.json").content))
            }
            val data = newsApi.getNews(7)
            assertThat(data).isNotNull()
        }

        @Test
        fun `API response have the right size`() = runBlocking {
            server.apply {
                enqueue(MockResponse().setBody(MockResponseFileReader("news_response.json").content))
            }
            val dataSize = newsApi.getNews(7).results?.size
            assertThat(dataSize).isEqualTo(20)
        }

}

class MockResponseFileReader(path: String) {

    val content: String

    init {
        val reader = InputStreamReader(this.javaClass.classLoader?.getResourceAsStream(path))
        content = reader.readText()
        reader.close()
    }
}
