package com.abdul.telstraapp

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleCursorAdapter

class ContentProviderActivity : AppCompatActivity() {
    lateinit var cpListview: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_provider)
        cpListview = findViewById(R.id.cpListview)

        var pathDbTable = Uri.parse("content://sms/inbox")
        var dataCursor = contentResolver.query(pathDbTable, null, null, null, null)

        var columnNames = arrayOf("body")
        var textviewIds = intArrayOf(android.R.id.text1)

        var adapter = SimpleCursorAdapter(
            this,
            android.R.layout.simple_list_item_1, //row layout
            dataCursor,                         //data
            columnNames,                    //column name of inbox
            textviewIds                     //id textview in row layout
        );
        cpListview.adapter = adapter
    }
}