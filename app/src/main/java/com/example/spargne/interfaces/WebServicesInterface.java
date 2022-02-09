package com.example.spargne.interfaces;

import com.example.spargne.entity.EtatRetrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WebServicesInterface {

    @GET("connexion/{login}/{mdp}")
    Call<EtatRetrofit> connexion(@Path("login") String login, @Path("mdp") String mdp);
}
