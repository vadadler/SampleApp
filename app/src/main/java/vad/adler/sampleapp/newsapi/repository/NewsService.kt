package vad.adler.sampleapp.newsapi.repository

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("v2/everything")
    suspend fun getLatestNews(@Query("q") query: String,
                             @Query("sortBy") sortBy: String):  NewsServiceResponse
}