package com.nokopi.meikoenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView main_tv;
    Button main_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_tv = findViewById(R.id.maintv);
        main_tv.setText("品詞学習");

        main_button = findViewById(R.id.mainbutton);
        main_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Menu = new Intent(MainActivity.this, menu.class);
                startActivity(Menu);
            }
        });
    }
}