package com.stephen.digilock.ViewController;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.stephen.digilock.ViewController.PasswordsFragment;
import com.stephen.digilock.R;

public class PasswordsActivity extends AppCompatActivity implements
        PasswordsFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passwords);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        showPasswordsFragment();
    }

    private void showPasswordsFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        PasswordsFragment fragment = PasswordsFragment.newInstance(null, null);
        transaction.replace(R.id.passwords_primarycontainer, fragment).commit();
    }

}
