package com.emrizkiem.myfirstapps.learn.room.ui.main.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.emrizkiem.myfirstapps.databinding.ItemNoteBinding;
import com.emrizkiem.myfirstapps.learn.room.database.Note;
import com.emrizkiem.myfirstapps.learn.room.ui.insert.NoteAddUpdateActivity;
import com.emrizkiem.myfirstapps.learn.room.utils.NoteDiffCallback;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {
    private final ArrayList<Note> listNote = new ArrayList<>();

    public void setListNote(List<Note> listNote) {
        final NoteDiffCallback diffCallback = new NoteDiffCallback(this.listNote, listNote);
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);

        this.listNote.clear();
        this.listNote.addAll(listNote);
        diffResult.dispatchUpdatesTo(this);
    }

    @NonNull
    @Override
    public NoteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemNoteBinding binding = ItemNoteBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.ViewHolder holder, int position) {
        holder.bindView(listNote.get(position));
    }

    @Override
    public int getItemCount() {
        return listNote.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final ItemNoteBinding binding;

        public ViewHolder(ItemNoteBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindView(Note note) {
            binding.tvItemTitle.setText(note.getTitle());
            binding.tvItemDescription.setText(note.getDescription());
            binding.tvItemDate.setText(note.getDate());

            binding.cvItemNote.setOnClickListener(v -> {
                Intent intent = new Intent(v.getContext(), NoteAddUpdateActivity.class);
                intent.putExtra(NoteAddUpdateActivity.EXTRA_NOTE, note);
                v.getContext().startActivity(intent);
            });
        }
    }
}
