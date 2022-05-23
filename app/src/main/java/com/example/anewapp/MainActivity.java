package com.example.anewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView monMessage ;
    EditText monLogin , monPassword ;
    Button  maConnexion , monInscription;
    NewBase newBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent actual_page = getIntent();
        monMessage = findViewById(R.id.message);
        monLogin = findViewById(R.id.login);
        monPassword  = findViewById(R.id.password);
        maConnexion = findViewById(R.id.connexion);
        monInscription = findViewById(R.id.inscription);
        newBase = new NewBase(this);
        maConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = monLogin.getText().toString();
                String password = monPassword.getText().toString();
                 String VerifyLogin = newBase.recupLoginFromConnexion(login);
                 String VerifyPassword = newBase.recupPassFromConnexion(login);
                 if(!(login.equals(VerifyLogin)) || !password.equals(VerifyPassword))
                 {
                     monMessage.setText("Login et/ou Password incorrect(s)");
                 }
                 else //  pour vérifier que le login et le mot de passe soient égals aux login  et mot de passe insérés dans la base par l'utilisateur
                 {
                         Intent new_page = new Intent(MainActivity.this, MainActivity3.class);
                         new_page.putExtra("log" , login);
                         startActivity(new_page);
                         finish();

                 }
            }
        });

        monInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent new_page = new Intent(MainActivity.this , MainActivity2.class);
                startActivity(new_page);
                finish();
            }
        });

    }
}