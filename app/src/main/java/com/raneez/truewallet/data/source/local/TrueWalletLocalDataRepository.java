package com.raneez.truewallet.data.source.local;

import android.content.Context;

import com.raneez.truewallet.data.Expense;
import com.raneez.truewallet.data.source.TrueWalletDataSource;

import java.util.List;

/**
 * Created by raneezahmed on 20/08/17.
 */

public class TrueWalletLocalDataRepository implements TrueWalletDataSource {

    private static TrueWalletDataSource instance = null;
    private TrueWalletDAO trueWalletDAO = null;

    private TrueWalletLocalDataRepository(Context context){
        trueWalletDAO = TrueWalletDAO.getInstance(context);
    }

    public static TrueWalletDataSource getInstance(Context context) {
        if(instance == null){
            instance = new TrueWalletLocalDataRepository(context);
        }
        return instance;
    }

    @Override
    public void getAllExpenses(Callback<List<Expense>> callback) {
        List<Expense> result = trueWalletDAO.getAllExpenses();
        callback.onSuccess(result);
    }

    @Override
    public void getExpenseDetails(int id, Callback<Expense> callback) {
        Expense expense = trueWalletDAO.getExpenseDetails(id);
        if(expense != null) {
            callback.onSuccess(expense);
        }else{
            callback.onFailure(new Throwable("No expense data"));
        }
    }

    @Override
    public void saveExpense(Expense expense,Callback callback) {
        trueWalletDAO.saveExpense(expense);
        callback.onSuccess(null);
    }

    @Override
    public void removeExpense(Expense expense,Callback callback) {

    }

    @Override
    public void updateExpense(Expense expense,Callback callback) {
        trueWalletDAO.updateExpense(expense.getId(),expense,callback);
    }
}
