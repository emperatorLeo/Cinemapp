package com.independenciatecnologica.cinemapp.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.independenciatecnologica.cinemapp.R;
import com.independenciatecnologica.cinemapp.adapter.UpComingAdapter;
import com.independenciatecnologica.cinemapp.databinding.FragmentMovieUpcomingBinding;
import com.independenciatecnologica.cinemapp.model.MovieUpComing;
import com.independenciatecnologica.cinemapp.viewModel.MoviesUpComingViewModel;

import java.util.List;

public class MovieUpComingFragment extends Fragment {
    private MoviesUpComingViewModel viewModel;
    private FragmentMovieUpcomingBinding binding;
    private UpComingAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_movie_upcoming,container,false);
        binding.upComingList.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.upComingProgresBar.setVisibility(View.VISIBLE);
        adapter = new UpComingAdapter(getContext());
        viewModel = ViewModelProviders.of(this).get(MoviesUpComingViewModel.class);
        viewModel.getUpComingList().observe(this, new Observer<List<MovieUpComing>>() {
            @Override
            public void onChanged(@Nullable List<MovieUpComing> movieUpComings) {
                if(!movieUpComings.isEmpty()){
                    binding.upComingList.setAdapter(adapter);
                    binding.upComingProgresBar.setVisibility(View.GONE);
                    adapter.setInfo(movieUpComings);
                    }else viewModel.callUpComing();
            }
        });


        return binding.getRoot();
    }
}
