package com.example.spargne.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spargne.R;
import com.example.spargne.entity.Account;
import com.example.spargne.entity.Transaction;

public class FragmentAccountAccountListAdapter extends RecyclerView.Adapter<FragmentAccountAccountCellHolder> {
    private Account[] dataSource;

    public FragmentAccountAccountListAdapter(Account[] dataSource) {
        this.dataSource = dataSource;
    }

    @NonNull
    @Override
    public FragmentAccountAccountCellHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_account_layout_account, parent, false);
        FragmentAccountAccountCellHolder fragmentAccountAccountCellHolder = new FragmentAccountAccountCellHolder(view);
        return fragmentAccountAccountCellHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FragmentAccountAccountCellHolder holder, int position) {
        holder.t_libelle.setText(dataSource[position].getLibelle());
        holder.t_amount.setText(String.valueOf(dataSource[position].getAmount()) + " €");
        holder.t_id.setText(dataSource[position].getId());
        holder.t_owner.setText(dataSource[position].getOwner());
    }

    @Override
    public int getItemCount() {
        if (this.dataSource != null) {
            return this.dataSource.length;
        }
        return 0;
    }
}
