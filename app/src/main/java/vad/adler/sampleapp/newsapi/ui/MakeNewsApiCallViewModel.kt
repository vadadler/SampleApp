package vad.adler.sampleapp.newsapi.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import vad.adler.sampleapp.newsapi.repository.NewsService
import vad.adler.sampleapp.newsapi.repository.NewsServiceRepository
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class MakeNewsApiCallViewModel @Inject constructor(): ViewModel() {
    private val parentJob = Job()
    private val coroutineContext : CoroutineContext get() = parentJob + Dispatchers.Default
    private val scope = CoroutineScope(coroutineContext)
    private val newsRepository : NewsServiceRepository = NewsServiceRepository(NewsService.getNews)
    val newsLiveData = MutableLiveData<MutableList<Article>>()


    fun getLatestNews() {
        scope.launch {
            val latestNews = newsRepository.getLatestNews()
            newsLiveData.postValue(latestNews)

        }
    }
    fun cancelRequests() = coroutineContext.cancel()

}