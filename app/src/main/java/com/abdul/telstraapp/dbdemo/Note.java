package com.abdul.telstraapp.dbdemo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Note {
    @PrimaryKey(autoGenerate=true)
    int nid;
    @ColumnInfo
    String title;
    @ColumnInfo
    String notes;

    public Note(String title, String notes) {
        this.title = title;
        this.notes = notes;
    }
}
