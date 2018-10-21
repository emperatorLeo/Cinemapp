package com.independenciatecnologica.cinemapp.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.independenciatecnologica.cinemapp.R;
import com.independenciatecnologica.cinemapp.databinding.ItemMovieBinding;
import com.independenciatecnologica.cinemapp.databinding.ItemUpcomingBinding;
import com.independenciatecnologica.cinemapp.model.MovieUpComing;
import com.independenciatecnologica.cinemapp.model.Movies;

import java.util.ArrayList;
import java.util.List;

public class UpComingAdapter extends RecyclerView.Adapter<UpComingAdapter.MovieHolder> {

    private List<MovieUpComing> listItem = new ArrayList<>();

    public UpComingAdapter(List<MovieUpComing> list){
        this.listItem.addAll(list);
    }


    @Override
    public MovieHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        ItemUpcomingBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.item_upcoming,viewGroup,false);
        return new MovieHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder movieHolder, int i) {
        MovieUpComing model = listItem.get(i);
        movieHolder.bind(model);
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public class MovieHolder extends RecyclerView.ViewHolder{

        private ItemUpcomingBinding binding;

        public MovieHolder (ItemUpcomingBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(MovieUpComing item){
            binding.setViewModel(item);
            binding.executePendingBindings();

        }
    }
}

