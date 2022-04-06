package com.example.spargne.list;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spargne.R;

public class FragmentMeetingRequestCellHolder  extends RecyclerView.ViewHolder {

    public TextView libelle;

    public FragmentMeetingRequestCellHolder(@NonNull View itemView) {
        super(itemView);
        libelle = itemView.findViewById(R.id.cell_meeting_topic_libelle);
    }
}
