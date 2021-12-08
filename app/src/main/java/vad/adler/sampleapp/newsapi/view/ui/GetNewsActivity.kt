package vad.adler.sampleapp.newsapi.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import vad.adler.sampleapp.MyApplication
import vad.adler.sampleapp.R
import javax.inject.Inject
import vad.adler.sampleapp.databinding.MakeNewsApiCallActivityBinding

class GetNewsActivity : AppCompatActivity() {
    // Dagger to provide an instance of MakeNewsApiCallViewModel from the graph.
    @Inject
    lateinit var newsAPIViewModel: NewsViewModel

    private lateinit var binding: MakeNewsApiCallActivityBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Make Dagger instantiate @Inject fields in MakeNewsApiCall activity.
        (application as MyApplication).appComponent.inject(this)
        // Now MakeNewsApiCallViewModel is available.

        binding = DataBindingUtil.setContentView(this, R.layout.make_news_api_call_activity)

        navController = Navigation.findNavController(this, R.id.navFragment)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }
}