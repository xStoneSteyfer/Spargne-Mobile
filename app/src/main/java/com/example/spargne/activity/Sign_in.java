package com.example.spargne.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.spargne.R;
import com.example.spargne.entity.Singleton;
import com.example.spargne.entity.EtatRetrofit;
import com.example.spargne.interfaces.WebServicesInterface;
import com.example.spargne.popup.Loading_popup;

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
        popupLoading = new Loading_popup(this);
        popupLoading.build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Singleton.getInstance().getBaseUrl()).addConverterFactory(GsonConverterFactory.create()).build();
        WebServicesInterface webServicesInterface = retrofit.create(WebServicesInterface.class);
        Call<EtatRetrofit> connexion = webServicesInterface.connexion(e_login.getText().toString(), e_mdp.getText().toString());
        connexion.enqueue(new Callback<EtatRetrofit>() {
            @Override
            public void onResponse(Call<EtatRetrofit> call, Response<EtatRetrofit> response) {
                if (response.body() != null) {
                    if (response.body().getEtat().equals("success")) {
                        afterApiResponse(response.body());
                        popupLoading.dismiss();
                    } else {
                        Toast.makeText(Sign_in.this, response.body().getException(), Toast.LENGTH_SHORT).show();
                        popupLoading.dismiss();
                    }
                } else {
                    Toast.makeText(Sign_in.this, "Erreur connexion", Toast.LENGTH_SHORT).show();
                    popupLoading.dismiss();
                }
            }

            @Override
            public void onFailure(Call<EtatRetrofit> call, Throwable t) {
                Toast.makeText(Sign_in.this, "Erreur connexion", Toast.LENGTH_SHORT).show();
                popupLoading.dismiss();
            }
        });
    }

    public void afterApiResponse(EtatRetrofit responseBody){
        Intent i = new Intent(Sign_in.this, Accueil.class);
        startActivity(i);
    }
}