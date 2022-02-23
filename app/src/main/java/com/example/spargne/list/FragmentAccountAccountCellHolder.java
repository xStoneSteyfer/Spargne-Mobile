package com.example.spargne.list;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spargne.R;

public class FragmentAccountAccountCellHolder extends RecyclerView.ViewHolder {
    public TextView t_libelle;
    public TextView t_amount;
    public TextView t_id;
    public TextView t_owner;

    public FragmentAccountAccountCellHolder(@NonNull View itemView) {
        super(itemView);
        t_libelle = itemView.findViewById(R.id.fragment_account_layout_account_textView_libelle);
        t_amount = itemView.findViewById(R.id.fragment_account_layout_account_textView_amount);
        t_id = itemView.findViewById(R.id.fragment_account_layout_account_textView_id);
        t_owner = itemView.findViewById(R.id.fragment_account_layout_account_textView_owner);
    }
}
