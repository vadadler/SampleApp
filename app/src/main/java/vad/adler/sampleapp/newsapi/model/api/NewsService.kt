package vad.adler.sampleapp.newsapi.model.api

import retrofit2.http.GET
import retrofit2.http.Query
import vad.adler.sampleapp.newsapi.model.NewsServiceResponse

interface NewsService {
    @GET("v2/everything")
    suspend fun getNews(@Query("q") query: String,
                        @Query("sortBy") sortBy: String): NewsServiceResponse.News

}