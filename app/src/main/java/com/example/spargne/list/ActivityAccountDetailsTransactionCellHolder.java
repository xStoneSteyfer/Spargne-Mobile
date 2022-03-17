package com.example.spargne.list;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spargne.R;

public class ActivityAccountDetailsTransactionCellHolder extends RecyclerView.ViewHolder {
    public TextView t_date;
    public TextView t_libelle;
    public TextView t_amount;

    public ActivityAccountDetailsTransactionCellHolder(@NonNull View itemView) {
        super(itemView);
        t_date = itemView.findViewById(R.id.fragment_home_layout_transaction_textView_date);
        t_libelle = itemView.findViewById(R.id.fragment_home_layout_transaction_textView_libelle);
        t_amount = itemView.findViewById(R.id.fragment_home_layout_transaction_textView_amount);
    }
}
