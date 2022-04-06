package com.example.spargne.model;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.example.spargne.R;
import com.example.spargne.activity.Accueil;
import com.example.spargne.entity.Account;
import com.example.spargne.entity.MeetingTopic;
import com.example.spargne.entity.Transaction;
import com.example.spargne.entity.User;
import com.example.spargne.interfaces.WebServicesInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRequest {

    public void getUserByUuid(Activity activity)
    {
        try {
            activity.findViewById(R.id.bottomNavigationView).setEnabled(false);
        } catch (Exception e){}
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
                try {
                    activity.findViewById(R.id.bottomNavigationView).setEnabled(true);
                } catch (Exception e){}
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(activity, "Error connection", Toast.LENGTH_SHORT).show();
                try {
                    activity.findViewById(R.id.bottomNavigationView).setEnabled(true);
                } catch (Exception e){}
            }
        });
    }

    public void getAccountByUuid(Activity activity)
    {
        try {
            activity.findViewById(R.id.bottomNavigationView).setEnabled(false);
        } catch (Exception e){}
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
                try {
                    activity.findViewById(R.id.bottomNavigationView).setEnabled(true);
                } catch (Exception e){}
            }

            @Override
            public void onFailure(Call<Account[]> call, Throwable t) {
                Toast.makeText(activity, "Error connection", Toast.LENGTH_SHORT).show();
                try {
                    activity.findViewById(R.id.bottomNavigationView).setEnabled(true);
                } catch (Exception e){}
            }
        });
    }

    public void getTransactionById(Activity activity, int accountId, int first, int last)
    {
        try {
            activity.findViewById(R.id.bottomNavigationView).setEnabled(false);
        } catch (Exception e){}
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Singleton.getInstance().BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        WebServicesInterface webServicesInterface = retrofit.create(WebServicesInterface.class);
        Call<Transaction[]> getTransactionById = webServicesInterface.getTransactionById(Singleton.getInstance().getToken(), accountId, first, last);
        getTransactionById.enqueue(new Callback<Transaction[]>() {
            @Override
            public void onResponse(Call<Transaction[]> call, Response<Transaction[]> response) {
                if (response.body() != null) {
                    for (int i = 0; i < Singleton.getInstance().getUser().getAccounts().length; i++) {
                        if (Singleton.getInstance().getUser().getAccounts()[i].getId() == accountId){
                            Singleton.getInstance().getUser().getAccounts()[i].setTransactions(response.body());
                        }
                    }
                    Intent i = activity.getIntent();
                    activity.overridePendingTransition(0, 0);
                    i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    activity.startActivity(i);
                } else {
                    Toast.makeText(activity, response.message(), Toast.LENGTH_SHORT).show();
                }
                try {
                    activity.findViewById(R.id.bottomNavigationView).setEnabled(true);
                } catch (Exception e){}
            }

            @Override
            public void onFailure(Call<Transaction[]> call, Throwable t) {
                Toast.makeText(activity, "Error connection", Toast.LENGTH_SHORT).show();
                try {
                    activity.findViewById(R.id.bottomNavigationView).setEnabled(true);
                } catch (Exception e){}
            }
        });
    }

    public void getMeetingTopic(Activity activity)
    {
        try {
            activity.findViewById(R.id.bottomNavigationView).setEnabled(false);
        } catch (Exception e){}

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Singleton.getInstance().BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        WebServicesInterface webServicesInterface = retrofit.create(WebServicesInterface.class);

        Call<MeetingTopic[]> getMeetingTopics = webServicesInterface.getMeetingTopic();
        getMeetingTopics.enqueue(new Callback<MeetingTopic[]>() {
            @Override
            public void onResponse(Call<MeetingTopic[]> call, Response<MeetingTopic[]> response) {
                if (response.body() != null) {
                    Singleton.getInstance().setMeetingTopics(response.body());
                    Singleton.getInstance().currentFragment = "meetingFragment";
                    Intent i = activity.getIntent();
                    activity.overridePendingTransition(0, 0);
                    i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    activity.startActivity(i);
                } else {
                    Toast.makeText(activity, response.message(), Toast.LENGTH_SHORT).show();
                }
                try {
                    activity.findViewById(R.id.bottomNavigationView).setEnabled(true);
                } catch (Exception e){}
            }

            @Override
            public void onFailure(Call<MeetingTopic[]> call, Throwable t) {
                Toast.makeText(activity, "Error connection", Toast.LENGTH_SHORT).show();
                try {
                    activity.findViewById(R.id.bottomNavigationView).setEnabled(true);
                } catch (Exception e){}
            }
        });
    }

    public void setMeetingRequest(Activity activity, String desireDate, int customerId, int topicId)
    {
        try {
            activity.findViewById(R.id.bottomNavigationView).setEnabled(false);
        } catch (Exception e){}

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Singleton.getInstance().BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        WebServicesInterface webServicesInterface = retrofit.create(WebServicesInterface.class);

        Call<Integer> setMeetingRequest = webServicesInterface.setMeetingRequest(desireDate,customerId,topicId);
        setMeetingRequest.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                if (response.body() != null) {
                    if(response.body() == 1){
                        Toast.makeText(activity, "Meeting request send", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(activity, "An error occured", Toast.LENGTH_SHORT).show();
                    }
                    Singleton.getInstance().currentFragment = "homeFragment";
                    Intent i = activity.getIntent();
                    activity.overridePendingTransition(0, 0);
                    i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    activity.startActivity(i);
                } else {
                    Toast.makeText(activity, response.message(), Toast.LENGTH_SHORT).show();
                }
                try {
                    activity.findViewById(R.id.bottomNavigationView).setEnabled(true);
                } catch (Exception e){}
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                Toast.makeText(activity, "Error connection", Toast.LENGTH_SHORT).show();
                try {
                    activity.findViewById(R.id.bottomNavigationView).setEnabled(true);
                } catch (Exception e){}
                Singleton.getInstance().currentFragment = "homeFragment";
                Intent i = activity.getIntent();
                activity.overridePendingTransition(0, 0);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                activity.startActivity(i);
            }
        });
    }
}
