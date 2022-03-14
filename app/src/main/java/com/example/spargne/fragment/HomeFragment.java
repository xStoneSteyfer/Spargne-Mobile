package com.example.spargne.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spargne.R;
import com.example.spargne.model.RetrofitRequest;
import com.example.spargne.model.Singleton;
import com.example.spargne.entity.Transaction;
import com.example.spargne.list.FragmentHomeTransactionListAdapter;

public class HomeFragment extends Fragment {
    private ProgressBar pb_accountLibelle;
    private ProgressBar pb_accountAmount;
    private ProgressBar pb_accountId;
    private ProgressBar pb_transaction;
    private ProgressBar pb_advisorName;
    private ProgressBar pb_advisorLocation;

    private TextView t_accountLibelle;
    private TextView t_accountAmount;
    private TextView t_accountId;
    private RecyclerView r_transaction;
    private RecyclerView.Adapter fragmentHomeTransactionListAdapter;
    private RecyclerView.LayoutManager fragmentHomeTransactionManager;
    private TextView t_advisorName;
    private TextView t_advisorLocation;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        if(Singleton.getInstance().isRequestGetUserByUuid()) {
            RetrofitRequest retrofitRequest = new RetrofitRequest();
            retrofitRequest.getUserByUuid(getActivity());
        }
        if(Singleton.getInstance().isRequestGetAccountByUuid()) {
            RetrofitRequest retrofitRequest = new RetrofitRequest();
            retrofitRequest.getAccountByUuid(getActivity());
        }

        pb_accountLibelle = getView().findViewById(R.id.fragment_home_progressBar_accountLibelle);
        pb_accountAmount = getView().findViewById(R.id.fragment_home_progressBar_accountAmount);
        pb_accountId = getView().findViewById(R.id.fragment_home_progressBar_accountId);
        pb_transaction = getView().findViewById(R.id.fragment_home_progressBar_transaction);
        pb_advisorName = getView().findViewById(R.id.fragment_home_progressBar_advisorName);
        pb_advisorLocation = getView().findViewById(R.id.fragment_home_progressBar_advisorLocation);

        t_accountLibelle = getView().findViewById(R.id.fragment_home_textView_accountLibelle);
        t_accountAmount = getView().findViewById(R.id.fragment_home_textView_accountAmount);
        t_accountId = getView().findViewById(R.id.fragment_home_textView_accountId);
        r_transaction = getView().findViewById(R.id.fragment_home_recyclerView_transaction);
        t_advisorName = getView().findViewById(R.id.fragment_home_textView_advisorName);
        t_advisorLocation = getView().findViewById(R.id.fragment_home_textView_advisorLocation);

        try {
            t_accountLibelle.setText(Singleton.getInstance().getUser().getAccounts()[0].getName());
            t_accountAmount.setText(String.valueOf(Singleton.getInstance().getUser().getAccounts()[0].getBalance()));
            t_accountId.setText(Singleton.getInstance().getUser().getAccounts()[0].getIban());
        } catch (Exception e){
            pb_accountLibelle.setVisibility(View.VISIBLE);
            pb_accountAmount.setVisibility(View.VISIBLE);
            pb_accountId.setVisibility(View.VISIBLE);
            t_accountLibelle.setVisibility(View.INVISIBLE);
            t_accountAmount.setVisibility(View.INVISIBLE);
            t_accountId.setVisibility(View.INVISIBLE);
        }

        /*try {
            r_transaction.setHasFixedSize(true);
            fragmentHomeTransactionManager = new LinearLayoutManager(getContext());
            r_transaction.setLayoutManager(fragmentHomeTransactionManager);
            Transaction[] list1 = {
                    new Transaction("15/02", "Subway Beaurains", 9.90),
                    new Transaction("16/02", "Centre Leclerc Arras", 2.61),
                    new Transaction("17/02", "Essence Station Beaurains", 60.45)
            };
            fragmentHomeTransactionListAdapter = new FragmentHomeTransactionListAdapter(list1);
            r_transaction.setAdapter(fragmentHomeTransactionListAdapter);
        } catch (Exception e){*/
            pb_transaction.setVisibility(View.VISIBLE);
            r_transaction.setVisibility(View.INVISIBLE);
            r_transaction.setMinimumHeight(300);
        //}

        try {
            t_advisorName.setText(Singleton.getInstance().getUser().getAdvisor().getName() + " " + Singleton.getInstance().getUser().getAdvisor().getFirst_name());
            t_advisorLocation.setText("S'pargne Center in " + Singleton.getInstance().getUser().getAdvisor().getCity() + ", " + Singleton.getInstance().getUser().getAdvisor().getCountry());
        } catch (Exception e){
            pb_advisorName.setVisibility(View.VISIBLE);
            pb_advisorLocation.setVisibility(View.VISIBLE);
            t_advisorName.setVisibility(View.INVISIBLE);
            t_advisorLocation.setVisibility(View.INVISIBLE);
        }
    }
}
