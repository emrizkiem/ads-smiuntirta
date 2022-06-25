package com.emrizkiem.myfirstapps.learn.room.utils;

import androidx.recyclerview.widget.DiffUtil;

import com.emrizkiem.myfirstapps.learn.room.database.Note;

import java.util.List;

// This class for checking changes list notes.
public class NoteDiffCallback extends DiffUtil.Callback {

    private final List<Note> oldList;
    private final List<Note> newList;

    public NoteDiffCallback(List<Note> oldList, List<Note> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getId() == newList.get(newItemPosition).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        final Note old = oldList.get(oldItemPosition);
        final Note news = newList.get(newItemPosition);

        return old.getTitle().equals(news.getTitle()) && old.getDescription().equals(news.getDescription());
    }
}
