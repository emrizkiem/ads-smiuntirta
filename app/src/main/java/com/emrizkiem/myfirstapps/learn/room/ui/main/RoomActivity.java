package com.emrizkiem.myfirstapps.learn.room.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.emrizkiem.myfirstapps.R;
import com.emrizkiem.myfirstapps.databinding.ActivityRoomBinding;
import com.emrizkiem.myfirstapps.learn.room.ui.insert.NoteAddUpdateActivity;
import com.emrizkiem.myfirstapps.learn.room.ui.main.adapter.NoteAdapter;
import com.emrizkiem.myfirstapps.learn.room.utils.ViewModelFactory;

public class RoomActivity extends AppCompatActivity {

    private ActivityRoomBinding binding;
    private NoteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRoomBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        RoomViewModel viewModel = obtainViewModel(RoomActivity.this);
        viewModel.getAllNotes().observe(this, notes -> {
            if (notes != null) {
                adapter.setListNote(notes);
            }
        });

        adapter = new NoteAdapter();

        binding.rvNotes.setLayoutManager(new LinearLayoutManager(this));
        binding.rvNotes.setHasFixedSize(true);
        binding.rvNotes.setAdapter(adapter);

        binding.fabAdd.setOnClickListener(view -> {
            Intent intent = new Intent(RoomActivity.this, NoteAddUpdateActivity.class);
            startActivity(intent);
        });
    }

    private RoomViewModel obtainViewModel(AppCompatActivity activity) {
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return new ViewModelProvider(activity, factory).get(RoomViewModel.class);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}