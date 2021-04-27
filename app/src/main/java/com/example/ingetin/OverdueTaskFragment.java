package com.example.ingetin;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class OverdueTaskFragment extends Fragment {
    View v;
    RecyclerView recyclerView;
    private List<Task> listTask;
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_overdue_task, container, false);
        recyclerView = (RecyclerView)v.findViewById(R.id.recyclerViewOverdue);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), listTask);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listTask = new ArrayList<>();
        listTask.add(new Task("Membuat Mock Up", "PPB", "10 Januari 2021", "tugas Bro"));
        listTask.add(new Task("Membuat Mind Map", "PPL", "10 Januari 2021", "tugas Bro"));
        listTask.add(new Task("Membuat Aplikasi", "PPB", "10 Januari 2021", "tugas Bro"));
        listTask.add(new Task("Membuat Karya Tulis", "PKN", "10 Januari 2021", "tugas Bro"));
    }
}