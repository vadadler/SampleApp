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
    private val parentJob = Job()
    private val coroutineContext : CoroutineContext get() = parentJob + Dispatchers.Default
    private val scope = CoroutineScope(coroutineContext)
    private val newsRepository : NewsServiceRepository = NewsServiceRepository(NewsService.)
    val newsLiveData = MutableLiveData<MutableList<NewsServiceResponse.Article>>()


    fun getLatestNews(query: String, sortBy: String) {
        scope.launch {
            val latestNews = newsRepository.getNews(query, sortBy)
            newsLiveData.postValue(latestNews)
        }
    }

    fun cancelRequests() = coroutineContext.cancel()

    val news: LiveData<NewsServiceResponse> = liveData {
        emit()
        emit(newsRepository.getNews("",""))
    }
}