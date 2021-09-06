package com.abdul.telstraapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var person:Person

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        person = Person("abdul",321)

    }

    fun clickHandler(view: View) {
        Toast.makeText(this,"welcome to android",Toast.LENGTH_SHORT).show()
    }
}