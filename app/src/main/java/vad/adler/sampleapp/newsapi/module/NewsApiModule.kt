package vad.adler.sampleapp.newsapi.module

import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import retrofit2.Retrofit
import vad.adler.sampleapp.newsapi.repository.NEWS_API_KEY
import vad.adler.sampleapp.newsapi.repository.NewsService

@Module
class NewsApiModule {

    // Create Network Interceptor to add api_key in all the request as authInterceptor.
//    private val interceptor = Interceptor { chain ->
//        val url = chain.request().url().newBuilder().addQueryParameter("apiKey", NEWS_API_KEY).build()
//        val request = chain.request()
//            .newBuilder()
//            .url(url)
//            .build()
//        chain.proceed(request)
//    }

    @Provides
    fun provideNewsService(): NewsService {
        // Whenever Dagger needs to provide an instance of type NewsService,
        // this code (the one inside the @Provides method) is run.
        return Retrofit.Builder()
            .baseUrl("https://example.com")
            .build()
            .create(NewsService::class.java)
    }

}