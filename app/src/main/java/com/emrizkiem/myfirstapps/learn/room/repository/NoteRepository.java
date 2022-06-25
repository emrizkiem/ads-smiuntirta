package com.emrizkiem.myfirstapps.learn.room.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.emrizkiem.myfirstapps.learn.room.database.Note;
import com.emrizkiem.myfirstapps.learn.room.database.NoteDao;
import com.emrizkiem.myfirstapps.learn.room.database.NoteRoomDatabase;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NoteRepository {
    private final NoteDao noteDao;
    private final ExecutorService executorService;

    public NoteRepository(Application application) {
        executorService = Executors.newSingleThreadExecutor();
        NoteRoomDatabase db = NoteRoomDatabase.getDatabase(application);
        noteDao = db.noteDao();
    }

    public LiveData<List<Note>> getAllNotes() {
        return noteDao.getAllNotes();
    }

    public void insert(final Note note) {
        executorService.execute(() -> noteDao.insert(note));
    }

    public void update(final Note note) {
        executorService.execute(() -> noteDao.update(note));
    }

    public void delete(final Note note) {
        executorService.execute(() -> noteDao.delete(note));
    }
}
