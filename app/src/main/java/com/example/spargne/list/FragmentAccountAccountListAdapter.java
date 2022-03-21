package com.example.spargne.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spargne.R;
import com.example.spargne.entity.Account;
import com.example.spargne.interfaces.OnFragmentAccountListAccountClickListener;
import com.example.spargne.model.Singleton;

public class FragmentAccountAccountListAdapter extends RecyclerView.Adapter<FragmentAccountAccountCellHolder> {
    private Account[] dataSource;
    private OnFragmentAccountListAccountClickListener onFragmentAccountListAccountClickListener;

    public FragmentAccountAccountListAdapter(Account[] dataSource, OnFragmentAccountListAccountClickListener listener) {
        this.dataSource = dataSource;
        onFragmentAccountListAccountClickListener = listener;
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
        holder.t_libelle.setText(dataSource[position].getName());
        holder.t_amount.setText(String.valueOf(dataSource[position].getBalance()) + " €");
        holder.t_id.setText(dataSource[position].getIban());
        holder.t_owner.setText(Singleton.getInstance().getUser().getName() + " " +Singleton.getInstance().getUser().getFirst_name());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFragmentAccountListAccountClickListener.onAccountListClick(dataSource[position].getIndex());
            }
        });
    }

    @Override
    public int getItemCount() {
        if (this.dataSource != null) {
            return this.dataSource.length;
        }
        return 0;
    }
}
