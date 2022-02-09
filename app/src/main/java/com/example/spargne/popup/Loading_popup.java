package com.example.spargne.popup;

import android.app.Activity;
import android.app.Dialog;

import com.example.spargne.R;

public class Loading_popup extends Dialog {

    public Loading_popup(Activity activity){
        super(activity, R.style.Theme_Spargne_Popup);
        setContentView(R.layout.pop_up_loading);
    }

    public void build(){
        show();
    }
}