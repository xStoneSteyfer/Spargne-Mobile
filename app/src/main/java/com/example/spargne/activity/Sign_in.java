package com.example.spargne.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.spargne.R;

public class Sign_in extends AppCompatActivity {

    EditText e_login;
    EditText e_mdp;
    Button b_signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        e_login = findViewById(R.id.signIn_editText_login);
        e_mdp = findViewById(R.id.signIn_editText_mdp);
        b_signIn = findViewById(R.id.signIn_button_signIn);
    }

    public void goToAccueil(View v){
        Intent i = new Intent(Sign_in.this, Accueil.class);
        startActivity(i);
    }
}