package com.example.ingetin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intentReceiver = getIntent();
        Bundle bundleReceiver = intentReceiver.getExtras();

        if((bundleReceiver.getString("choice")).equals("AddTaskFragment")){
            AddTaskFragment addTaskFragment = new AddTaskFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.AddOrDetailContainer, addTaskFragment, null);
            transaction.commit();
        }else{
            DetailTaskFragment detailTaskFragment = new DetailTaskFragment(intentReceiver);
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.AddOrDetailContainer, detailTaskFragment, null);
            transaction.commit();


        }
    }
}