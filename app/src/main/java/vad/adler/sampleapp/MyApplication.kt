package vad.adler.sampleapp

import android.app.Application
import vad.adler.sampleapp.component.AppComponent
import vad.adler.sampleapp.component.DaggerAppComponent

import timber.log.Timber

class MyApplication: Application() {
    // appComponent lives in the Application class to share its lifecycle.
    // Reference to the application graph that is used across the whole app
//    val appComponent = DaggerApplicationComponent.create()

    // Instance of the AppComponent that will be used by all the Activities in the project
    val appComponent: AppComponent by lazy {
        initializeComponent()
    }

    open fun initializeComponent(): AppComponent {
        // Creates an instance of AppComponent using its Factory constructor
        // We pass the applicationContext that will be used as Context in the graph
        return DaggerAppComponent.factory().create(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}

