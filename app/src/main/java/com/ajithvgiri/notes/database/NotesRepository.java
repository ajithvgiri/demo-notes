package com.ajithvgiri.notes.database;

import android.content.Context;
import android.util.Log;

import com.ajithvgiri.notes.service.ApiClient;
import com.ajithvgiri.notes.service.ApiInterface;
import com.ajithvgiri.notes.service.Notes;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotesRepository {

    ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
    Context context;
    AppDatabase appDatabase;

    public NotesRepository(Context context) {
        this.context = context;
        this.appDatabase = AppDatabase.getInstance(context);
    }


    public void fetchNotesFromServer() {
        Call<List<Notes>> call = apiService.getNotes();
        call.enqueue(new Callback<List<Notes>>() {
            @Override
            public void onResponse(Call<List<Notes>> call, Response<List<Notes>> response) {
                if (response.isSuccessful()) {
                    List<Notes> notes = response.body();
                    appDatabase.notesDao().insertAll(notes);
                    for (int i = 0; i < notes.size(); i++) {
                        Log.d("TAG", "Number of notes received: " + notes.get(i).getTitle());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Notes>> call, Throwable t) {
                // Log error here since request failed
                Log.e("TAG", t.toString());
            }
        });
    }

    public List<Notes> getNotes(){
        return appDatabase.notesDao().getAll();
    }

    public void updateNote(Notes notes){
        appDatabase.notesDao().updateNote(notes);
    }
}
