package com.example.anewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
TextView petitMessage;
EditText monNom , monPrenom  , monLogin1 , monPassword1 , monConfirmPassword;
Button maValidation , boutonConnexion;
NewBase newBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent actual_page = getIntent();

        petitMessage = findViewById(R.id.petitmessage);
        monNom = findViewById(R.id.nom);
        monPrenom = findViewById(R.id.prenom);
        monLogin1 = findViewById(R.id.login1);
        monPassword1 = findViewById(R.id.password1);
        monConfirmPassword = findViewById(R.id.confirmpassword);
        maValidation = findViewById(R.id.valider);
        boutonConnexion= findViewById(R.id.pageConnexion);
        newBase = new NewBase(this);

        maValidation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = monNom.getText().toString();
                String firstname = monPrenom.getText().toString();
                String myLogin = monLogin1.getText().toString();
                String myPass  = monPassword1.getText().toString();
                String myConfirmPass = monConfirmPassword.getText().toString();
                newBase.insertInConnexion(name,firstname,myLogin,myPass,myConfirmPass);
                newBase.close();
                petitMessage.setText("Données Insérées !");
            }
        });

        boutonConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent new_page = new Intent(MainActivity2.this , MainActivity.class);
                startActivity(new_page);
                finish();
            }
        });
    }
}