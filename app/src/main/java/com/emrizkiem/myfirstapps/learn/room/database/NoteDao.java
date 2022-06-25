package com.emrizkiem.myfirstapps.learn.room.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Note note); // Add data

    @Update()
    void update(Note note); // Update data

    @Delete()
    void delete(Note note); // Delete data

    @Query("SELECT * from note ORDER BY id ASC")
    LiveData<List<Note>> getAllNotes(); // Get/Read data
}
