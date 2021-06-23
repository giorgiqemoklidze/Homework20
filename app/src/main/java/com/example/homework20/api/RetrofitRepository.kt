package com.example.homework20.api

import com.example.homework20.models.News
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitRepository {

    @GET("v3/articles")
    suspend fun getNews(): Response<List<News>>

}