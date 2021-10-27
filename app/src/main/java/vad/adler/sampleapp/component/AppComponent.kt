package vad.adler.sampleapp.component

import dagger.Component
import vad.adler.sampleapp.newsapi.ui.MakeNewsApiCall

// Definition of the Application graph.

@Component
interface ApplicationComponent {
    // Tell Dagger that MakeNewsApiCall activity requests injection so the graph needs to
    // satisfy all the dependencies of the fields that MakeNewsApiCall activity is requesting.
    // This function tells Dagger that MakeNewsApiCall wants to access the graph and requests injection.
    fun inject(activity: MakeNewsApiCall)
}