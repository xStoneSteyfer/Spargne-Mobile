package com.example.spargne.interfaces;

import com.example.spargne.entity.Login;
import com.example.spargne.entity.User;
import com.example.spargne.entity.Token;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface WebServicesInterface {

    @POST("authentication_token")
    Call<Token> getToken(@Body Login login);

    //@GET("users/getByUuid/{uuid}")
    @GET("users/{uuid}")
    Call<User> login(@Header("Authorization") String token, @Path("uuid") String uuid);
}
