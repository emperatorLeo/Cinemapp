package com.independenciatecnologica.cinemapp.view;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.independenciatecnologica.cinemapp.R;
import com.independenciatecnologica.cinemapp.adapter.TopRatedAdapter;
import com.independenciatecnologica.cinemapp.databinding.FragmentMovieTopRatedBinding;
//import com.independenciatecnologica.cinemapp.model.MovieTopRated;
import com.independenciatecnologica.cinemapp.model.MovieTopRated;
import com.independenciatecnologica.cinemapp.viewModel.MainActivityViewModel;
import com.independenciatecnologica.cinemapp.viewModel.MoviesTopRatedViewModel;

import java.util.ArrayList;
import java.util.List;

public class MovieTopRatedFragment extends Fragment {
    private FragmentMovieTopRatedBinding binding;
    private TopRatedAdapter adapter;
    private MoviesTopRatedViewModel viewModel;
    private MainActivityViewModel activityViewModel;
    private String TAG = "topRatedFragment";
    private boolean visible;
    private int id;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_movie_top_rated,container,false);
        binding.topRatedList.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new TopRatedAdapter(getActivity());
        viewModel = ViewModelProviders.of(this).get(MoviesTopRatedViewModel.class);
        binding.setTopViewModel(viewModel);
        activityViewModel = ViewModelProviders.of(getActivity()).get(MainActivityViewModel.class);
        observers();
        id = getId();
        visible = this.isVisible();

        /* viewModel.delteAll();*/
        return binding.getRoot();
    }


    private void observers (){
        viewModel.getTopRatedList().observe(this, new Observer<List<MovieTopRated>>() {
            @Override
            public void onChanged(@Nullable List<MovieTopRated> movieTopRateds) {

                Log.d("topRatedObserver","is empty: "+movieTopRateds.isEmpty());

               if(!movieTopRateds.isEmpty()){
                   binding.topRatedProgressBar.setVisibility(View.GONE);
                   adapter.setInfo(movieTopRateds);
                   binding.topRatedList.setAdapter(adapter);
                   /**/}else viewModel.callTopRated();
            }
        });
        activityViewModel.getQuery().observe(this, new Observer<String>() {

            @Override
            public void onChanged(@Nullable String s) {
                adapter.getFilter().filter(s);
            }
        });
    }


}
