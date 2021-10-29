package vad.adler.sampleapp.newsapi.repository

import android.content.Context
import android.util.Log
import arrow.core.Either
import com.squareup.moshi.Moshi
import retrofit2.Response
import java.io.IOException

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

    suspend fun <T: Any> safeApiCall(call: suspend()-> Response<T>, error: String):  T? {
        val result = newsApiOutput(call, error)
        var output: T? = null
        when(result) {
            is Status.Success ->
                output = result.output
            is Status.Error -> Log.e("Error", "Error: $error and the ${result.exception}")
        }
        return output

    }

    private suspend fun<T : Any> newsApiOutput(call: suspend()-> Response<T>, error: String): Status<T>{
        val response = call.invoke()
        return if (response.isSuccessful)
            Status.Success(response.body()!!)
        else
            Status.Error(IOException("OOps .. Something went wrong due to  $error"))
    }

}