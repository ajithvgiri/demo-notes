package com.ajithvgiri.notes.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.ajithvgiri.notes.R;
import com.ajithvgiri.notes.service.Notes;
import java.util.List;

public class NotesRVAdapter extends RecyclerView.Adapter<NotesRVAdapter.NotesViewHolder> {

    private List<Notes> notes;
    private Context context;

    public NotesRVAdapter(List<Notes> notes) {
        this.notes = notes;
    }



    public static class NotesViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;

        public NotesViewHolder(View v) {
            super(v);
            title = v.findViewById(R.id.textViewTitle);

        }
    }


    @Override
    public NotesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recycler_notes, parent, false);
        return new NotesViewHolder(view);
    }


    @Override
    public void onBindViewHolder(NotesViewHolder holder, final int position) {
        holder.title.setText(notes.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}