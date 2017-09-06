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
public class AddOrEditExpenseFragment extends Fragment implements AddOrEditExpenseContract.View,View.OnClickListener{
    public static final String EXPENSE_ID = "expense_id";

    AddOrEditExpenseContract.Presenter mPresenter;

    EditText editDesc;
    EditText editAmount;
    Button btnSaveExpense;

    public AddOrEditExpenseFragment() {
    }

    public static AddOrEditExpenseFragment newInstance() {
        AddOrEditExpenseFragment fragment = new AddOrEditExpenseFragment();
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
    public void onResume() {
        super.onResume();
        if(mPresenter != null){
            mPresenter.start();
        }
    }

    @Override
    public void setPresenter(AddOrEditExpenseContract.Presenter presenter) {
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
    public void onUpdateExpenseCompleted() {
        getActivity().finish();
    }

    @Override
    public void showAddExpenseError(String message) {
        Toast.makeText(getActivity(),"Add Error",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUpdateExpenseError(String message) {
        Toast.makeText(getActivity(),message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showCurrentExpenseDetails(Expense expense) {
        if(expense != null){
            editDesc.setText(expense.getDescription());
            editAmount.setText(expense.getAmount()+"");
        }
    }

    @Override
    public void setEditViews() {
        btnSaveExpense.setText("Update Expense");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.save_expense:
                saveExpense();
                break;
        }
    }

    private void saveExpense() {
        String desription = editDesc.getText().toString();
        double amount = Double.parseDouble(editAmount.getText().toString());

        Expense expense = new Expense();
        expense.setDescription(desription);
        expense.setAmount(amount);

        mPresenter.saveExpense(expense);
    }
}
