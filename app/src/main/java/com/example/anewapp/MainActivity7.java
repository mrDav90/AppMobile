package com.example.anewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity7 extends AppCompatActivity {

    RadioButton rb13 , rb14, rb15;
    Button continue5 , precedent3;
    TextView score5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        Intent actual_page = getIntent();

        rb13 = findViewById(R.id.bb13);
        rb14 = findViewById(R.id.bb14);
        rb15 = findViewById(R.id.bb15);
        continue5 = findViewById(R.id.continuer5);
        precedent3 = findViewById(R.id.arriere3);
        score5 = findViewById(R.id.score25);
       // int score = actual_page.getIntExtra("sco", 0);
        //score5.setText(score); // affichage du score précédent
        continue5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score = actual_page.getIntExtra("sco", 0);
                int scoreone = 0;
                if(rb14.isChecked())
                {
                    scoreone ++;
                }
                else
                {
                    if( rb13.isChecked() || rb15.isChecked())
                    {
                        scoreone = 0 ;
                    }
                }
                score += scoreone;
                score5.setText(" Score :"+score);
                Intent aNewPage = new Intent(MainActivity7.this , ScoreView.class);
                aNewPage.putExtra("sco",score);
                startActivity(aNewPage);
            }
        });

        precedent3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent NewPg = new Intent(MainActivity7.this , MainActivity6.class);
                startActivity(NewPg);
            }
        });
    }
}