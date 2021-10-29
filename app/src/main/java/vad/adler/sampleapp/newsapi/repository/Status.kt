package vad.adler.sampleapp.newsapi.repository

import java.lang.Exception

sealed class Status<out T: Any> {
    data class Success<out T: Any>(val output : T): Status<T>()
    data class Error(val exception: Exception): Status<Nothing>()
}