package com.example.ingetin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UpcomingTaskFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UpcomingTaskFragment extends Fragment {
    View v;
    RecyclerView recyclerView;
    private List<Task> listTask;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_upcoming_task, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerViewUpcoming);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), listTask);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listTask = new ArrayList<>();
        listTask.add(new Task("Tugas PPB Database", "PPB", "27 April 2021", "tugas Bro"));
        listTask.add(new Task("Karya Tulis Pancasila", "PPL", "27 April 2021", "tugas Bro"));
        listTask.add(new Task("Dokumentasi PPL", "PPL", "27 April 2021", "tugas Bro"));
        listTask.add(new Task("Menyelesaikan Landing Page Short URL API", "PPL", "1 Mei 2021", "tugas Bro"));
        listTask.add(new Task("Review CSS", "PPL", "1 Mei 2021", "tugas Bro"));
        listTask.add(new Task("Review JS", "PPL", "1 Mei 2021", "tugas Bro"));
        listTask.add(new Task("Selesaikan course plursalsight", "PPL", "1 Mei 2021", "tugas Bro"));
    }
}