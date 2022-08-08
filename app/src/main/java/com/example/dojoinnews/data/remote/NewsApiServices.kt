package com.example.dojoinnews.data.remote

import com.example.dojoinnews.data.dto.NewsResponseDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface NewsApiServices {

    @GET("/mostviewed/all-section/{period}.json")
    suspend fun getNews(
        @Path("period") period: String,
        @Query("api-key") apiKey:String = API_KEY
      ):NewsResponseDTO

    companion object {
        const val BASE_URL = "https://api.nytimes.com/svc/mostpopular/v2"
        const val API_KEY = "XA0l10yIX7wrf33sKHJvITUhGXHHGQEq"
    }
}
