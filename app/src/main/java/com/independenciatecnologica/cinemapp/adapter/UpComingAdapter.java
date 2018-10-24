package com.independenciatecnologica.cinemapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.independenciatecnologica.cinemapp.R;
import com.independenciatecnologica.cinemapp.databinding.ItemUpcomingBinding;
import com.independenciatecnologica.cinemapp.handlers.Upcoming;
import com.independenciatecnologica.cinemapp.model.MovieUpComing;
import com.independenciatecnologica.cinemapp.view.DetailsActivity;


import java.util.ArrayList;
import java.util.List;

public class UpComingAdapter extends RecyclerView.Adapter<UpComingAdapter.MovieHolder> implements Upcoming {

    private List<MovieUpComing> listItem = new ArrayList<>();
    private LayoutInflater inflater;
    private Context context;

    public UpComingAdapter(Context context){
        this.context = context;
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
        movieHolder.binding.setListener(this);
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    @Override
    public void detailsUpcoming(MovieUpComing item) {
        Intent intent = new Intent(context,DetailsActivity.class);
        intent.putExtra("table","upcoming");
        intent.putExtra("id",item.getId());
        context.startActivity(intent);
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

