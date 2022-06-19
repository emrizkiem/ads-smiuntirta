package com.emrizkiem.myfirstapps.implement.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.emrizkiem.myfirstapps.R;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView input, output;
    Button rock, paper, scissors;
    int[] images = new int[]{
            R.drawable.rock, // 0
            R.drawable.paper, // 1
            R.drawable.scissors // 2
    };
    int userInput = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        input = (ImageView) findViewById(R.id.iv_input);
        output = (ImageView) findViewById(R.id.iv_output);
        rock = (Button) findViewById(R.id.btn_rock);
        paper = (Button) findViewById(R.id.btn_paper);
        scissors = (Button) findViewById(R.id.btn_scissors);

        rock.setOnClickListener(this);
        paper.setOnClickListener(this);
        scissors.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_rock:
                userInput = 1;
                input.setBackgroundResource(R.drawable.rock);
                setOutput();
                break;
            case R.id.btn_paper:
                userInput = 2;
                input.setBackgroundResource(R.drawable.paper);
                setOutput();
                break;
            case R.id.btn_scissors:
                userInput = 3;
                input.setBackgroundResource(R.drawable.scissors);
                setOutput();
                break;
        }
    }

    private void setOutput() {
        int imageId = (int) (Math.random() * images.length);
        output.setBackgroundResource(images[imageId]);
        checkResult(imageId);
    }

    private void checkResult(int imageId) {
        if (userInput == 1 && imageId == 0) {     //User choose Rock, Computer choose Rock
            showResult(2);
        } else if (userInput == 1 && imageId == 1) { //User choose Rock, Computer choose Paper
            showResult(0);
        } else if (userInput == 1 && imageId == 2) { //User choose Rock, Computer choose Scissors
            showResult(1);
        } else if (userInput == 2 && imageId == 0) { //User choose Paper, Computer choose Rock
            showResult(1);
        } else if (userInput == 2 && imageId == 1) { //User choose Paper, Computer choose Paper
            showResult(2);
        } else if (userInput == 2 && imageId == 2) { //User choose Paper, Computer choose Scissors
            showResult(0);
        } else if (userInput == 3 && imageId == 0) {//User choose Scissors, Computer choose Rock
            showResult(0);
        } else if (userInput == 3 && imageId == 1) { //User choose Scissors, Computer choose Paper
            showResult(1);
        } else if (userInput == 3 && imageId == 2) { //User choose Scissors, Computer choose Scissors
            showResult(2);
        }
    }

    private void showResult(int result) {
        if (result == 0) {
            Toast toastLost = new Toast(getApplicationContext());
            // Set layout custom toast error
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.custom_toast_error, findViewById(R.id.toastError));
            // Set id textview and set text for message Toast lost
            TextView textView = layout.findViewById(R.id.tvMessage);
            textView.setText("Oh! You Lost :(");

            toastLost.setDuration(Toast.LENGTH_SHORT);
            toastLost.setGravity(Gravity.TOP, 0, 0); // Set toast to top
            toastLost.setView(layout);
            toastLost.show();
        } else if (result == 1) {
            Toast toastWin = new Toast(getApplicationContext());
            // Set layout custom toast success
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.custom_toast_success, findViewById(R.id.toastSuccess));
            // Set id textview and set text for message Toast win
            TextView textView = layout.findViewById(R.id.tvMessage);
            textView.setText("You Won! Yeah! :)");

            toastWin.setDuration(Toast.LENGTH_SHORT);
            toastWin.setView(layout);
            toastWin.show();
        } else {
            Toast.makeText(this, "OOPS! It's a Tie! :P", Toast.LENGTH_SHORT).show();
        }
    }
}