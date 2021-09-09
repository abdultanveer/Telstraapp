package com.abdul.telstraapp.dbdemo;

import android.os.AsyncTask;
import android.widget.TextView;

import com.abdul.telstraapp.dbdemo.Note;
import com.abdul.telstraapp.dbdemo.NoteDao;

import org.w3c.dom.Text;

import java.util.List;

public class GetNoteAsyncTask extends AsyncTask<Void,Void,List<Note>> {
    String mtitle;
    NoteDao mNoteDao;
    TextView mTextview;

    public GetNoteAsyncTask(String title, NoteDao noteDao, TextView dbTextview) {
        mtitle = title;
        mNoteDao = noteDao;
        mTextview = dbTextview;
    }

    @Override
    protected List<Note> doInBackground(Void... voids) {

        return mNoteDao.findNote(mtitle);
    }

    @Override
    protected void onPostExecute(List<Note> notes) {
        super.onPostExecute(notes);
        mTextview.setText(notes.get(0).title+"\n"+notes.get(0).notes);
    }
}
