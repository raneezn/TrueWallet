package com.raneez.truewallet.data.source.local;

import com.raneez.truewallet.data.Expense;
import com.raneez.truewallet.data.source.TrueWalletDataSource;

import java.util.List;

/**
 * Created by raneezahmed on 20/08/17.
 */

public class TrueWalletLocalDataRepository implements TrueWalletDataSource {

    TrueWalletDataSource instance = null;

    private TrueWalletLocalDataRepository(){

    }

    public TrueWalletDataSource getInstance() {
        if(instance == null){
            instance = new TrueWalletLocalDataRepository();
        }
        return instance;
    }

    @Override
    public void getAllExpenses(Callback<List<Expense>> callback) {

    }

    @Override
    public void getExpenseDetails(String id, Callback<Expense> callback) {

    }

    @Override
    public void saveExpense(Expense expense) {

    }

    @Override
    public void removeExpense(Expense expense) {

    }

    @Override
    public void updateExpense(Expense expense) {

    }
}
