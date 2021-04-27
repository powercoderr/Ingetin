package com.example.ingetin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager;
    ViewPagerAdapter adapter;

    public static final String EXTRA_MESSAGE = "com.example.ingetin.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Binding view
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        viewPager = (ViewPager2)findViewById(R.id.viewPager);

        
        FragmentManager fragmentManager = getSupportFragmentManager();
        //instansiasi object dari ViewPagerAdapter
        adapter = new ViewPagerAdapter(fragmentManager, getLifecycle());

        //set view ViewPager2 dengan adapter(object dari ViewPagerAdapter)
        viewPager.setAdapter(adapter);

        //Set dua tab ke dalam view Tab Layout
        tabLayout.addTab(tabLayout.newTab().setText("Upcoming Task"));
        tabLayout.addTab(tabLayout.newTab().setText("Overdue Task"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //Jika di tab pertama, maka getPosition = 0 , maka di bawah argumenntya tab.0 atau tab pertama.
                //Karena si viewPager menampung adapter, maka item si viewPager jadi menampung item pertama di adaapter. dst untuk position ynag lain.
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

        Intent intent = new Intent(this, SecondActivity.class);
        FloatingActionButton addTaskButton = findViewById(R.id.addTask);
        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle myBundle = new Bundle();
                myBundle.putString("choice", "AddTaskFragment");
                intent.putExtras(myBundle);
                startActivity(intent);
            }
        });

    }
}