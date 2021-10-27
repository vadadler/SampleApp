package vad.adler.sampleapp

import android.app.Application
import vad.adler.sampleapp.component.DaggerApplicationComponent

class Application: Application() {
    // appComponent lives in the Application class to share its lifecycle.
    // Reference to the application graph that is used across the whole app
    val appComponent = DaggerApplicationComponent.create()

}

