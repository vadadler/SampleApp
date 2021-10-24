package vad.adler.sampleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import vad.adler.sampleapp.view.MakeNewsApiCall

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun makeNewsApiCall(view: View) {
        startActivity(Intent(this@MainActivity, MakeNewsApiCall::class.java))
    }

}