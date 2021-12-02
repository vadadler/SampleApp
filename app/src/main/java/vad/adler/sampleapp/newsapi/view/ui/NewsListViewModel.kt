package vad.adler.sampleapp.newsapi.view.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import vad.adler.sampleapp.newsapi.model.NewsServiceRepository
import vad.adler.sampleapp.newsapi.model.NewsServiceResponse
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class NewsListViewModel @Inject constructor(): ViewModel() {
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