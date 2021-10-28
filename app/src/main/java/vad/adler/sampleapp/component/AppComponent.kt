package vad.adler.sampleapp.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import vad.adler.sampleapp.newsapi.module.NewsApiModule
import vad.adler.sampleapp.newsapi.ui.MakeNewsApiCallActivity
import javax.inject.Singleton

// Definition of the Application graph.

// The "modules" attribute in the @Component annotation tells Dagger what Modules
// to include when building the graph.
@Singleton
@Component(
    modules = [NewsApiModule::class]
)
interface AppComponent {
    // Tell Dagger that MakeNewsApiCall activity requests injection so the graph needs to
    // satisfy all the dependencies of the fields that MakeNewsApiCall activity is requesting.
    // This function tells Dagger that MakeNewsApiCall wants to access the graph and requests injection.

    // Factory to create instances of the AppComponent
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): AppComponent
    }

    // Classes that can be injected by this Component.
    fun inject(activity: MakeNewsApiCallActivity)
}