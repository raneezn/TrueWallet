package com.raneez.truewallet.data.source;

import com.raneez.truewallet.data.Expense;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

/**
 * Created by raneezahmed on 20/08/17.
 */

public class TrueWalletDataRepository implements TrueWalletDataSource {

    private static TrueWalletDataRepository instance = null;

    private final TrueWalletDataSource mTrueWalletLocalDataSource;

    private final TrueWalletDataSource mTrueWalletRemoteDataSource;

    private TrueWalletDataRepository(TrueWalletDataSource localDataSource, TrueWalletDataSource remoteDataSource){
        mTrueWalletLocalDataSource = checkNotNull(localDataSource);
        mTrueWalletRemoteDataSource = checkNotNull(remoteDataSource);
    }

    public static TrueWalletDataRepository getInstance(TrueWalletDataSource localDataSource,TrueWalletDataSource remoteDataSource) {
        if(instance == null){
            instance = new TrueWalletDataRepository(localDataSource,remoteDataSource);
        }
        return instance;
    }

    @Override
    public void getAllExpenses(Callback<List<Expense>> callback) {
        mTrueWalletLocalDataSource.getAllExpenses(callback);
    }

    @Override
    public void getExpenseDetails(String id, Callback<Expense> callback) {

    }

    @Override
    public void saveExpense(Expense expense, final Callback callback) {
        mTrueWalletLocalDataSource.saveExpense(expense, callback);
    }

    @Override
    public void removeExpense(Expense expense) {

    }

    @Override
    public void updateExpense(Expense expense) {

    }
}
