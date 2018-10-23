package com.independenciatecnologica.cinemapp.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.independenciatecnologica.cinemapp.R;
import com.independenciatecnologica.cinemapp.adapter.PopularAdapter;
import com.independenciatecnologica.cinemapp.databinding.FragmentMoviePopularBinding;
import com.independenciatecnologica.cinemapp.model.MoviePopular;
import com.independenciatecnologica.cinemapp.viewModel.MoviesPopularViewModel;

import java.util.List;

public class MoviePopularFragment extends Fragment {
   private MoviesPopularViewModel viewModel;
   private FragmentMoviePopularBinding binding ;
   private PopularAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_movie_popular,container,false);
        binding.popularList.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.popularProgresBar.setVisibility(View.VISIBLE);
        adapter = new PopularAdapter(getContext());
        viewModel = ViewModelProviders.of(this).get(MoviesPopularViewModel.class);
        viewModel.getPopularList().observe(this, new Observer<List<MoviePopular>>() {
            @Override
            public void onChanged(@Nullable List<MoviePopular> moviePopulars) {
                Log.d("topRatedObserver","is empty: "+moviePopulars.isEmpty());
               /* if(!moviePopulars.isEmpty()){
                    binding.popularList.setAdapter(adapter);
                    binding.popularProgresBar.setVisibility(View.GONE);
                    adapter.setInfo(moviePopulars);
                    }else viewModel.callPopular();*/
            }
        });

        return binding.getRoot();
    }

}
