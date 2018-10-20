package com.independenciatecnologica.cinemapp.view;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.independenciatecnologica.cinemapp.R;
import com.independenciatecnologica.cinemapp.adapter.MoviePagerAdapter;
import com.independenciatecnologica.cinemapp.adapter.SeriesPagerAdapter;

import static com.independenciatecnologica.cinemapp.utils.Constants.TAG;
public class ContainerSeriesFragment extends Fragment {
    private View view;
    private ViewPager pager;
    private TabLayout tabLayout;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_series_container,container,false);
        pager = view.findViewById(R.id.seriesContainer);
        tabLayout = view.findViewById(R.id.seriesTabLayout);
        SeriesPagerAdapter pagerAdapter = new SeriesPagerAdapter(getFragmentManager());
        if(pagerAdapter==null)Log.d(TAG,"pagerAdapter is null");
        else Log.d(TAG,"pager Adapter is NOT null");
        pagerAdapter.addFragments(new SeriesTopRatedFragment(),"Top Rated");
        pagerAdapter.addFragments(new SeriesPopularFragment(),"Popular");
        pagerAdapter.addFragments(new SeriesLatestFragment(),"Latest");
        pager.setAdapter(pagerAdapter);
        pager.setCurrentItem(0);
        tabLayout.setupWithViewPager(pager);
        return view;
    }
}
