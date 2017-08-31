package com.raneez.truewallet.data.source.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.raneez.truewallet.data.source.local.DatabaseContract.ExpenseEntry.COLUMN_NAME_AMOUNT;
import static com.raneez.truewallet.data.source.local.DatabaseContract.ExpenseEntry.COLUMN_NAME_DESCRIPTION;
import static com.raneez.truewallet.data.source.local.DatabaseContract.ExpenseEntry.COLUMN_NAME_ID;
import static com.raneez.truewallet.data.source.local.DatabaseContract.ExpenseEntry.TABLE_NAME;

/**
 * Created by raneezahmed on 27/08/17.
 */

public class TrueWalletDBHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "TrueWallet";

    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";

    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + TABLE_NAME +
            " (" + COLUMN_NAME_ID + TEXT_TYPE + " PRIMARY KEY" + COMMA_SEP +
            COLUMN_NAME_DESCRIPTION + TEXT_TYPE + COMMA_SEP +
            COLUMN_NAME_AMOUNT + INTEGER_TYPE + ")";

    public TrueWalletDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
