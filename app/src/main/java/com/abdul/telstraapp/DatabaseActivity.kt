package com.abdul.telstraapp

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.abdul.telstraapp.db.InsertTask
import com.abdul.telstraapp.db.Word
import com.abdul.telstraapp.db.WordDao
import com.abdul.telstraapp.db.WordRoomDb

class DatabaseActivity : AppCompatActivity() {

    lateinit var roomDb: WordRoomDb
    lateinit var wordDao: WordDao
    lateinit var etOne: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database)
        etOne = findViewById(R.id.etOne)


        roomDb = WordRoomDb.getDatabase(this)
        wordDao = roomDb.wordDao()
    }




    fun dbHandler(view: View) {

        insertWordAsynchronously()
    }

    private fun insertWordAsynchronously() {
        var data = etOne.text.toString()
        var word = Word(data)
        var insertTask = InsertTask(wordDao, word)
        insertTask.execute()


    }
}