package com.example.spargne.interfaces;

import com.example.spargne.entity.Account;
import com.example.spargne.entity.Login;
import com.example.spargne.entity.MeetingTopic;
import com.example.spargne.entity.Transaction;
import com.example.spargne.entity.User;
import com.example.spargne.entity.Token;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WebServicesInterface {

    @POST("authentication_token")
    Call<Token> getToken(@Body Login login);

    @GET("users/{uuid}")
    Call<User> getUserByUuid(@Header("Authorization") String token, @Path("uuid") String uuid);

    @GET("accounts/{uuid}")
    Call<Account[]> getAccountByUuid(@Header("Authorization") String token, @Path("uuid") String uuid);

    @GET("transfert/{id}/{first}/{last}")
    Call<Transaction[]> getTransactionById(@Header("Authorization") String token, @Path("id") int id, @Path("first") int first, @Path("last") int last);

    @GET("getMeetingTopic")
    Call<MeetingTopic[]> getMeetingTopic();

    @GET("setMeetingRequest/{desiredDate}/{customerId}/{topicId}")
    Call<Integer> setMeetingRequest(@Path("desiredDate") String desiredDate,@Path("customerId") int customerId,@Path("topicId") int topicId);
}
