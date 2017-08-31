package com.raneez.truewallet.addexpense;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.raneez.truewallet.R;
import com.raneez.truewallet.data.Expense;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * A placeholder fragment containing a simple view.
 */
public class AddExpenseActivityFragment extends Fragment implements AddExpenseContract.View,View.OnClickListener{

    AddExpenseContract.Presenter mPresenter;

    EditText editDesc;
    EditText editAmount;
    Button btnSaveExpense;

    public AddExpenseActivityFragment() {
    }

    public static AddExpenseActivityFragment newInstance() {
        AddExpenseActivityFragment fragment = new AddExpenseActivityFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_expense, container, false);

        editDesc = (EditText)view.findViewById(R.id.edit_expense_desc);
        editAmount = (EditText)view.findViewById(R.id.edit_expense_amount);
        btnSaveExpense = (Button)view.findViewById(R.id.save_expense);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btnSaveExpense.setOnClickListener(this);

    }

    @Override
    public void setPresenter(AddExpenseContract.Presenter presenter) {
        checkNotNull(presenter);
        mPresenter = presenter;

    }

    @Override
    public void showLoadingIndicator(boolean show) {

    }

    @Override
    public void onAddNewExpenseCompleted() {
        getActivity().finish();
    }

    @Override
    public void showAddExpenseValidationError() {
        Toast.makeText(getActivity(),"Error",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.save_expense:
                saveNewExpense();
                break;
        }
    }

    private void saveNewExpense() {
        String desription = editDesc.getText().toString();
        double amount = Double.parseDouble(editAmount.getText().toString());

        Expense expense = new Expense();
        expense.setDescription(desription);
        expense.setAmount(amount);

        mPresenter.addNewExpense(expense);
    }
}
