package vad.adler.sampleapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import vad.adler.sampleapp.R

class MakeNewsApiCall : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(applicationContext, getString(R.string.get_news), Toast.LENGTH_LONG).show()
    }
}