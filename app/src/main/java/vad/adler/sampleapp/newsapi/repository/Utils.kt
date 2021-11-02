package vad.adler.sampleapp.newsapi.repository

import android.content.Context
import com.squareup.moshi.Moshi
import timber.log.Timber
import java.io.File
import java.security.AccessControlContext
import javax.inject.Inject

// Save JSON to file.
inline fun <reified T> T.saveAsJsonFile(context: Context) {
    kotlin.runCatching {
        val moshi = Moshi.Builder().build().adapter(T::class.java).indent("   ")
        File.createTempFile(
            T::class.java.simpleName + "-",
            ".json",
            context.getExternalFilesDir(null)
        )
        .also { Timber.d("Save ${T::class.java.simpleName} to file ${it.absoluteFile}") }
        .outputStream().use { output ->
            moshi.toJson(this)?.let {
                output.write(it.toByteArray())
            }
        }
    }.onFailure {
        Timber.d(it,"Failed to write JSON file for response ${T::class.java}")
    }
}

const val NEWS_API_KEY = "21f4a2926ab343a2b4880912b2336d49"
const val NEWS_API_URL = "https://newsapi.org/"