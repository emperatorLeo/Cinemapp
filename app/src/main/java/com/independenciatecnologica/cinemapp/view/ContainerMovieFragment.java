package com.independenciatecnologica.cinemapp.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.independenciatecnologica.cinemapp.R;
import com.independenciatecnologica.cinemapp.adapter.MoviePagerAdapter;
import com.independenciatecnologica.cinemapp.viewModel.MainActivityViewModel;

import static com.independenciatecnologica.cinemapp.utils.Constants.TAG;
public class ContainerMovieFragment extends Fragment {
  private View view;
  private ViewPager pager;
  private TabLayout tabLayout;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_movie_container,container,false);
        pager = view.findViewById(R.id.movieContainer);
        tabLayout = view.findViewById(R.id.movieTabLayout);
        MoviePagerAdapter pagerAdapter = null;
        pagerAdapter = new MoviePagerAdapter(getFragmentManager());

        pagerAdapter.addFragments(new MovieTopRatedFragment(),"Top Rated");
        pagerAdapter.addFragments(new MoviePopularFragment(),"Popular");
        pagerAdapter.addFragments(new MovieUpComingFragment(),"Up coming");
        pagerAdapter.addFragments(new SearchFragment(),"Search");
        pager.setAdapter(pagerAdapter);
        Log.d(TAG,"pager adapter count: "+pagerAdapter.getCount());
        pager.setCurrentItem(0);
        tabLayout.setupWithViewPager(pager);

        return view;
    }






}
