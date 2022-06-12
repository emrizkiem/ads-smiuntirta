package com.emrizkiem.myfirstapps.learn.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.emrizkiem.myfirstapps.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Lifecycle Activity", "onCreate is running");
        setContentView(R.layout.activity_main);

        Button btnClickMe = findViewById(R.id.btnClickMe);

        // Listener for event click
        btnClickMe.setOnClickListener((View v) -> {
            // Intent Explicit
            Intent moveToDetail = new Intent(MainActivity.this, DetailActivity.class);
            startActivity(moveToDetail);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycle Activity", "onStart is running");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycle Activity", "onResume is running");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lifecycle Activity", "onPause is running");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle Activity", "onStop is running");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycle Activity", "onDestroy is running");
    }

    public void displayToast(String msg) {
        // Ini yg ribet
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();

        // Lebih simple
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    public void onClickBtn(View v) {
        displayToast("Saya di klik :)");
    }

    // Listener for event another way, but must implement View.OnClickListener on Class
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnClickMe) {

        }
    }
}