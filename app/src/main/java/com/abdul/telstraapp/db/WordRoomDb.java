package com.abdul.telstraapp.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {Word.class}, version = 1)
public abstract class WordRoomDb extends RoomDatabase {
    public abstract WordDao wordDao();

    private static WordRoomDb INSTANCE;


    public static WordRoomDb getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WordRoomDb.class) {
                if (INSTANCE == null)    {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            WordRoomDb.class, "word_database")
                           // .addCallback(sOnOpenCallback)
                            .fallbackToDestructiveMigration()
                            .build();
                }}}
        return INSTANCE;
    }



}