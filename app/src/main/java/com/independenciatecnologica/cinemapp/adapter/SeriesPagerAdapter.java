package com.independenciatecnologica.cinemapp.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SeriesPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> lf = new ArrayList<>();
    private List<String> ls = new ArrayList<>();

    public SeriesPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return lf.get(i);
    }

    public void addFragments(Fragment fragment, String title) {
        lf.add(fragment);
        ls.add(title);
    }

    @Override
    public int getCount() {
        return lf.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return ls.get(position);
    }
}
