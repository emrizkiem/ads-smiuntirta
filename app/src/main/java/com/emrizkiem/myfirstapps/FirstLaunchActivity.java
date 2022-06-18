package com.emrizkiem.myfirstapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.emrizkiem.myfirstapps.implement.game.GameActivity;
import com.emrizkiem.myfirstapps.learn.activity.DetailActivity;
import com.emrizkiem.myfirstapps.learn.activity.MainActivity;
import com.emrizkiem.myfirstapps.learn.fragment.MainFragment;
import com.emrizkiem.myfirstapps.learn.intent.IntentActivity;

public class FirstLaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_launch);

        Button btnActivity = findViewById(R.id.btnActivity);
        Button btnFragment = findViewById(R.id.btnFragment);
        Button btnIntent = findViewById(R.id.btnIntent);
        Button btnRecyclerview = findViewById(R.id.btnRecyclerView);

        // Example Intent Explicit
        btnActivity.setOnClickListener((View v) -> {
            Intent moveToActivity = new Intent(FirstLaunchActivity.this, MainActivity.class);
            startActivity(moveToActivity);
        });

        // Example Intent Explicit
        btnFragment.setOnClickListener((View v) -> {
            Intent moveToFragment = new Intent(FirstLaunchActivity.this, DetailActivity.class);
            startActivity(moveToFragment);
        });

        // Example Intent Explicit
        btnIntent.setOnClickListener((View v) -> {
            Intent moveToIntent = new Intent(FirstLaunchActivity.this, IntentActivity.class);
            startActivity(moveToIntent);
        });

        btnRecyclerview.setOnClickListener((View v) -> {

        });

//        btnGame.setOnClickListener((View v) -> {
//            Intent moveToGameActivity = new Intent(FirstLaunchActivity.this, GameActivity.class);
//            startActivity(moveToGameActivity);
//        });
    }
}