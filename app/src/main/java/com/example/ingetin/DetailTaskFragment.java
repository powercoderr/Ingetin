package com.example.ingetin;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class DetailTaskFragment extends Fragment {
    private Intent intentReceiver;

    public DetailTaskFragment(Intent intent) {
        this.intentReceiver = intent;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_detail_task, container, false);

        //Receive the bundle and set the view to it's data
        Bundle bundleReceiver = intentReceiver.getExtras();

        TextView titleInfo = (TextView)v.findViewById(R.id.detail_taskTitleInfo);
        TextView labelInfo = (TextView)v.findViewById(R.id.detail_taskLabelInfo);
        TextView deadlineInfo = (TextView)v.findViewById(R.id.detail_taskDeadlineInfo);
        TextView noteInfo = (TextView)v.findViewById(R.id.detail_taskNoteInfo);


        titleInfo.setText(bundleReceiver.getString("taskTitle"));
        labelInfo.setText(bundleReceiver.getString("taskLabel"));
        deadlineInfo.setText(bundleReceiver.getString("taskDeadline"));
        noteInfo.setText(bundleReceiver.getString("taskNote"));


        return v;
    }
}