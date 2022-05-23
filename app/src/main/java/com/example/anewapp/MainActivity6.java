package com.example.anewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity6 extends AppCompatActivity {
    RadioButton rb10 , rb11, rb12;
    Button continue4 , precedent2;
    TextView score4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        Intent actual_page = getIntent();

        rb10 = findViewById(R.id.bb10);
        rb11 = findViewById(R.id.bb11);
        rb12 = findViewById(R.id.bb12);
        continue4 = findViewById(R.id.continuer4);
        precedent2 = findViewById(R.id.arriere2);
        score4 = findViewById(R.id.score24);
        //int score = actual_page.getIntExtra("sco", 0);
       // score4.setText(score); // affichage du score précédent
        continue4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score = actual_page.getIntExtra("sco", 0);
                int scoreone = 0;
                if(rb11.isChecked() && rb12.isChecked())
                {
                    scoreone ++;
                }
                else
                {
                    if( rb10.isChecked())
                    {
                        scoreone = 0 ;
                    }
                }
                score += scoreone;
                score4.setText(" Score :"+score);
                Intent aNewPage = new Intent(MainActivity6.this , MainActivity7.class);
                aNewPage.putExtra("sco",score);
                startActivity(aNewPage);
            }
        });

        precedent2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent NewPg = new Intent(MainActivity6.this , MainActivity5.class);
                startActivity(NewPg);
            }
        });
    }
}