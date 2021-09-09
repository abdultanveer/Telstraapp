package com.abdul.telstraapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.abdul.telstraapp.dbdemo.*

class DataActivity : AppCompatActivity() {
    lateinit var etTitle: EditText
    lateinit var etNotes: EditText
    lateinit var  noteDb: NoteDb
    lateinit var  noteDao: NoteDao
    lateinit var tvRes: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)
        etTitle = findViewById(R.id.etTitle)
        etNotes = findViewById(R.id.etNotes)
        tvRes = findViewById(R.id.tvDbRes)
        noteDb = NoteDb.getNoteDb(this)
        noteDao = noteDb.noteDao()
    }

    override fun onPause() {
        super.onPause()
        saveData()
    }

    private fun saveData() {
        //get the data from edittexts
        var data = etTitle.text.toString()
        //create file
        var sharedPreferences = getSharedPreferences("telstrafile", MODE_PRIVATE)
        //open the file
        var editor = sharedPreferences.edit()
        //write to the file
        editor.putString("title",data)
        //save the file contents
        editor.apply()
    }

    override fun onResume() {
        super.onResume()
        restoreData()
    }

    private fun restoreData() {
        //open the file
        var sharedPreferences = getSharedPreferences("telstrafile", MODE_PRIVATE)
        //read from the file
        var data = sharedPreferences.getString("title"," ")
        //set the data in the edittexts
        etTitle.setText(data)

    }


    fun handleDb(view: View) {
        var title = etTitle.text.toString()
        var notes = etNotes.text.toString()
        var note = Note(title,notes)
        insertNoteAsync(note)
    }

    private fun insertNoteAsync(note: Note) {
        var insertTask = InsertNoteAsyncTask(note,noteDao)
        insertTask.execute()
    }

    fun findDb(view: View) {
        var title = etTitle.text.toString()
        var getNoteAsyncTask = GetNoteAsyncTask(title,noteDao,tvRes)
        getNoteAsyncTask.execute()

    }
}