package com.raneez.truewallet.data.source.remote;

import com.raneez.truewallet.data.Expense;
import com.raneez.truewallet.data.source.TrueWalletDataSource;

import java.util.List;

/**
 * Created by raneezahmed on 20/08/17.
 */

public class TrueWalletRemoteDataRepository implements TrueWalletDataSource {

    private static TrueWalletDataSource instance = null;

    private TrueWalletRemoteDataRepository(){

    }

    public static TrueWalletDataSource getInstance() {
        if(instance == null){
            instance = new TrueWalletRemoteDataRepository();
        }
        return instance;
    }

    @Override
    public void getAllExpenses(Callback<List<Expense>> callback) {

    }

    @Override
    public void getExpenseDetails(int id, Callback<Expense> callback) {

    }

    @Override
    public void saveExpense(Expense expense,Callback callback) {

    }

    @Override
    public void removeExpense(Expense expense,Callback callback) {

    }

    @Override
    public void updateExpense(Expense expense,Callback callback) {

    }
}
