package com.raneez.truewallet.main;

import com.raneez.truewallet.BasePresenter;
import com.raneez.truewallet.BaseView;
import com.raneez.truewallet.data.Expense;

import java.util.List;

/**
 * Created by raneezahmed on 21/08/17.
 */

public interface ExpenseContract {

    interface View extends BaseView<Presenter>{
        void showLoadingIndicator(boolean show);
        void showAllExpenses(List<Expense> data);
        void showAddExpense();
    }

    interface Presenter extends BasePresenter{
        void fetchAllExpenses();
        void addNewExpense();
    }
}
