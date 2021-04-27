package com.example.ingetin;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle); //create parent (FragmentStateAdapter) Object //adapter untuk fragment.
    }

    @NonNull
    @Override
    //Membuat fragment sesuai posisi dari tab di tab layout (yang lagi di buka tau lagi di klik)
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 1 :
                return new OverdueTaskFragment();
        }
        return new UpcomingTaskFragment();
    }

    @Override
    //Returns the total number of items in the data set held by the adapter.
    public int getItemCount() {
        return 2;
    }
}
