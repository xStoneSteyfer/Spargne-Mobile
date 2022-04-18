package com.example.spargne.popup;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.widget.DatePicker;

import androidx.annotation.NonNull;

import com.example.spargne.R;

public class Meeting_date_pop_up extends Dialog {
    private DatePicker datePicker;

    public Meeting_date_pop_up(Activity activity) {
        super(activity, R.style.Theme_Spargne_Popup);
        setContentView(R.layout.pop_up_meeting_date);
        datePicker = findViewById(R.id.meetingDate);
    }

    public void build(){
        show();
    }

    public String getDate(){
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();
        return String.valueOf(day)+"."+String.valueOf(month)+"."+String.valueOf(year);
    }
}

