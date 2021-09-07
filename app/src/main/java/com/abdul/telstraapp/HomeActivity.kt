package com.abdul.telstraapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    lateinit var tvHome: TextView
    lateinit var etContact: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        tvHome = findViewById(R.id.tvHome)
        etContact = findViewById(R.id.etContact)

       var name = intent.getStringExtra("namekey")
           //intent.extras?.getString("namekey")
        tvHome.setText(name)

    }

    fun sendData(view: View) {
        //get the data from edittext
        var contactData = etContact.text.toString()
        //send the data to mainactivity
        var resultIntent = Intent()
        resultIntent.putExtra("contactkey",contactData)
        setResult(RESULT_OK,resultIntent)
        //close this activity
        finish()

    }
}