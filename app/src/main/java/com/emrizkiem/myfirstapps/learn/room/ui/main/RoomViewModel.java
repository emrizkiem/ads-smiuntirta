package com.emrizkiem.myfirstapps.learn.room.ui.main;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.emrizkiem.myfirstapps.learn.room.database.Note;
import com.emrizkiem.myfirstapps.learn.room.repository.NoteRepository;

import java.util.List;

public class RoomViewModel extends ViewModel {
    private final NoteRepository noteRepository;

    public RoomViewModel(Application application) {
        noteRepository = new NoteRepository(application);
    }

    LiveData<List<Note>> getAllNotes() {
        return noteRepository.getAllNotes();
    }
}
