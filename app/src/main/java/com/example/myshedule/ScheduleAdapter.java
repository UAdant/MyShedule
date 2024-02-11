package com.example.myshedule;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myshedule.R;
import com.example.myshedule.ScheduleEntry;

import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder> {
    private List<ScheduleEntry> scheduleList;
    private Context context;

    public ScheduleAdapter(Context context, List<ScheduleEntry> scheduleList) {
        this.context = context;
        this.scheduleList = scheduleList;
    }

    @NonNull
    @Override
    public ScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.schedule_item, parent, false);
        return new ScheduleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleViewHolder holder, int position) {
        ScheduleEntry entry = scheduleList.get(position);
        holder.textViewSubject.setText(entry.getSubject());
        holder.textViewType.setText(entry.getType());
        holder.textViewDate.setText(entry.getDate());
    }

    @Override
    public int getItemCount() {
        return scheduleList.size();
    }

    public class ScheduleViewHolder extends RecyclerView.ViewHolder {
        TextView textViewSubject, textViewType, textViewDate;

        public ScheduleViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewSubject = itemView.findViewById(R.id.textViewSubject);
            textViewType = itemView.findViewById(R.id.textViewType);
            textViewDate = itemView.findViewById(R.id.textViewDate);
        }
    }
}

