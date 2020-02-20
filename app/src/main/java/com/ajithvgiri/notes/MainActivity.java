package com.ajithvgiri.notes;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ajithvgiri.notes.adapter.NotesRVAdapter;
import com.ajithvgiri.notes.service.Notes;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private NotesViewModel notesViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notesViewModel = new ViewModelProvider(this).get(NotesViewModel.class);

        final RecyclerView recyclerView = findViewById(R.id.recyclerViewNotes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        new AsyncTask<Void, Void, List<Notes>>() {

            @SuppressLint("StaticFieldLeak")
            @Override
            protected List<Notes> doInBackground(Void... voids) {
                return notesViewModel.fetchNotes();
            }

            @Override
            protected void onPostExecute(List<Notes> notes) {
                super.onPostExecute(notes);
                NotesRVAdapter notesRVAdapter = new NotesRVAdapter(notes);
                recyclerView.setAdapter(notesRVAdapter);
                notesRVAdapter.notifyDataSetChanged();
            }
        }.execute();


    }


}
