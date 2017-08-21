package com.raneez.truewallet.main;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.raneez.truewallet.R;
import com.raneez.truewallet.addexpense.AddExpenseActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExpenseListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExpenseListFragment extends Fragment implements ExpenseContract.View {

    ExpenseContract.Presenter mPresenter;
    RecyclerView expenseRecyclerView;

    public ExpenseListFragment() {
        // Required empty public constructor
    }

    public static ExpenseListFragment newInstance(String param1, String param2) {
        ExpenseListFragment fragment = new ExpenseListFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_expense_list, container, false);

        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                mPresenter.addNewExpense();

            }
        });

        return root;

    }

    @Override
    public void setPresenter(ExpenseContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showLoadingIndicator(boolean show) {

    }

    @Override
    public void showAddExpense() {
        Intent intent = new Intent(getActivity(), AddExpenseActivity.class);
        startActivityForResult(intent,100);
    }
}
