package com.raneez.truewallet.data.source.local;

import android.provider.BaseColumns;

import com.raneez.truewallet.data.Expense;
import com.raneez.truewallet.data.source.TrueWalletDataSource;

import java.util.List;

/**
 * Created by raneezahmed on 27/08/17.
 */

public interface DatabaseContract {
    void saveExpense(Expense expense);
    List<Expense> getAllExpenses();
    Expense getExpenseDetails(int id);
    void updateExpense(int id, Expense data, TrueWalletDataSource.Callback callback);
    void deleteExpense(int id, TrueWalletDataSource.Callback callback);

    public class ExpenseEntry implements BaseColumns {
        public static final String TABLE_NAME = "TrueWalletExpense";
        public static final String COLUMN_NAME_ID = "id";
        //public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
        public static final String COLUMN_NAME_AMOUNT = "amount";
    }

}
