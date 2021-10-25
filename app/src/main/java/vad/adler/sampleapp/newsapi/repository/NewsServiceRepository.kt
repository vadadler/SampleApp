package vad.adler.sampleapp.newsapi.repository

import android.content.Context
import arrow.core.Either
import com.squareup.moshi.Moshi

open class NewsServiceRepository(
    private val newsService: NewsService,
    private val moshi: Moshi,
    private val context: Context
) {
    private var newsServiceResponse: NewsServiceResponse? = null

    open suspend fun getNews(query: String, sortBy: String): Either<Throwable, NewsServiceResponse> = Either.catch {
        newsService.getLatestNews(query, sortBy).also {
            newsServiceResponse = it
            it.saveAsJsonFile(context)
        }
    }
}