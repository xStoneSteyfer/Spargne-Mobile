package com.example.spargne.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.spargne.R;
import com.example.spargne.entity.Login;
import com.example.spargne.model.RetrofitError;
import com.example.spargne.model.RetrofitRequest;
import com.example.spargne.model.Singleton;
import com.example.spargne.entity.User;
import com.example.spargne.entity.Token;
import com.example.spargne.interfaces.WebServicesInterface;
import com.example.spargne.popup.Loading_popup;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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

    public void onClickSignIn(View v){
        Login login = new Login(e_login.getText().toString(), e_mdp.getText().toString());

        RetrofitRequest retrofitRequest = new RetrofitRequest();
        retrofitRequest.getUserByUuid(this, Accueil.class, login);
    }
}