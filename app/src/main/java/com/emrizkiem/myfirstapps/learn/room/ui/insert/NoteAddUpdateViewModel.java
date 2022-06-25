package com.emrizkiem.myfirstapps.learn.room.ui.insert;

import android.app.Application;

import androidx.lifecycle.ViewModel;

import com.emrizkiem.myfirstapps.learn.room.database.Note;
import com.emrizkiem.myfirstapps.learn.room.repository.NoteRepository;

public class NoteAddUpdateViewModel extends ViewModel {
    private final NoteRepository noteRepository;

    public NoteAddUpdateViewModel(Application application) {
        noteRepository = new NoteRepository(application);
    }

    public void insert(Note note) {
        noteRepository.insert(note);
    }

    public void update(Note note) {
        noteRepository.update(note);
    }

    public void delete(Note note) {
        noteRepository.delete(note);
    }
}
