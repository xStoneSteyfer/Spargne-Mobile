package com.example.spargne.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spargne.R;
import com.example.spargne.entity.Account;
import com.example.spargne.entity.Transaction;
import com.example.spargne.list.FragmentAccountAccountListAdapter;
import com.example.spargne.list.FragmentHomeTransactionListAdapter;

public class AccountFragment extends Fragment {
    private RecyclerView r_currentAccount;
    private RecyclerView r_savingsAccount;
    private RecyclerView.Adapter fragmentAccountAccountListAdapter;
    private RecyclerView.LayoutManager fragmentAccountAccountManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_account, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        r_currentAccount = getView().findViewById(R.id.fragment_account_recyclerView_currentAccount);
        r_savingsAccount = getView().findViewById(R.id.fragment_account_recyclerView_savingsAccount);

        r_currentAccount.setHasFixedSize(true);
        fragmentAccountAccountManager = new LinearLayoutManager(getContext());
        r_currentAccount.setLayoutManager(fragmentAccountAccountManager);
        Account[] list1 = {
                new Account("C/C Vip Tranquilite", 2105.42, "***** ****44 15", "M Xavier Van Cauwenberge")
        };
        fragmentAccountAccountListAdapter = new FragmentAccountAccountListAdapter(list1);
        r_currentAccount.setAdapter(fragmentAccountAccountListAdapter);

        r_savingsAccount.setHasFixedSize(true);
        fragmentAccountAccountManager = new LinearLayoutManager(getContext());
        r_savingsAccount.setLayoutManager(fragmentAccountAccountManager);
        Account[] list2 = {
                new Account("Livret jeune", 1752.12, "***** ****44 02", "M Xavier Van Cauwenberge"),
                new Account("Livret bleu", 557.86, "***** ****44 09", "M Xavier Van Cauwenberge")
        };
        fragmentAccountAccountListAdapter = new FragmentAccountAccountListAdapter(list2);
        r_savingsAccount.setAdapter(fragmentAccountAccountListAdapter);
    }
}
