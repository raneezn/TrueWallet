package com.raneez.truewallet.main;

import com.raneez.truewallet.data.Expense;
import com.raneez.truewallet.data.source.TrueWalletDataRepository;
import com.raneez.truewallet.data.source.TrueWalletDataSource;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by raneezahmed on 21/08/17.
 */

public class ExpenseListPresenter implements ExpenseContract.Presenter {

    private final TrueWalletDataRepository trueWalletDataRepository;
    private final ExpenseContract.View expenseListView;

    public ExpenseListPresenter(TrueWalletDataRepository trueWalletDataRepository, ExpenseContract.View expenseListView) {
        this.trueWalletDataRepository = checkNotNull(trueWalletDataRepository,"repository cannot be null");
        this.expenseListView = checkNotNull(expenseListView,"view cannot be null");

        expenseListView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void fetchAllExpenses() {
        trueWalletDataRepository.getAllExpenses(new TrueWalletDataSource.Callback<List<Expense>>() {
            @Override
            public void onSuccess(List<Expense> data) {
                expenseListView.showAllExpenses(data);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    @Override
    public void addNewExpense() {
        expenseListView.showAddExpense();
    }
}
