package com.example.anewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    TextView score1 ;
    RadioButton rb1 , rb2 , rb3 ;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent actual_page = getIntent();
        score1 = findViewById(R.id.score1);
        rb1 = findViewById(R.id.b1);
        rb2 = findViewById(R.id.b2);
        rb3 = findViewById(R.id.b3);
        button = findViewById(R.id.continuer1);
        score1.setText(" Score : 0");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score=0;
                score1.setText(" Score :"+score);
                if(rb2.isChecked())
                {
                    score ++;
                }
                else
                {
                    if(rb1.isChecked() || rb3.isChecked())
                    {
                        score = 0;

                    }
                }

                score1.setText(" Score :"+score);
                Intent new_page = new Intent( MainActivity3.this , MainActivity4.class);
                new_page.putExtra("sco",score);
                startActivity(new_page);
            }


        });

    }

}