package com.raneez.truewallet.data.source;

import com.raneez.truewallet.data.Expense;

import java.util.List;

/**
 * Created by raneezahmed on 20/08/17.
 */

public interface TrueWalletDataSource {

    interface Callback<T>{
        void onSuccess(T data);
        void onFailure(Throwable t);
    }

    void getAllExpenses(Callback<List<Expense>> callback);
    void getExpenseDetails(int id,Callback<Expense> callback);
    void saveExpense(Expense expense,Callback callback);
    void removeExpense(Expense expense,Callback callback);
    void updateExpense(Expense expense,Callback callback);
}
