package com.abdul.telstraapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var person:Person
    lateinit var nameEt: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        person = Person("abdul",321)
        nameEt = findViewById(R.id.etName)
    }

    fun clickHandler(view: View) {
        var name = nameEt.text
        var tvResult: TextView = findViewById(R.id.tvResult)
        tvResult.setText(name)
        Toast.makeText(this,"welcome to android",Toast.LENGTH_SHORT).show()
    }
}