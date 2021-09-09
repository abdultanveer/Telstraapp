package com.abdul.telstraapp.dbdemo;

import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public interface NoteDao {
    @Insert
    Void insert(Note note);

    @Query("SELECT * FROM Note WHERE title LIKE :note ")
    List<Note> findNote(Note note);

    @Query("SELECT * from Note ORDER BY title ASC")
    List<Note> getAllNotes();

    @Update
    void update(Note note);

    @Query("DELETE FROM Word")
    void deleteAllNotes();
}
