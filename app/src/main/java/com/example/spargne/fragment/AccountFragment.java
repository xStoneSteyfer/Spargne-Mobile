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
import com.example.spargne.activity.Accueil;
import com.example.spargne.entity.Account;
import com.example.spargne.model.Singleton;
import com.example.spargne.list.FragmentAccountAccountListAdapter;

import java.util.ArrayList;

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

        ArrayList<Account> currentAccountArrayList = new ArrayList<Account>();
        ArrayList<Account> savingsAccountArrayList = new ArrayList<Account>();
        for (Account account : Singleton.getInstance().getUser().getAccounts()) {
            if(account.getType().getId() == 1){
                currentAccountArrayList.add(account);
            }
            if(account.getType().getId() == 2){
                savingsAccountArrayList.add(account);
            }
        }
        Account[] currentAccountList = currentAccountArrayList.toArray(new Account[currentAccountArrayList.size()]);
        Account[] savingsAccountList = savingsAccountArrayList.toArray(new Account[savingsAccountArrayList.size()]);

        r_currentAccount.setHasFixedSize(true);
        fragmentAccountAccountManager = new LinearLayoutManager(getContext());
        r_currentAccount.setLayoutManager(fragmentAccountAccountManager);
        fragmentAccountAccountListAdapter = new FragmentAccountAccountListAdapter(currentAccountList, (Accueil)getActivity());
        r_currentAccount.setAdapter(fragmentAccountAccountListAdapter);

        r_savingsAccount.setHasFixedSize(true);
        fragmentAccountAccountManager = new LinearLayoutManager(getContext());
        r_savingsAccount.setLayoutManager(fragmentAccountAccountManager);
        fragmentAccountAccountListAdapter = new FragmentAccountAccountListAdapter(savingsAccountList, (Accueil)getActivity());
        r_savingsAccount.setAdapter(fragmentAccountAccountListAdapter);
    }
}
