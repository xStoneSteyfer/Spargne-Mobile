package com.example.spargne.list;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spargne.R;
import com.example.spargne.entity.Account;
import com.example.spargne.entity.Transaction;
import com.example.spargne.model.Singleton;

public class FragmentHomeTransactionListAdapter extends RecyclerView.Adapter<FragmentHomeTransactionCellHolder> {
    private Account dataSource;

    public FragmentHomeTransactionListAdapter(Account dataSource) {
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
        String[] dateHourExplode = dataSource.getTransactions()[position].getDate().split(" ");
        String[] dateExplode = dateHourExplode[0].split("-");
        holder.t_date.setText(dateExplode[1] + "/" + dateExplode[2] + "/" + dateExplode[0].substring(2));

        if(dataSource.getId() == dataSource.getTransactions()[position].getFromAccount()) {
            Account currentAccount = null;
            for (Account account : Singleton.getInstance().getUser().getAccounts()) {
                if(account.getId() == dataSource.getTransactions()[position].getDestinationAccount()) {
                    currentAccount = account;
                }
            }

            holder.t_libelle.setText(dataSource.getTransactions()[position].getDestinationName() + " - " + currentAccount.getName());
            holder.t_amount.setText("- " + String.valueOf(dataSource.getTransactions()[position].getAmount()).substring(0) + " €");
            holder.t_amount.setTextColor(Color.parseColor("#A70101"));
        }
        else{
            Account currentAccount = null;
            for (Account account : Singleton.getInstance().getUser().getAccounts()) {
                if(account.getId() == dataSource.getTransactions()[position].getFromAccount()) {
                    currentAccount = account;
                }
            }

            holder.t_libelle.setText(dataSource.getTransactions()[position].getFromName() + " - " + currentAccount.getName());
            holder.t_amount.setText("+ " + String.valueOf(dataSource.getTransactions()[position].getAmount()) + " €");
            holder.t_amount.setTextColor(Color.parseColor("#009E02"));
        }
    }

    @Override
    public int getItemCount() {
        if (this.dataSource.getTransactions() != null) {
            return this.dataSource.getTransactions().length;
        }
        return 0;
    }
}
