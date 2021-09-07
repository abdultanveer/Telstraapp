package com.abdul.telstraapp

import android.content.Intent
import android.net.Uri
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
        when(view.id){
            R.id.button -> startHomeActivity()
            R.id.btnText -> setDataTextview()
            R.id.btnDial -> startDialer()
        }

        //setDataTextview()
       // startDialer()
    }

    private fun startDialer() {
        var dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:12345987654"))
        startActivity(dialIntent)
    }

    private fun setDataTextview() {
        var name = nameEt.text.toString()

        var tvResult: TextView = findViewById(R.id.tvResult)
        tvResult.setText(name)
        Toast.makeText(this, "welcome to android", Toast.LENGTH_SHORT).show()
    }

    private fun startHomeActivity() {
        var name = nameEt.text.toString()

        var homeIntent = Intent(this, HomeActivity::class.java)
        //   homeIntent.apply { putExtra("namekey",name) }
        homeIntent.putExtra("namekey", name)
        startActivityForResult(homeIntent,123)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, resultIntent: Intent?) {
        super.onActivityResult(requestCode, resultCode, resultIntent)
        if (requestCode == 123 && resultCode == RESULT_OK){
            var tvResult: TextView = findViewById(R.id.tvResult)
            tvResult.setText(resultIntent?.getStringExtra("contactkey"))
        }
    }
}