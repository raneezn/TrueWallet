package com.raneez.truewallet.main;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.raneez.truewallet.R;
import com.raneez.truewallet.addexpense.AddExpenseActivity;
import com.raneez.truewallet.data.Expense;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExpenseListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExpenseListFragment extends Fragment implements ExpenseContract.View {

    ExpenseContract.Presenter mPresenter;
    RecyclerView expenseRecyclerView;
    ExpenseListRVAdapter adapter;

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
        adapter = new ExpenseListRVAdapter(null);
        expenseRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        expenseRecyclerView.setAdapter(adapter);

        mPresenter.fetchAllExpenses();
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

        expenseRecyclerView = (RecyclerView) root.findViewById(R.id.expenseListRecyclerView);

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
    public void showAllExpenses(List<Expense> data) {
        if(adapter != null) {
            adapter.updateData(data);
        }
    }

    @Override
    public void showAddExpense() {
        Intent intent = new Intent(getActivity(), AddExpenseActivity.class);
        startActivityForResult(intent,100);
    }

    private class ExpenseListRVAdapter extends RecyclerView.Adapter<ExpenseListRVAdapter.ExpenseViewHolder> {

        List<Expense> dataset;
        public ExpenseListRVAdapter(List<Expense> data) {
            dataset = data;
        }

        public void updateData(List<Expense> newData){
            dataset = newData;
            notifyDataSetChanged();
        }

        @Override
        public ExpenseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.expense_list_rv_item,parent,false);
            return new ExpenseViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ExpenseViewHolder holder, int position) {
            holder.bindData(dataset.get(position));
        }

        @Override
        public int getItemCount() {
            if(dataset != null)
                return dataset.size();
            else
                return 0;
        }


        class ExpenseViewHolder extends RecyclerView.ViewHolder{

            TextView expenseDesc;
            TextView expenseAmount;

            public ExpenseViewHolder(View itemView) {
                super(itemView);
                expenseDesc = (TextView)itemView.findViewById(R.id.expense_desc);
                expenseAmount = (TextView)itemView.findViewById(R.id.expense_amount);
            }

            public void bindData(Expense expense){
                expenseDesc.setText(expense.getDescription());
                expenseAmount.setText(expense.getAmount() + "");
            }
        }
    }
}
