package com.ajithvgiri.notes;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.ajithvgiri.notes.database.NotesRepository;
import com.ajithvgiri.notes.service.Notes;

import java.util.List;

public class NotesViewModel extends AndroidViewModel {
    public NotesViewModel(@NonNull Application application) {
        super(application);
    }

    NotesRepository notesRepository = new NotesRepository(getApplication());

    public List<Notes> fetchNotes() {
        notesRepository.fetchNotesFromServer();
        return notesRepository.getNotes();
    }

    public void updateNote(Notes notes) {
        notesRepository.updateNote(notes);
    }
}

