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
import com.example.spargne.model.Singleton;
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
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        switch (Singleton.getInstance().currentFragment) {
            case "homeFragment":
                loadFragment(homeFragment);
                bottomNavigationView.getMenu().getItem(0).setChecked(true);
                break;
            case "accountFragment":
                loadFragment(accountFragment);
                bottomNavigationView.getMenu().getItem(1).setChecked(true);
                break;
            case "transferFragment":
                loadFragment(transferFragment);
                bottomNavigationView.getMenu().getItem(2).setChecked(true);
                break;
            case "cardFragment":
                loadFragment(cardFragment);
                bottomNavigationView.getMenu().getItem(3).setChecked(true);
                break;
            case "menuFragment":
                loadFragment(menuFragment);
                bottomNavigationView.getMenu().getItem(4).setChecked(true);
                break;
        }
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.action_home:
                fragment = homeFragment;
                Singleton.getInstance().currentFragment = "homeFragment";
                Singleton.getInstance().setRequestGetAccountByUuid(true);
                break;
            case R.id.action_account:
                fragment = accountFragment;
                Singleton.getInstance().currentFragment = "accountFragment";
                Singleton.getInstance().setRequestGetAccountByUuid(true);
                break;
            case R.id.action_transfer:
                fragment = transferFragment;
                Singleton.getInstance().currentFragment = "transferFragment";
                break;
            case R.id.action_card:
                fragment = cardFragment;
                Singleton.getInstance().currentFragment = "cardFragment";
                break;
            case R.id.action_menu:
                fragment = menuFragment;
                Singleton.getInstance().currentFragment = "menuFragment";
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





    public void goToFirstAccountDetails(View v){ goToAccountDetails(0); }

    @Override
    public void onAccountListClick(int indexAccount) {
        goToAccountDetails(indexAccount);
    }

    public void goToAccountDetails(int indexAccount){
        Singleton.getInstance().setRequestGetAccountByUuid(true);
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