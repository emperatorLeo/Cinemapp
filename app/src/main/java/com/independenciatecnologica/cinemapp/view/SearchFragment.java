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
import com.independenciatecnologica.cinemapp.adapter.SearchViewAdapter;
import com.independenciatecnologica.cinemapp.databinding.SearchFragmentBinding;
import com.independenciatecnologica.cinemapp.model.MoviePopular;
import com.independenciatecnologica.cinemapp.viewModel.MainActivityViewModel;
import com.independenciatecnologica.cinemapp.viewModel.SearchViewModel;

import java.util.List;

public class SearchFragment extends Fragment {
    private SearchViewModel viewModel;
    private SearchViewAdapter adapter;
    private MainActivityViewModel mainVM;
    private SearchFragmentBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.search_fragment,container,false);
        viewModel = ViewModelProviders.of(this).get(SearchViewModel.class);
        binding.setViewModel(viewModel);
        binding.searchList.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.searchProgresBar.setVisibility(View.GONE);
        adapter = new SearchViewAdapter(getContext());
        mainVM = ViewModelProviders.of(getActivity()).get(MainActivityViewModel.class);
        observers();
        return binding.getRoot();
    }

    private void observers() {
        mainVM.getQuerySearch().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                if (s.isEmpty() || s == null) {
                    binding.searchViewHolder.setVisibility(View.VISIBLE);
                } else {
                    binding.searchViewHolder.setVisibility(View.GONE);
                    binding.searchProgresBar.setVisibility(View.VISIBLE);
                    viewModel.setSearch(s);
                }

            }
        });
        if (viewModel != null) {
            viewModel.getSearch().observe(this, new Observer<List<MoviePopular>>() {
                @Override
                public void onChanged(@Nullable List<MoviePopular> moviePopulars) {

                    if( moviePopulars.isEmpty()){
                        binding.searchProgresBar.setVisibility(View.GONE);
                        binding.searchViewHolder.setText("NO MATCHES WITH YOUR SEARCH");
                        binding.searchViewHolder.setVisibility(View.VISIBLE);
                    }else{
                        binding.searchProgresBar.setVisibility(View.GONE);
                        adapter.setInfo(moviePopulars);
                        binding.searchList.setAdapter(adapter);
                    }
                }
            });

        }
    }
}
