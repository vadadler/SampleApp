package vad.adler.sampleapp.newsapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import vad.adler.sampleapp.Application
import vad.adler.sampleapp.R
import javax.inject.Inject

class MakeNewsApiCall : AppCompatActivity() {
    // Dagger to provide an instance of MakeNewsApiCallViewModel from the graph.
    @Inject
    lateinit var loginViewModel: MakeNewsApiCallViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        Toast.makeText(applicationContext, getString(R.string.get_news), Toast.LENGTH_LONG).show()

        // Make Dagger instantiate @Inject fields in MakeNewsApiCall activity.
        (applicationContext as Application).appComponent.inject(this)
        // Now MakeNewsApiCallViewModel is available.

        super.onCreate(savedInstanceState)

    }
}