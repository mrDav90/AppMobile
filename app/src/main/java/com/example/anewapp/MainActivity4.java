package com.example.anewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {
    RadioButton rb4 , rb5 , rb6;
    Button continue2 , precedent;
    TextView score2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Intent actual_page = getIntent();

        rb4 = findViewById(R.id.bb4);
        rb5 = findViewById(R.id.bb5);
        rb6 = findViewById(R.id.bb6);
        continue2 = findViewById(R.id.continuer2);
        precedent = findViewById(R.id.arriere);
        score2 = findViewById(R.id.score22);
       // int score = actual_page.getIntExtra("sco", 0);
       // score2.setText(score); // affichage du score précédent
        continue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score = actual_page.getIntExtra("sco", 0);
                int scoreone = 0;
                if(rb4.isChecked() && rb5.isChecked())
                {
                    scoreone ++;
                }
                else
                {
                    if( rb6.isChecked() )
                    {
                        scoreone = 0 ;
                    }
                }
                score += scoreone;
                score2.setText(" Score :"+score);
                Intent aNewPage = new Intent(MainActivity4.this , MainActivity5.class);
                aNewPage.putExtra("sco",score);
                startActivity(aNewPage);
            }
        });

        precedent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent NewPg = new Intent(MainActivity4.this , MainActivity3.class);
                startActivity(NewPg);
            }
        });
    }
}