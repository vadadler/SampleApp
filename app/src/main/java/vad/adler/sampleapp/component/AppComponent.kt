package vad.adler.sampleapp.component

import vad.adler.sampleapp.newsapi.model.ui.MakeNewsApiCall

interface AppComponent {
    fun inject(activity: MakeNewsApiCall)
}