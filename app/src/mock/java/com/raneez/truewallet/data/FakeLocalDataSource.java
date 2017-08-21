package com.raneez.truewallet.data;

import com.raneez.truewallet.data.source.TrueWalletDataSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by raneezahmed on 21/08/17.
 */

public class FakeLocalDataSource implements TrueWalletDataSource {

    private static TrueWalletDataSource instance = null;
    List<Expense> MOCK_DATA = new ArrayList<>();

    public static TrueWalletDataSource getInstance() {
        if(instance == null){
            instance = new FakeLocalDataSource();
        }
        return instance;
    }

    @Override
    public void getAllExpenses(Callback<List<Expense>> callback) {
        callback.onSuccess(getMockExpenseData());
    }

    @Override
    public void getExpenseDetails(String id, Callback<Expense> callback) {

    }

    @Override
    public void saveExpense(Expense expense) {
        MOCK_DATA.add(expense);
    }

    @Override
    public void removeExpense(Expense expense) {
        MOCK_DATA.remove(expense);
    }

    @Override
    public void updateExpense(Expense expense) {

    }

    private List<Expense> getMockExpenseData(){

        for(int i =0 ; i < 3; i++){
            int random = new Random().nextInt();

            Expense expense = new Expense();
            expense.setDescription("Expense "+i);
            expense.setAmount(i * random * 100);

            MOCK_DATA.add(expense);
        }

        return MOCK_DATA;
    }
}
