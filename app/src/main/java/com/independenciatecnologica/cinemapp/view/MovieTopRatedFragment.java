package com.independenciatecnologica.cinemapp.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.independenciatecnologica.cinemapp.R;
import com.independenciatecnologica.cinemapp.adapter.TopRatedAdapter;
import com.independenciatecnologica.cinemapp.databinding.FragmentMovieTopRatedBinding;
//import com.independenciatecnologica.cinemapp.model.MovieTopRated;
import com.independenciatecnologica.cinemapp.model.MovieTopRated;
import com.independenciatecnologica.cinemapp.viewModel.MoviesTopRatedViewModel;

import java.util.List;

public class MovieTopRatedFragment extends Fragment {
    private FragmentMovieTopRatedBinding binding;
    private TopRatedAdapter adapter;
    private MoviesTopRatedViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_movie_top_rated,container,false);
        binding.topRatedList.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.topRatedProgressBar.setVisibility(View.VISIBLE);
        adapter = new TopRatedAdapter(getActivity());
        viewModel = ViewModelProviders.of(this).get(MoviesTopRatedViewModel.class);
        viewModel.getTopRatedList().observe(this, new Observer<List<MovieTopRated>>() {
            @Override
            public void onChanged(@Nullable List<MovieTopRated> movieTopRateds) {

                Log.d("topRatedObserver","is empty: "+movieTopRateds.isEmpty());

               if(!movieTopRateds.isEmpty()){
                    binding.topRatedList.setAdapter(adapter);
                    binding.topRatedProgressBar.setVisibility(View.GONE);
                    adapter.setInfo(movieTopRateds);
                    Log.d("topRatedObserver","Budget: "+movieTopRateds.get(0).getBudget());
                    }else viewModel.callTopRated(); /**/
             }
        });/* viewModel.delteAll();*/
        return binding.getRoot();
    }
}
