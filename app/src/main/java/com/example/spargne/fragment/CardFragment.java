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
import com.example.spargne.entity.CardList;
import com.example.spargne.list.FragmentAccountAccountListAdapter;
import com.example.spargne.list.FragmentCardCardListAdapter;

public class CardFragment extends Fragment {
    private RecyclerView r_card;
    private RecyclerView.Adapter fragmentCardCardListAdapter;
    private RecyclerView.LayoutManager fragmentCardCardManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_card, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        r_card = getView().findViewById(R.id.fragment_card_recyclerView_card);

        r_card.setHasFixedSize(true);
        fragmentCardCardManager = new LinearLayoutManager(getContext());
        r_card.setLayoutManager(fragmentCardCardManager);
        CardList[] list = {
                new CardList("M Xavier Van cauwenberge", "***** ****4415", "active", "15/23", "CB Mastercard", "***** *******7435")
        };
        fragmentCardCardListAdapter = new FragmentCardCardListAdapter(list);
        r_card.setAdapter(fragmentCardCardListAdapter);
    }
}
