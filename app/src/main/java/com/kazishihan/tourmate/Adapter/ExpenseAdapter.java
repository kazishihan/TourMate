package com.kazishihan.tourmate.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kazishihan.tourmate.Classes.Expense;
import com.kazishihan.tourmate.Classes.MemoryClass;
import com.kazishihan.tourmate.R;

import java.util.List;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ViewHolder> {

    private List<Expense> expenseList;
    Context context;

    public ExpenseAdapter(List<Expense> expenseList, Context context) {
        this.expenseList = expenseList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wallet_item_list,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Expense expenseitem = expenseList.get(i);

        viewHolder.exTypeTv.setText(expenseitem.getExpenseType());
        viewHolder.exAmountTv.setText(expenseitem.getExpenseAmount());
        viewHolder.expenseTimeTv.setText(expenseitem.getExpenseDate());

    }

    @Override
    public int getItemCount() {
        return expenseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView exTypeTv,exAmountTv,expenseTimeTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
          exTypeTv = itemView.findViewById(R.id.expenseTypeListTvId);
          exAmountTv = itemView.findViewById(R.id.expenseAmountListTvId);
          expenseTimeTv = itemView.findViewById(R.id.expenseTimeTvId);

        }
    }
}
