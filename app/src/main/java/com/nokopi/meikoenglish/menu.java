package com.nokopi.meikoenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class menu extends AppCompatActivity {

    Button back_button, hinsi_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        back_button = findViewById(R.id.backbutton);
        back_button.setText("タイトルに戻る");
        hinsi_button = findViewById(R.id.hinsibutton);
        hinsi_button.setText("品詞");

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        hinsi_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Hinsi = new Intent(menu.this, hinsi.class);
                startActivity(Hinsi);
            }
        });
    }
}