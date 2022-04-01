package com.example.spargne.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.spargne.R;
import com.example.spargne.entity.Transaction;
import com.example.spargne.list.ActivityAccountDetailsTransactionListAdapter;
import com.example.spargne.model.RetrofitRequest;
import com.example.spargne.model.Singleton;

public class AccountDetails extends AppCompatActivity {

    private ProgressBar pb_accountLibelle;
    private ProgressBar pb_accountAmount;
    private ProgressBar pb_transaction;

    private TextView t_accountLibelle;
    private TextView t_accountAmount;
    private RecyclerView r_transaction;
    private RecyclerView.Adapter activityAccountDetailsTransactionListAdapter;
    private RecyclerView.LayoutManager activityAccountDetailsTransactionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_details);

        Bundle bundle = getIntent().getExtras();

        if (Singleton.getInstance().getUser() != null) {
            if (Singleton.getInstance().getUser().getAccounts() != null) {
                if (Singleton.getInstance().isRequestGetTransactionById()) {
                    RetrofitRequest retrofitRequest = new RetrofitRequest();
                    retrofitRequest.getTransactionById(this, Singleton.getInstance().getUser().getAccounts()[bundle.getInt("indexAccount")].getId(), 0, 20);
                    Singleton.getInstance().setRequestGetTransactionById(false);
                }
            }
        }
        if (Singleton.getInstance().getUser() != null) {
            if (Singleton.getInstance().isRequestGetAccountByUuid()) {
                RetrofitRequest retrofitRequest = new RetrofitRequest();
                retrofitRequest.getAccountByUuid(this);
                Singleton.getInstance().setRequestGetAccountByUuid(false);
                Singleton.getInstance().setRequestGetTransactionById(true);
            }
        }



        pb_accountLibelle = findViewById(R.id.activity_accountDetails_progressBar_accountLibelle);
        pb_accountAmount = findViewById(R.id.activity_accountDetails_progressBar_accountAmount);
        pb_transaction = findViewById(R.id.activity_accountDetails_progressBar_transaction);

        t_accountLibelle = findViewById(R.id.activity_accountDetails_textView_accountLibelle);
        t_accountAmount = findViewById(R.id.activity_accountDetails_textView_accountAmount);
        r_transaction = findViewById(R.id.activity_accountDetails_recyclerView_transaction);

        try {
            t_accountLibelle.setText(Singleton.getInstance().getUser().getAccounts()[bundle.getInt("indexAccount")].getName());
            if(Singleton.getInstance().getUser().getAccounts()[bundle.getInt("indexAccount")].getBalance() < 0) {
                t_accountAmount.setText("- " + String.valueOf(Singleton.getInstance().getUser().getAccounts()[bundle.getInt("indexAccount")].getBalance()).substring(0) + " €");
            }
            else {
                t_accountAmount.setText("+ " + Singleton.getInstance().getUser().getAccounts()[bundle.getInt("indexAccount")].getBalance() + " €");
            }
        } catch (Exception e){
            pb_accountLibelle.setVisibility(View.VISIBLE);
            pb_accountAmount.setVisibility(View.VISIBLE);
            t_accountLibelle.setVisibility(View.INVISIBLE);
            t_accountAmount.setVisibility(View.INVISIBLE);
        }

        try {
            r_transaction.setHasFixedSize(true);
            activityAccountDetailsTransactionManager = new LinearLayoutManager(this);
            r_transaction.setLayoutManager(activityAccountDetailsTransactionManager);
            activityAccountDetailsTransactionListAdapter = new ActivityAccountDetailsTransactionListAdapter(Singleton.getInstance().getUser().getAccounts()[bundle.getInt("indexAccount")]);
            r_transaction.setAdapter(activityAccountDetailsTransactionListAdapter);
        } catch (Exception e){
            pb_transaction.setVisibility(View.VISIBLE);
            r_transaction.setVisibility(View.INVISIBLE);
            r_transaction.setMinimumHeight(300);
        }
    }



    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, Accueil.class);
        startActivity(i);
    }
}