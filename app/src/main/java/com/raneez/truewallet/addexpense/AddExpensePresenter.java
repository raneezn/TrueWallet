package com.raneez.truewallet.addexpense;

import com.raneez.truewallet.data.Expense;
import com.raneez.truewallet.data.source.TrueWalletDataRepository;
import com.raneez.truewallet.data.source.TrueWalletDataSource;

/**
 * Created by raneezahmed on 27/08/17.
 */

public class AddExpensePresenter implements AddExpenseContract.Presenter {

    private final TrueWalletDataRepository repository;
    private final AddExpenseContract.View addExpenseView;

    public AddExpensePresenter(TrueWalletDataRepository repository, AddExpenseContract.View addExpenseView) {
        this.repository = repository;
        this.addExpenseView = addExpenseView;

        addExpenseView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void addNewExpense(Expense newExpense) {
        repository.saveExpense(newExpense, new TrueWalletDataSource.Callback() {
            @Override
            public void onSuccess(Object data) {
                addExpenseView.onAddNewExpenseCompleted();
            }

            @Override
            public void onFailure(Throwable t) {
                addExpenseView.showAddExpenseValidationError();
            }
        });
    }
}
