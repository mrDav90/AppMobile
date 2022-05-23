package com.example.anewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreView extends AppCompatActivity {

    TextView affiche;
    TextView affichage;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_affichage);
        Intent myActualPage = getIntent();

        int score = myActualPage.getIntExtra("sco", 0);
        affiche = findViewById(R.id.scorefinale);
        affichage = findViewById(R.id.emojiaff);
        String scoreS = String.valueOf(score);

        switch (scoreS)
        {
            case "0": affiche.setText("Score Final :"+scoreS+"/5 ");
                affichage.setText("No No No!\uD83D\uDE31");
                break;
            case "1": affiche.setText("Score Final :"+scoreS+"/5 ");
                      affichage.setText("Bad!\uD83D\uDE31");
            break;
            case "2":affiche.setText("Score Final :"+scoreS+"/5");
                     affichage.setText("Médiocre! \uD83D\uDE0F");
            break;
            case "3":  affiche.setText("Score Final :"+scoreS+"/5 ");
                         affichage.setText("Pas mal!\uD83D\uDE42 ");
                break;
            case "4":  affiche.setText("Score Final :"+scoreS+"/5 ");
                     affichage.setText("Bien !\uD83D\uDE0A");
                     break;
            case "5":  affiche.setText("Score Final :"+scoreS+"/5 ");
                affichage.setText("Waooh Congratulations !\uD83D\uDE48");  break;
        }

    }
}