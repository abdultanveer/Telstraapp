package com.abdul.telstraapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.abdul.telstraapp.dbdemo.InsertNoteAsyncTask
import com.abdul.telstraapp.dbdemo.Note
import com.abdul.telstraapp.dbdemo.NoteDao
import com.abdul.telstraapp.dbdemo.NoteDb

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
}