package com.example.jamie.myapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.example.jamie.myapp.TabFragment;

public class TabAdaper extends FragmentPagerAdapter {
    private String[] names;

    public TabAdaper(FragmentManager fm, String[] names) {
        super(fm);
        this.names = names;
    }

    @Override
    public Fragment getItem(int position) {
        return TabFragment.getInstance(position);
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return names[position];
    }
}