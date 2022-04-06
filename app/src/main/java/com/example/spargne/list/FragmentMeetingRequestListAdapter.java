package com.example.spargne.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spargne.R;
import com.example.spargne.entity.MeetingTopic;
import com.example.spargne.interfaces.OnMeetingTopicClickListener;

public class FragmentMeetingRequestListAdapter extends RecyclerView.Adapter<FragmentMeetingRequestCellHolder> {
    private MeetingTopic[] datas;
    private OnMeetingTopicClickListener clickListener;

    public FragmentMeetingRequestListAdapter(MeetingTopic[] datas, OnMeetingTopicClickListener clickListener) {
        this.datas = datas;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public FragmentMeetingRequestCellHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_metting_topic, parent,
                        false);
        FragmentMeetingRequestCellHolder userCellHolder = new FragmentMeetingRequestCellHolder(view);
        return userCellHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FragmentMeetingRequestCellHolder holder, int position) {
        holder.libelle.setText(datas[position].getLibelle());
        int pos = position;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onMeetingTopicListClick(datas[pos]);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (this.datas != null) {
            return this.datas.length;
        }

        return 0;
    }
}
