package vad.adler.sampleapp.newsapi.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import vad.adler.sampleapp.newsapi.repository.NewsService
import vad.adler.sampleapp.newsapi.repository.NewsServiceRepository
import vad.adler.sampleapp.newsapi.repository.NewsServiceResponse
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class MakeNewsApiCallViewModel @Inject constructor(): ViewModel() {
    @Inject
    lateinit var newsRepository: NewsServiceRepository

    private val parentJob = Job()
    private val coroutineContext : CoroutineContext get() = parentJob + Dispatchers.Default
    private val scope = CoroutineScope(coroutineContext)
    val newsLiveData = MutableLiveData<MutableList<NewsServiceResponse.Article>>()

    fun getLatestNews(query: String, sortBy: String) {
        scope.launch {
            val latestNews = newsRepository.getNews(query, sortBy)
            val i = 0
            //newsLiveData.postValue(latestNews)
        }
    }

    fun cancelRequests() = coroutineContext.cancel()
}