package com.raneez.truewallet.data.source.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.raneez.truewallet.data.Expense;
import com.raneez.truewallet.data.source.TrueWalletDataSource;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by raneezahmed on 27/08/17.
 */

public class TrueWalletDAO implements DatabaseContract{

    static TrueWalletDAO instance = null;
    TrueWalletDBHelper dbHelper;


    private TrueWalletDAO(Context context) {
        dbHelper = new TrueWalletDBHelper(context);
    }

    public static TrueWalletDAO getInstance(Context context) {
        if(instance == null){
            instance = new TrueWalletDAO(context);
        }
        return instance;
    }


    @Override
    public void saveExpense(Expense expense) {
        checkNotNull(expense);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ExpenseEntry.COLUMN_NAME_DESCRIPTION,expense.getDescription());
        values.put(ExpenseEntry.COLUMN_NAME_AMOUNT,expense.getAmount());

        db.insert(ExpenseEntry.TABLE_NAME,null,values);
        db.close();
    }

    @Override
    public List<Expense> getAllExpenses() {
        List<Expense> expenses = new ArrayList<>();

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] projection = {
                ExpenseEntry._ID,
                ExpenseEntry.COLUMN_NAME_DESCRIPTION,
                ExpenseEntry.COLUMN_NAME_AMOUNT
        };

        Cursor c = db.query(ExpenseEntry.TABLE_NAME,projection,null,null,null,null,null);
        if(c != null && c.getCount() > 0){
            while (c.moveToNext()){
                int id = c.getInt(c.getColumnIndexOrThrow(ExpenseEntry._ID));
                String desc = c.getString(c.getColumnIndexOrThrow(ExpenseEntry.COLUMN_NAME_DESCRIPTION));
                double amount = c.getDouble(c.getColumnIndexOrThrow(ExpenseEntry.COLUMN_NAME_AMOUNT));
                System.out.println(" ID : "+id);
                Expense expense = new Expense();
                expense.setId(id);
                expense.setDescription(desc);
                expense.setAmount(amount);

                expenses.add(expense);
            }
        }

        if(c != null){
            c.close();
        }
        db.close();

        return expenses;
    }

    @Override
    public Expense getExpenseDetails(int expenseId) {
        Expense expense = null;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] projection = {
                ExpenseEntry._ID,
                ExpenseEntry.COLUMN_NAME_DESCRIPTION,
                ExpenseEntry.COLUMN_NAME_AMOUNT
        };
        String selection = ExpenseEntry._ID + " = ?";
        String selectionArgs[] = new String[]{expenseId + ""};

        Cursor c = db.query(ExpenseEntry.TABLE_NAME,projection,selection,selectionArgs,null,null,null);
        if(c != null && c.getCount() > 0){
            while (c.moveToNext()){
                int id = c.getInt(c.getColumnIndexOrThrow(ExpenseEntry._ID));
                String desc = c.getString(c.getColumnIndexOrThrow(ExpenseEntry.COLUMN_NAME_DESCRIPTION));
                double amount = c.getDouble(c.getColumnIndexOrThrow(ExpenseEntry.COLUMN_NAME_AMOUNT));
                System.out.println(" ID : "+id);

                expense = new Expense();
                expense.setId(id);
                expense.setDescription(desc);
                expense.setAmount(amount);

            }
        }

        if(c != null){
            c.close();
        }
        db.close();

        return expense;
    }

    @Override
    public void updateExpense(int id, Expense updatedExpense, TrueWalletDataSource.Callback callback) {
        checkNotNull(updatedExpense);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String where = ExpenseEntry._ID + "= ?";
        String[] whereArgs = new String[]{id+""};

        ContentValues values = new ContentValues();
        values.put(ExpenseEntry.COLUMN_NAME_DESCRIPTION,updatedExpense.getDescription());
        values.put(ExpenseEntry.COLUMN_NAME_AMOUNT,updatedExpense.getAmount());

        int rowsUpdated = db.update(ExpenseEntry.TABLE_NAME,values,where,whereArgs);
        db.close();

        if(rowsUpdated > 0){
            callback.onSuccess(rowsUpdated);
        }else{
            callback.onFailure(new Throwable("update failed"));
        }
    }

    @Override
    public void deleteExpense(int id, TrueWalletDataSource.Callback callback) {

    }
}
