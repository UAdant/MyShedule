package com.example.myshedule;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {
    private List<CardData> dataList;

    public TaskAdapter(List<CardData> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CardData data = dataList.get(position);
        holder.textViewDate.setText(data.getDate());

        for (String task : data.getTasks()) {
            Button button = new Button(holder.itemView.getContext());
            button.setText(task);
            holder.tasksLayout.addView(button);
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewDate;
        LinearLayout tasksLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewDate = itemView.findViewById(R.id.textViewDate);
            tasksLayout = itemView.findViewById(R.id.tasksLayout);
        }
    }
}
