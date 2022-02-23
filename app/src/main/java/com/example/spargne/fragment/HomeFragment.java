package com.example.spargne.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spargne.R;
import com.example.spargne.entity.Transaction;
import com.example.spargne.entity.User;
import com.example.spargne.list.FragmentHomeTransactionListAdapter;

public class HomeFragment extends Fragment {
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
        t_accountLibelle = getView().findViewById(R.id.fragment_home_textView_accountLibelle);
        t_accountAmount = getView().findViewById(R.id.fragment_home_textView_accountAmount);
        t_accountId = getView().findViewById(R.id.fragment_home_textView_accountId);
        r_transaction = getView().findViewById(R.id.fragment_home_recyclerView_transaction);
        t_advisorName = getView().findViewById(R.id.fragment_home_textView_advisorName);
        t_advisorLocation = getView().findViewById(R.id.fragment_home_textView_advisorLocation);

        t_accountLibelle.setText("C/C Vip Tranquilite");
        t_accountAmount.setText("+ 2 105.42 €");
        t_accountId.setText("***** ****44 15");

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

        t_advisorName.setText("M. Robin Victor");
        t_advisorLocation.setText("S'pargne Center in Arras, France");
    }
}
