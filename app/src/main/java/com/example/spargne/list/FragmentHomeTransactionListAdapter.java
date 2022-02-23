package com.example.spargne.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spargne.R;
import com.example.spargne.entity.Transaction;

public class FragmentHomeTransactionListAdapter extends RecyclerView.Adapter<FragmentHomeTransactionCellHolder> {
    private Transaction[] dataSource;

    public FragmentHomeTransactionListAdapter(Transaction[] dataSource) {
        this.dataSource = dataSource;
    }

    @NonNull
    @Override
    public FragmentHomeTransactionCellHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_home_layout_transaction, parent, false);
        FragmentHomeTransactionCellHolder fragmentHomeTransactionCellHolder = new FragmentHomeTransactionCellHolder(view);
        return fragmentHomeTransactionCellHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FragmentHomeTransactionCellHolder holder, int position) {
        holder.t_date.setText(dataSource[position].getDate());
        holder.t_libelle.setText(dataSource[position].getLibelle());
        holder.t_amount.setText("- " + String.valueOf(dataSource[position].getAmount()) + " €");
    }

    @Override
    public int getItemCount() {
        if (this.dataSource != null) {
            return this.dataSource.length;
        }
        return 0;
    }
}
