package vad.adler.sampleapp.newsapi.model

import android.content.Context
import arrow.core.Either
import com.squareup.moshi.Moshi
import vad.adler.sampleapp.newsapi.model.api.NewsService
import vad.adler.sampleapp.newsapi.model.api.NewsServiceResponse

open class NewsServiceRepository(
    private val newsService: NewsService,
    private val moshi: Moshi,
    private val context: Context
) {
    private var newsResponse: NewsServiceResponse.News? = null

    open suspend fun getNews(query: String, sortBy: String): Either<Throwable, NewsServiceResponse.News> = Either.catch {
        newsService.getNews(query, sortBy).also {
            newsResponse = it
            it.saveAsJsonFile(context)
        }
    }
}