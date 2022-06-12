package com.emrizkiem.myfirstapps.learn.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.emrizkiem.myfirstapps.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Lifecycle Activity Detail", "onCreate is running");
        setContentView(R.layout.activity_detail);

        // For implement fragment
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        MainFragment mainFragment = new MainFragment();
//        Fragment fragment = fragmentManager.findFragmentByTag(MainFragment.class.getSimpleName());
//
//        if (!(fragment instanceof MainFragment)) {
//            fragmentManager
//                    .beginTransaction()
//                    .add(R.id.frameLayout, mainFragment, MainFragment.class.getSimpleName())
//                    .commit();
//        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycle Activity Detail", "onStart is running");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycle Activity Detail", "onResume is running");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lifecycle Activity Detail", "onPause is running");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle Activity Detail", "onStop is running");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycle Activity Detail", "onDestroy is running");
    }
}