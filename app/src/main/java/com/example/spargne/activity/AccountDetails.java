package com.example.spargne.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.spargne.R;
import com.example.spargne.entity.Transaction;
import com.example.spargne.list.ActivityAccountDetailsTransactionListAdapter;
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

        pb_accountLibelle = findViewById(R.id.activity_accountDetails_progressBar_accountLibelle);
        pb_accountAmount = findViewById(R.id.activity_accountDetails_progressBar_accountAmount);
        pb_transaction = findViewById(R.id.activity_accountDetails_progressBar_transaction);

        t_accountLibelle = findViewById(R.id.activity_accountDetails_textView_accountLibelle);
        t_accountAmount = findViewById(R.id.activity_accountDetails_textView_accountAmount);
        r_transaction = findViewById(R.id.activity_accountDetails_recyclerView_transaction);

        try {
            t_accountLibelle.setText(Singleton.getInstance().getUser().getAccounts()[bundle.getInt("indexAccount")].getName());
            if(Singleton.getInstance().getUser().getAccounts()[bundle.getInt("indexAccount")].getBalance() < 0) {
                t_accountAmount.setText(Singleton.getInstance().getUser().getAccounts()[bundle.getInt("indexAccount")].getBalance() + " €");
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

        /*try {
            r_transaction.setHasFixedSize(true);
            activityAccountDetailsTransactionManager = new LinearLayoutManager(this);
            r_transaction.setLayoutManager(activityAccountDetailsTransactionManager);
            Transaction[] list1 = {
                    new Transaction("15/02", "Subway Beaurains", 9.90),
                    new Transaction("16/02", "Centre Leclerc Arras", 2.61),
                    new Transaction("17/02", "Essence Station Beaurains", 60.45)
            };
            activityAccountDetailsTransactionListAdapter = new ActivityAccountDetailsTransactionListAdapter(list1);
            r_transaction.setAdapter(activityAccountDetailsTransactionListAdapter);
        } catch (Exception e){*/
            pb_transaction.setVisibility(View.VISIBLE);
            r_transaction.setVisibility(View.INVISIBLE);
            r_transaction.setMinimumHeight(300);
        //}
    }
}