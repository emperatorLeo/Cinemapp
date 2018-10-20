package com.independenciatecnologica.cinemapp.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.independenciatecnologica.cinemapp.R;
import com.independenciatecnologica.cinemapp.databinding.ItemMovieBinding;
import com.independenciatecnologica.cinemapp.model.Movies;
import com.independenciatecnologica.cinemapp.viewModel.MoviesViewModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerMovieAdapter extends RecyclerView.Adapter<RecyclerMovieAdapter.MovieHolder> {

    private List<Movies> listItem = new ArrayList<>();

    public RecyclerMovieAdapter(List<Movies> list){
        this.listItem.addAll(list);
    }


    @Override
    public MovieHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        ItemMovieBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.item_movie,viewGroup,false);
        return new MovieHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder movieHolder, int i) {
        Movies model = listItem.get(i);
        movieHolder.bind(model);
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public class MovieHolder extends RecyclerView.ViewHolder{
        private ItemMovieBinding binding;

        public MovieHolder (ItemMovieBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Movies item){
            binding.setViewModel(item);
            binding.executePendingBindings();

        }
    }
}
