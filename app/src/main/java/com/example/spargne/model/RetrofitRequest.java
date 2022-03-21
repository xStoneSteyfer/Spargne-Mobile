package com.example.spargne.model;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.spargne.R;
import com.example.spargne.activity.Accueil;
import com.example.spargne.activity.Sign_in;
import com.example.spargne.entity.Account;
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

    public void getUserByUuid(Activity activity)
    {
        activity.findViewById(R.id.bottomNavigationView).setEnabled(false);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Singleton.getInstance().BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        WebServicesInterface webServicesInterface = retrofit.create(WebServicesInterface.class);
        Call<User> getUserByUuid = webServicesInterface.getUserByUuid(Singleton.getInstance().getToken(), Singleton.getInstance().getLogin().getUuid());
        getUserByUuid.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.body() != null) {
                    Singleton.getInstance().setUser(response.body());
                    Intent i = activity.getIntent();
                    activity.overridePendingTransition(0, 0);
                    i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    activity.startActivity(i);
                } else {
                    Toast.makeText(activity, response.message(), Toast.LENGTH_SHORT).show();
                }
                activity.findViewById(R.id.bottomNavigationView).setEnabled(true);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(activity, "Error connection", Toast.LENGTH_SHORT).show();
                activity.findViewById(R.id.bottomNavigationView).setEnabled(true);
            }
        });
    }

    public void getAccountByUuid(Activity activity)
    {
        activity.findViewById(R.id.bottomNavigationView).setEnabled(false);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Singleton.getInstance().BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        WebServicesInterface webServicesInterface = retrofit.create(WebServicesInterface.class);
        Call<Account[]> getAccountByUuid = webServicesInterface.getAccountByUuid(Singleton.getInstance().getToken(), Singleton.getInstance().getLogin().getUuid());
        getAccountByUuid.enqueue(new Callback<Account[]>() {
            @Override
            public void onResponse(Call<Account[]> call, Response<Account[]> response) {
                if (response.body() != null) {
                    if (Singleton.getInstance().getUser() != null) {
                        Singleton.getInstance().getUser().setAccounts(response.body());
                        for(int i = 0; i < Singleton.getInstance().getUser().getAccounts().length; i++) {
                            Singleton.getInstance().getUser().getAccounts()[i].setIndex(i);
                        }
                    } else {
                        Singleton.getInstance().setRequestGetUserByUuid(true);
                    }
                    Intent i = activity.getIntent();
                    activity.overridePendingTransition(0, 0);
                    i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    activity.startActivity(i);
                } else {
                    Toast.makeText(activity, response.message(), Toast.LENGTH_SHORT).show();
                }
                activity.findViewById(R.id.bottomNavigationView).setEnabled(true);
            }

            @Override
            public void onFailure(Call<Account[]> call, Throwable t) {
                Toast.makeText(activity, "Error connection", Toast.LENGTH_SHORT).show();
                activity.findViewById(R.id.bottomNavigationView).setEnabled(true);
            }
        });
    }
}
