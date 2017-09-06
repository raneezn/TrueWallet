package com.raneez.truewallet.addexpense;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.raneez.truewallet.Injection;
import com.raneez.truewallet.R;

public class AddOrEditExpenseActivity extends AppCompatActivity {

    AddOrEditExpenseContract.Presenter presenter;

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

        int expenseId = getIntent().getIntExtra(AddOrEditExpenseFragment.EXPENSE_ID,-1);


        AddOrEditExpenseFragment addOrEditExpenseFragment = AddOrEditExpenseFragment.newInstance();
        presenter = new AddOrEditExpensePresenter(Injection.provideTrueWalletRepository(getApplicationContext()),
                addOrEditExpenseFragment,expenseId);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.AddExpensefragmentContainer,addOrEditExpenseFragment).commit();


    }

}
