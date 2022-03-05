package com.example.spargne.list;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spargne.R;

public class FragmentCardCardCellHolder extends RecyclerView.ViewHolder {
    public TextView t_owner;
    public TextView t_accountId;
    public TextView t_status;
    public TextView t_expirationDate;
    public TextView t_libelle;
    public TextView t_cardId;

    public FragmentCardCardCellHolder(@NonNull View itemView) {
        super(itemView);
        t_owner = itemView.findViewById(R.id.fragment_card_layout_card_textView_owner);
        t_accountId = itemView.findViewById(R.id.fragment_card_layout_card_textView_accountId);
        t_status = itemView.findViewById(R.id.fragment_card_layout_card_textView_status);
        t_expirationDate = itemView.findViewById(R.id.fragment_card_layout_card_textView_expirationDate);
        t_libelle = itemView.findViewById(R.id.fragment_card_layout_card_textView_libelle);
        t_cardId = itemView.findViewById(R.id.fragment_card_layout_card_textView_cardId);
    }
}
