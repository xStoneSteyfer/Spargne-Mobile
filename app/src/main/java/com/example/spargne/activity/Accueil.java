package com.example.spargne.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.spargne.R;
import com.example.spargne.entity.Account;
import com.example.spargne.fragment.AccountFragment;
import com.example.spargne.fragment.CardFragment;
import com.example.spargne.fragment.HomeFragment;
import com.example.spargne.fragment.MenuFragment;
import com.example.spargne.fragment.TransferFragment;
import com.example.spargne.interfaces.OnFragmentAccountListAccountClickListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Accueil extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, OnFragmentAccountListAccountClickListener {

    Fragment homeFragment;
    Fragment accountFragment;
    Fragment transferFragment;
    Fragment cardFragment;
    Fragment menuFragment;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        homeFragment = new HomeFragment();
        accountFragment = new AccountFragment();
        transferFragment = new TransferFragment();
        cardFragment = new CardFragment();
        menuFragment = new MenuFragment();
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        loadFragment(homeFragment);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.action_home:
                fragment = homeFragment;
                break;
            case R.id.action_account:
                fragment = accountFragment;
                break;
            case R.id.action_transfer:
                fragment = transferFragment;
                break;
            case R.id.action_card:
                fragment = cardFragment;
                break;
            case R.id.action_menu:
                fragment = menuFragment;
                break;
        }
        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }





    public void goToFirstAccountDetails(View v){
        goToAccountDetails(0);
    }

    @Override
    public void onAccountListClick(int indexAccount) {
        goToAccountDetails(indexAccount);
    }

    public void goToAccountDetails(int indexAccount){
        Intent i = new Intent(this, AccountDetails.class);
        i.putExtra("indexAccount", indexAccount);
        startActivity(i);
    }



    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, Sign_in.class);
        startActivity(i);
    }
}