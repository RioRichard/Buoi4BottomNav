package com.example.buoi4bottomnav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ActionBar bar = getSupportActionBar();
        bar.hide();
        ViewPager2Adapter adapter  =  new ViewPager2Adapter(this);
        ViewPager2 viewPager2 = findViewById(R.id.view_pager2);
        viewPager2.setAdapter(adapter);
        BottomNavigationView btmNav = findViewById(R.id.bottom_nav);
        btmNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_course:
                        viewPager2.setCurrentItem(1);
                        break;
                    case R.id.menu_song:
                        viewPager2.setCurrentItem(2);
                        break;
                    default:
                        viewPager2.setCurrentItem(0);
                        break;

                }
                return true;

            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 1:
                        btmNav.getMenu().findItem(R.id.menu_course).setChecked(true);
                        break;
                    case 2:
                        btmNav.getMenu().findItem(R.id.menu_song).setChecked(true);
                        break;
                    default:
                        btmNav.getMenu().findItem(R.id.menu_home).setChecked(true);
                        break;

                }
                super.onPageSelected(position);
            }
        });
        viewPager2.setPageTransformer(new DepthPageTransform());

    }
}