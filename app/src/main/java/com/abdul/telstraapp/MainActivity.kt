package com.abdul.telstraapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var person:Person
    lateinit var nameEt: EditText
    var TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG,"oncreate")
        setContentView(R.layout.activity_main)
        person = Person("abdul",321)
        nameEt = findViewById(R.id.etName)
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG,"onstart")

    }

    override fun onPause() {
        super.onPause()
        Log.v(TAG,"onpause")

    }

    override fun onResume() {
        super.onResume()
        Log.w(TAG,"onresume")

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onstop")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG,"ondestroy")

    }


    fun clickHandler(view: View) {
        //throw NullPointerException("clickhandler")
        add(10,20)
        when(view.id){
            R.id.button -> startHomeActivity()
            R.id.btnText -> setDataTextview()
            R.id.btnDial -> startDialer()
        }

        //setDataTextview()
       // startDialer()
    }

    fun add( a: Int, b:Int): Int {

        return a+b
    }
    private fun startDialer() {
        var dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:12345987654")) //implicit intent
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

        var homeIntent = Intent(this, HomeActivity::class.java) //explicit intent
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