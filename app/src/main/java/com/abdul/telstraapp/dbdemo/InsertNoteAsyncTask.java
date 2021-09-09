package com.abdul.telstraapp.dbdemo;

import android.os.AsyncTask;

public class InsertNoteAsyncTask extends AsyncTask<Void,Void,Void> {
    Note mNote;
    NoteDao mNoteDao;

    public InsertNoteAsyncTask(Note note, NoteDao noteDao) {
        mNote = note;
        mNoteDao = noteDao;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        return mNoteDao.insert(mNote);
    }
}
