package com.nokopi.meikoenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class result extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView result_tv = findViewById(R.id.resulttv);
        int score = getIntent().getIntExtra("RIGHT_ANSWER_COUNT", 0);
        result_tv.setText(getString(R.string.result_score, score));
    }

    public void returnTop(View view){
        startActivity(new Intent(result.this, MainActivity.class));
    }
}