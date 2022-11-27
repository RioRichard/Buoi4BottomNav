package com.example.buoi4bottomnav;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.buoi4bottomnav.Fragment.course;
import com.example.buoi4bottomnav.Fragment.home;
import com.example.buoi4bottomnav.Fragment.song;

public class ViewPager2Adapter extends FragmentStateAdapter {

    public ViewPager2Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new song();
            case 2:
                return new course();
            default:
                return new home();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
