package com.example.anewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity5 extends AppCompatActivity {

    RadioButton rb7 , rb8, rb9;
    Button continue3 , precedent1;
    TextView score3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Intent actual_page = getIntent();

        rb7 = findViewById(R.id.bb7);
        rb8 = findViewById(R.id.bb8);
        rb9 = findViewById(R.id.bb9);
        continue3 = findViewById(R.id.continuer3);
        precedent1 = findViewById(R.id.arriere1);
        score3 = findViewById(R.id.score23);
        //int score = actual_page.getIntExtra("sco", 0);
       // score3.setText(score); // affichage du score précédent
        continue3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score = actual_page.getIntExtra("sco", 0);
                int scoreone = 0;
                if(rb9.isChecked())
                {
                    scoreone ++;
                }
                else
                {
                    if( rb7.isChecked() ||  rb8.isChecked() )
                    {
                        scoreone = 0 ;
                    }
                }
                score += scoreone;
                score3.setText(" Score :"+score);
                Intent aNewPage = new Intent(MainActivity5.this , MainActivity6.class);
                aNewPage.putExtra("sco",score);
                startActivity(aNewPage);
            }
        });

        precedent1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent NewPg = new Intent(MainActivity5.this , MainActivity4.class);
                startActivity(NewPg);
            }
        });
    }
}