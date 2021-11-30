package vad.adler.sampleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import vad.adler.sampleapp.newsapi.view.ui.MakeNewsApiCallActivity
import vad.adler.sampleapp.newsapi.view.ui.MakeNewsApiCallViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var loginViewModel: MakeNewsApiCallViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }

    fun makeNewsApiCall(view: View) {
        startActivity(Intent(this@MainActivity, MakeNewsApiCallActivity::class.java))
    }

}