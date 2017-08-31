package com.raneez.truewallet.addexpense;

import com.raneez.truewallet.BasePresenter;
import com.raneez.truewallet.BaseView;
import com.raneez.truewallet.data.Expense;
import com.raneez.truewallet.data.source.TrueWalletDataSource;

/**
 * Created by raneezahmed on 26/08/17.
 */

public interface AddExpenseContract {
    interface View extends BaseView<Presenter>{
        void showLoadingIndicator(boolean show);
        void onAddNewExpenseCompleted();
        void showAddExpenseValidationError();
    }

    interface Presenter extends BasePresenter{
        void addNewExpense(Expense newExpense);
    }
}
