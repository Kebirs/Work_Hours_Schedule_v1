package com.example.workhours.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;

public class FragmentPagerAdapter extends androidx.fragment.app.FragmentPagerAdapter {

    ArrayList<Fragment> pages = new ArrayList<>();

    public FragmentPagerAdapter(@NonNull FragmentManager fm, int behavior) {

        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return pages.get(position);
    }

    @Override
    public int getCount() {
        String[] months = new DateFormatSymbols().getMonths();
        return months.length;
    }

    // ADD A PAGE
    public void add_page(Fragment single_fragment) {
        pages.add(single_fragment);
    }

    // SET TITLE FOR TAB BY TAB POSITION

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        String[] months = new DateFormatSymbols().getMonths();

        ArrayList<String> months_list = new ArrayList<>(Arrays.asList(months));

        return months_list.get(position);
    }

}

