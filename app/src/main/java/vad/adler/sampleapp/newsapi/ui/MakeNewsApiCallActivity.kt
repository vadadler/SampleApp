package vad.adler.sampleapp.newsapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import vad.adler.sampleapp.MyApplication
import vad.adler.sampleapp.R
import javax.inject.Inject
import vad.adler.sampleapp.databinding.MakeNewsApiCallActivityBinding

class MakeNewsApiCallActivity : AppCompatActivity() {
    // Dagger to provide an instance of MakeNewsApiCallViewModel from the graph.
    @Inject
    lateinit var newsAPIViewModel: MakeNewsApiCallViewModel

    private lateinit var binding: MakeNewsApiCallActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Make Dagger instantiate @Inject fields in MakeNewsApiCall activity.
        (application as MyApplication).appComponent.inject(this)
        // Now MakeNewsApiCallViewModel is available.

        DataBindingUtil.setContentView(this, R.layout.make_news_api_call_activity)
//        setContentView(this, R.layout.activity_main3)

        //newsAPIViewModel.getLatestNews("Tesla", "publishedAt")



    }
}