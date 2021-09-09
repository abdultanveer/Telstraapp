package com.abdul.telstraapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class DataActivity : AppCompatActivity() {
    lateinit var etTitle: EditText
    lateinit var tvRes: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)
        etTitle = findViewById(R.id.etTitle)
        tvRes = findViewById(R.id.tvDbRes)
    }

    fun handleDb(view: View) {
        var title = etTitle.text.toString()
        tvRes.setText(title)

    }
}