package com.ajithvgiri.notes.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.ajithvgiri.notes.NotesViewModel;
import com.ajithvgiri.notes.R;
import com.ajithvgiri.notes.service.Notes;

public class NoteEditActivity extends AppCompatActivity {

    private NotesViewModel notesViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_edit);

        notesViewModel = new ViewModelProvider(this).get(NotesViewModel.class);

        Button cancel = findViewById(R.id.buttonCancel);
        Button save = findViewById(R.id.buttonSave);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        save.setOnClickListener(v -> {
            //notesViewModel.updateNote();
            finish();
        });


    }


}
