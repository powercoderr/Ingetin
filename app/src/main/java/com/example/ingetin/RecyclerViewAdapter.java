package com.example.ingetin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    Context mContext;
    private final List<Task> listTask;

    public RecyclerViewAdapter(Context mContext, List<Task> listTask) {
        this.mContext = mContext;
        this.listTask = listTask;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_task, parent, false);
        MyViewHolder vHolder = new MyViewHolder(v,listTask);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.taskTitle.setText(listTask.get(position).getTitle());
        holder.taskLabel.setText(listTask.get(position).getLabel());
        holder.taskDeadline.setText(listTask.get(position).getDeadline());
    }

    @Override
    public int getItemCount() {
        return listTask.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private Button taskLabel;
        private TextView taskTitle, taskDeadline;
        public MyViewHolder(@NonNull View itemView, List<Task> list) {
            super(itemView);
            taskLabel=(Button)itemView.findViewById(R.id.taskLabel);
            taskTitle=(TextView)itemView.findViewById(R.id.taskTitle);
            taskDeadline=(TextView)itemView.findViewById(R.id.taskDeadline);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), SecondActivity.class);
                    Bundle myBundle = new Bundle();
                    myBundle.putString("choice", "DetailTaskFragment");
                    myBundle.putString("taskTitle", list.get(getAdapterPosition()).getTitle());
                    myBundle.putString("taskLabel", list.get(getAdapterPosition()).getLabel());
                    myBundle.putString("taskDeadline", list.get(getAdapterPosition()).getDeadline());
                    myBundle.putString("taskNote", list.get(getAdapterPosition()).getNote());
                    intent.putExtras(myBundle);
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
