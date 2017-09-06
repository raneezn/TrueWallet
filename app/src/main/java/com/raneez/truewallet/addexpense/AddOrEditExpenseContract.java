package com.raneez.truewallet.addexpense;

import com.raneez.truewallet.BasePresenter;
import com.raneez.truewallet.BaseView;
import com.raneez.truewallet.data.Expense;
import com.raneez.truewallet.data.source.TrueWalletDataSource;

/**
 * Created by raneezahmed on 26/08/17.
 */

public interface AddOrEditExpenseContract {
    interface View extends BaseView<Presenter>{
        void showLoadingIndicator(boolean show);
        void onAddNewExpenseCompleted();
        void onUpdateExpenseCompleted();
        void showAddExpenseError(String message);
        void showUpdateExpenseError(String message);
        void showCurrentExpenseDetails(Expense expense);
        void setEditViews();
    }

    interface Presenter extends BasePresenter{
        void saveExpense(Expense newExpense);
        void getExpenseDetails(int id);
    }
}
