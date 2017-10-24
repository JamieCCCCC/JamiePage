package com.example.jamie.myapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class FigureActivity extends AppCompatActivity {
    private TabLayout tb_layout;
    private ViewPager viewPager;
    private TabAdaper tabAdaper;
    private String[] titles;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_figure);
        titles = getResources().getStringArray(R.array.tab_title);
        tabAdaper = new TabAdaper(getSupportFragmentManager(), titles);
        tb_layout = (TabLayout) findViewById(R.id.tb_layout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(tabAdaper);
        tb_layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        tb_layout.setupWithViewPager(viewPager);
        tb_layout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }
}

