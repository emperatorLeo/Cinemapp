package com.independenciatecnologica.cinemapp.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.independenciatecnologica.cinemapp.R;
import com.independenciatecnologica.cinemapp.databinding.ItemPopularBinding;
import com.independenciatecnologica.cinemapp.databinding.ItemUpcomingBinding;
import com.independenciatecnologica.cinemapp.model.MoviePopular;
import com.independenciatecnologica.cinemapp.model.MovieUpComing;

import java.util.ArrayList;
import java.util.List;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.MovieHolder> {

    private List<MoviePopular> listItem = new ArrayList<>();

    public PopularAdapter(List<MoviePopular> list){
        this.listItem.addAll(list);
    }


    @Override
    public MovieHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        ItemPopularBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.item_popular,viewGroup,false);
        return new MovieHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder movieHolder, int i) {
        MoviePopular model = listItem.get(i);
        movieHolder.bind(model);
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public class MovieHolder extends RecyclerView.ViewHolder{

        private ItemPopularBinding binding;

        public MovieHolder (ItemPopularBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(MoviePopular item){
            binding.setViewModel(item);
            binding.executePendingBindings();

        }
    }
}
