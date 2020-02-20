package com.ajithvgiri.notes.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.ajithvgiri.notes.service.Notes;
import java.util.List;

@Dao
public interface NotesDao {
    @Query("SELECT * FROM notes")
    List<Notes> getAll();

    @Insert
    void insertAll(List<Notes> notes);

    @Update
    void updateNote(Notes notes);
}
