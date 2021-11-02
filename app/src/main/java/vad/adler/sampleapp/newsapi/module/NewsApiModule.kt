package vad.adler.sampleapp.newsapi.module

import android.app.Application
import android.content.Context
import android.util.Log
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import vad.adler.sampleapp.newsapi.repository.NEWS_API_KEY
import vad.adler.sampleapp.newsapi.repository.NEWS_API_URL
import vad.adler.sampleapp.newsapi.repository.NewsService
import vad.adler.sampleapp.newsapi.repository.NewsServiceRepository
import javax.inject.Singleton

@Module
class NewsApiModule {
    @Singleton
    @Provides
    open fun provideMoshi(): Moshi {
        return Moshi
            .Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    // Create Network Interceptor to add api_key in all the request as authInterceptor.
    private val interceptor = Interceptor { chain ->
        val url = chain.request().url.newBuilder().addQueryParameter("apiKey", NEWS_API_KEY).build()
        val request = chain.request()
            .newBuilder()
            .url(url)
            .build()
        chain.proceed(request)
    }

    private fun loggingInterceptor():HttpLoggingInterceptor {
        val logger = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
            Log.d("OkHttp: ", it)
        })

        logger.level = HttpLoggingInterceptor.Level.BODY
        return logger
    }

    private val apiClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(interceptor)
        .addInterceptor(loggingInterceptor())
        .build()

    @Provides
    @Singleton
    fun provideNewsService(moshi: Moshi): NewsService {
        // Whenever Dagger needs to provide an instance of type NewsService,
        // this code (the one inside the @Provides method) is run.
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(NEWS_API_URL)
            .client(apiClient)
            .build()
            .create(NewsService::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsServiceRepository( newsService: NewsService,
                                      moshi: Moshi,
                                      context: Context): NewsServiceRepository {
        return NewsServiceRepository(newsService, moshi, context)
    }
}