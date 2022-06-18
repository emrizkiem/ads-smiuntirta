package com.emrizkiem.myfirstapps.learn.intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.emrizkiem.myfirstapps.R;
import com.emrizkiem.myfirstapps.implement.game.GameActivity;

public class IntentActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int pictureId = 1;
    ImageView imgCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        Button btnDial = findViewById(R.id.btnDial);
        Button btnCamera = findViewById(R.id.btnCamera);
        Button btnGame = findViewById(R.id.btnGame);
        imgCamera = findViewById(R.id.imgResultCamera);

        /*
            First step
            Example intent implicit
         */
        btnDial.setOnClickListener((View v) -> {
            String phoneNumber = "087771234567";
            Intent dialPhone = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
            startActivity(dialPhone);
        });

        // Example intent implicit
        btnCamera.setOnClickListener((View v) -> {
            Intent openCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(openCamera, pictureId);
        });

        btnGame.setOnClickListener((View v) -> {
            Intent moveToGame = new Intent(IntentActivity.this, GameActivity.class);
            startActivity(moveToGame);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == pictureId) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");

            imgCamera.setImageBitmap(photo);
        }
    }

    // Second step
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnDial) {
        }
    }
}