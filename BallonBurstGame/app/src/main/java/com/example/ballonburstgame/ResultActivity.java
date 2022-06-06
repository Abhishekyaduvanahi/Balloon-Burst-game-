package com.example.ballonburstgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView textViewInfo, textViewScore , textViewHighestScore;

    private Button  buttonPlayAgain ,buttonQuitGame;

    int myScore;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textViewHighestScore = findViewById(R.id.textViewTimeScore);
        textViewScore = findViewById(R.id.textViewMyScore);
        textViewInfo = findViewById(R.id.textViewInfo);

        buttonPlayAgain = findViewById(R.id.buttonPlayAgain);
        buttonQuitGame = findViewById(R.id.buttonQuitGame);


        myScore = getIntent().getIntExtra("score",0);
        textViewScore.setText("Your Score : "+myScore);

        sharedPreferences = this.getSharedPreferences("score", Context.MODE_PRIVATE);
        int highestScore = sharedPreferences.getInt("highestScore",0);

//        if(myScore >= highestScore)
//        {
//            sharedPreferences.edit().putInt("highestScore",myScore).apply();
//            textViewHighestScore.setText("Highest Score : "+myScore);
//        }
//
//        else
//        {
//            textViewHighestScore.setText("Highest Score : "+highestScore);
//        }

        buttonPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonQuitGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(0);

            }
        });
    }
}