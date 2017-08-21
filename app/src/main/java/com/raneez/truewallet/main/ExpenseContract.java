package com.raneez.truewallet.main;

import com.raneez.truewallet.BasePresenter;
import com.raneez.truewallet.BaseView;

/**
 * Created by raneezahmed on 21/08/17.
 */

public interface ExpenseContract {

    interface View extends BaseView<Presenter>{
        void showLoadingIndicator(boolean show);
        void showAddExpense();
    }

    interface Presenter extends BasePresenter{
        void addNewExpense();
    }
}
