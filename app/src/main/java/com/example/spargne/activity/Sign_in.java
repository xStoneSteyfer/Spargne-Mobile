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
import com.example.spargne.model.Singleton;
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

    Loading_popup popupLoading;

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
        Singleton.getInstance().clear();

        Login login = new Login(e_login.getText().toString(), e_mdp.getText().toString());
        Singleton.getInstance().setLogin(login);

        popupLoading = new Loading_popup(this);
        popupLoading.build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Singleton.getInstance().BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        WebServicesInterface webServicesInterface = retrofit.create(WebServicesInterface.class);
        Call<Token> getToken = webServicesInterface.getToken(login);
        getToken.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                if (response.body() != null) {
                    Singleton.getInstance().setToken("Bearer " + response.body().getToken());
                    Singleton.getInstance().getLogin().setPassword(null);
                    Singleton.getInstance().setRequestGetUserByUuid(true);
                    Singleton.getInstance().setRequestGetAccountByUuid(true);
                    Intent i = new Intent(Sign_in.this, Accueil.class);
                    startActivity(i);
                } else {
                    Gson gson = new Gson();
                    RetrofitError error = gson.fromJson(response.errorBody().charStream(), RetrofitError.class);
                    Toast.makeText(Sign_in.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    popupLoading.dismiss();
                }
            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                Toast.makeText(Sign_in.this, "Error connection", Toast.LENGTH_SHORT).show();
                popupLoading.dismiss();
            }
        });
    }
}