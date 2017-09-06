package com.raneez.truewallet.addexpense;

import com.raneez.truewallet.data.Expense;
import com.raneez.truewallet.data.source.TrueWalletDataRepository;
import com.raneez.truewallet.data.source.TrueWalletDataSource;

/**
 * Created by raneezahmed on 27/08/17.
 */

public class AddOrEditExpensePresenter implements AddOrEditExpenseContract.Presenter {

    private final TrueWalletDataRepository repository;
    private final AddOrEditExpenseContract.View addExpenseView;
    boolean isDataMissing = true;
    int expenseId;

    public AddOrEditExpensePresenter(TrueWalletDataRepository repository, AddOrEditExpenseContract.View addExpenseView, int id) {
        this.repository = repository;
        this.addExpenseView = addExpenseView;
        expenseId = id;
        addExpenseView.setPresenter(this);
    }

    @Override
    public void start() {
        if(isDataMissing && expenseId != -1){
            getExpenseDetails(expenseId);
            addExpenseView.setEditViews();
            isDataMissing = false;
        }
    }

    @Override
    public void saveExpense(Expense newExpense) {
        newExpense.setId(expenseId);
        if(expenseId == -1) {
            repository.saveExpense(newExpense, new TrueWalletDataSource.Callback() {
                @Override
                public void onSuccess(Object data) {
                    addExpenseView.onAddNewExpenseCompleted();
                }

                @Override
                public void onFailure(Throwable t) {
                    addExpenseView.showAddExpenseError(t.getMessage());
                }
            });
        }else{
            repository.updateExpense(newExpense, new TrueWalletDataSource.Callback() {
                @Override
                public void onSuccess(Object data) {
                    addExpenseView.onUpdateExpenseCompleted();
                }

                @Override
                public void onFailure(Throwable t) {
                    addExpenseView.showUpdateExpenseError(t.getMessage());
                }
            });
        }
    }

    @Override
    public void getExpenseDetails(int id) {
        repository.getExpenseDetails(id, new TrueWalletDataSource.Callback<Expense>() {
            @Override
            public void onSuccess(Expense data) {
                addExpenseView.showCurrentExpenseDetails(data);
            }

            @Override
            public void onFailure(Throwable t) {
                //
            }
        });
    }
}
