package com.raneez.truewallet.addexpense;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.raneez.truewallet.Injection;
import com.raneez.truewallet.R;

public class AddExpenseActivity extends AppCompatActivity {

    AddExpenseContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/


        AddExpenseActivityFragment addExpenseActivityFragment = AddExpenseActivityFragment.newInstance();
        presenter = new AddExpensePresenter(Injection.provideTrueWalletRepository(getApplicationContext()),
                addExpenseActivityFragment);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.AddExpensefragmentContainer,addExpenseActivityFragment).commit();


    }

}
