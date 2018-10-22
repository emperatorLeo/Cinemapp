package com.independenciatecnologica.cinemapp.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.independenciatecnologica.cinemapp.R;
import com.independenciatecnologica.cinemapp.databinding.ItemUpcomingBinding;
import com.independenciatecnologica.cinemapp.model.MovieUpComing;


import java.util.ArrayList;
import java.util.List;

public class UpComingAdapter extends RecyclerView.Adapter<UpComingAdapter.MovieHolder> {

    private List<MovieUpComing> listItem = new ArrayList<>();
    private LayoutInflater inflater;

    public UpComingAdapter(Context context){
        inflater = LayoutInflater.from(context);
    }
    public void setInfo(List<MovieUpComing> list){
        this.listItem.addAll(list);
    }


    @Override
    public MovieHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
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

