package com.independenciatecnologica.cinemapp.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.independenciatecnologica.cinemapp.R;
import com.independenciatecnologica.cinemapp.databinding.ItemPopularBinding;
import com.independenciatecnologica.cinemapp.databinding.ItemTopRatedBinding;
import com.independenciatecnologica.cinemapp.model.MoviePopular;
import com.independenciatecnologica.cinemapp.model.MovieTopRated;

import java.util.ArrayList;
import java.util.List;

public class TopRatedAdapter  extends RecyclerView.Adapter<TopRatedAdapter.MovieHolder>{
    private List<MovieTopRated> listItem = new ArrayList<>();

    public TopRatedAdapter(List<MovieTopRated> list){
        this.listItem.addAll(list);
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        ItemTopRatedBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.item_top_rated,viewGroup,false);
        return new MovieHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder movieHolder, int i) {
            MovieTopRated model = listItem.get(i);
            movieHolder.bind(model);
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public class MovieHolder extends RecyclerView.ViewHolder{
        private ItemTopRatedBinding binding;

        public MovieHolder (ItemTopRatedBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(MovieTopRated item){
            binding.setViewModel(item);
            binding.executePendingBindings();

        }
    }
}
