package com.emrizkiem.myfirstapps.learn.room.utils;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.emrizkiem.myfirstapps.learn.room.ui.insert.NoteAddUpdateViewModel;
import com.emrizkiem.myfirstapps.learn.room.ui.main.RoomViewModel;

// This class for call context ViewModel in Activity.
public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private static volatile ViewModelFactory INSTANCE;
    private final Application mApplication;

    private ViewModelFactory(Application application) {
        mApplication = application;
    }

    public static ViewModelFactory getInstance(Application application) {
        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                INSTANCE = new ViewModelFactory(application);
            }
        }
        return INSTANCE;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(RoomViewModel.class)) {
            return (T) new RoomViewModel(mApplication);
        } else if (modelClass.isAssignableFrom(NoteAddUpdateViewModel.class)) {
            return (T) new NoteAddUpdateViewModel(mApplication);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
