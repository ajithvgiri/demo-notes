package com.ajithvgiri.notes.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.ajithvgiri.notes.service.Notes;

@Database(entities = {Notes.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NotesDao notesDao();

    public static AppDatabase appDatabase = null;

    public static AppDatabase getInstance(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context, AppDatabase.class, "notes.db").build();
        }
        return appDatabase;
    }
}