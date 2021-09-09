package com.abdul.telstraapp.dbdemo;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {Note.class}, version = 1)
public abstract class NoteDb extends RoomDatabase {

    public abstract NoteDao noteDao();

    private static NoteDb INSTANCE;

    public static NoteDb getNoteDb(Context context) {
        if (INSTANCE == null) {
            synchronized (NoteDb.class) {
                INSTANCE = Room.databaseBuilder(context,NoteDb.class, "notedb")
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }
        return INSTANCE;
    }


}
