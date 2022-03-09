package com.example.spargne.model;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.spargne.activity.Accueil;
import com.example.spargne.activity.Sign_in;
import com.example.spargne.entity.Login;
import com.example.spargne.entity.Token;
import com.example.spargne.entity.User;
import com.example.spargne.interfaces.WebServicesInterface;
import com.example.spargne.popup.Loading_popup;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRequest {

    Loading_popup popupLoading;

    public void requestGetToken(Activity activity, Login login)
    {
        popupLoading = new Loading_popup(activity);
        popupLoading.build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Singleton.getInstance().BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        WebServicesInterface webServicesInterface = retrofit.create(WebServicesInterface.class);
        Call<Token> getToken = webServicesInterface.getToken(login);
        getToken.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                if (response.body() != null) {
                    Singleton.getInstance().setToken("Bearer " + response.body().getToken());
                    popupLoading.dismiss();
                } else {
                    Gson gson = new Gson();
                    RetrofitError error = gson.fromJson(response.errorBody().charStream(), RetrofitError.class);
                    Toast.makeText(activity, error.getMessage(), Toast.LENGTH_SHORT).show();
                    popupLoading.dismiss();
                }
            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                Toast.makeText(activity, "Error connection", Toast.LENGTH_SHORT).show();
                popupLoading.dismiss();
            }
        });
    }
}
