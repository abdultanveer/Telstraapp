package com.abdul.telstraapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class RecyclerActivity : AppCompatActivity() {
    var wordsData = arrayOf("first","second","third","fourth")
    lateinit var wordsAdapter: WordsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
    }
}