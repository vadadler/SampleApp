package vad.adler.sampleapp.newsapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import vad.adler.sampleapp.MyApplication
import vad.adler.sampleapp.R
import javax.inject.Inject

class MakeNewsApiCallActivity : AppCompatActivity() {
    // Dagger to provide an instance of MakeNewsApiCallViewModel from the graph.
    @Inject
    lateinit var newsAPIViewModel: MakeNewsApiCallViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        Toast.makeText(applicationContext, getString(R.string.get_news), Toast.LENGTH_LONG).show()

        // Make Dagger instantiate @Inject fields in MakeNewsApiCall activity.
        (application as MyApplication).appComponent.inject(this)
        // Now MakeNewsApiCallViewModel is available.

        newsAPIViewModel.getLatestNews("Tesla", "publishedAt")

        super.onCreate(savedInstanceState)

    }
}