package com.example.spargne.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spargne.R;
import com.example.spargne.entity.MeetingTopic;
import com.example.spargne.interfaces.OnMeetingTopicClickListener;
import com.example.spargne.list.FragmentMeetingRequestListAdapter;
import com.example.spargne.model.RetrofitRequest;
import com.example.spargne.model.Singleton;
import com.example.spargne.popup.Loading_popup;

public class MeetingRequestFragment extends Fragment {
    private RecyclerView topicListRecyclerView;
    private RecyclerView.Adapter topicListAdapter;
    private RecyclerView.LayoutManager topicListLayoutManager;
    Loading_popup popupLoading;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_meeting_request, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        topicListRecyclerView = getView().findViewById(R.id.RecyclerView_topic);
        //categoryListRecyclerView.setHasFixedSize(true);

        topicListLayoutManager = new LinearLayoutManager(getContext());
        topicListRecyclerView.setLayoutManager(topicListLayoutManager);

        MeetingTopic[] listTopic = Singleton.getInstance().getMeetingTopics();

        topicListAdapter = new FragmentMeetingRequestListAdapter(listTopic,(OnMeetingTopicClickListener) getContext());
        topicListRecyclerView.setAdapter(topicListAdapter);
    }


}

