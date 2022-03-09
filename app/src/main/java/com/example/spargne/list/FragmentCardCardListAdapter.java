package com.example.spargne.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spargne.R;
import com.example.spargne.model.CardList;

public class FragmentCardCardListAdapter extends RecyclerView.Adapter<FragmentCardCardCellHolder> {
    private CardList[] dataSource;

    public FragmentCardCardListAdapter(CardList[] dataSource) {
        this.dataSource = dataSource;
    }

    @NonNull
    @Override
    public FragmentCardCardCellHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_card_layout_card, parent, false);
        FragmentCardCardCellHolder fragmentCardCardCellHolder = new FragmentCardCardCellHolder(view);
        return fragmentCardCardCellHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FragmentCardCardCellHolder holder, int position) {
        holder.t_owner.setText(dataSource[position].getOwner());
        holder.t_accountId.setText(String.valueOf(dataSource[position].getAccountId()));
        holder.t_status.setText(dataSource[position].getStatus());
        holder.t_expirationDate.setText(dataSource[position].getExpirationDate());
        holder.t_libelle.setText(dataSource[position].getLibelle());
        holder.t_cardId.setText(dataSource[position].getCardId());
    }

    @Override
    public int getItemCount() {
        if (this.dataSource != null) {
            return this.dataSource.length;
        }
        return 0;
    }
}
