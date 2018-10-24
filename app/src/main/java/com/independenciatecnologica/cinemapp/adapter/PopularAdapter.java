package com.independenciatecnologica.cinemapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.independenciatecnologica.cinemapp.R;
import com.independenciatecnologica.cinemapp.databinding.ItemPopularBinding;
import com.independenciatecnologica.cinemapp.databinding.ItemUpcomingBinding;
import com.independenciatecnologica.cinemapp.handlers.PopularClickListener;
import com.independenciatecnologica.cinemapp.model.MoviePopular;
import com.independenciatecnologica.cinemapp.model.MovieUpComing;
import com.independenciatecnologica.cinemapp.view.DetailsActivity;

import java.util.ArrayList;
import java.util.List;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.MovieHolder> implements PopularClickListener {

    private List<MoviePopular> listItem = new ArrayList<>();
    private LayoutInflater inflater;
    private Context context;
    public PopularAdapter(Context context){
        this.context = context;
        inflater = LayoutInflater.from(context);
    }
    public void setInfo(List<MoviePopular> list){
        this.listItem.addAll(list);
    }


    @Override
    public MovieHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        //LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        ItemPopularBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.item_popular,viewGroup,false);
        return new MovieHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder movieHolder, int i) {
        MoviePopular model = listItem.get(i);
        movieHolder.bind(model);
        movieHolder.binding.setListener(this);
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    @Override
    public void detailsPopular(MoviePopular item) {
        Intent intent = new Intent(context,DetailsActivity.class);
        intent.putExtra("table","popular");
        intent.putExtra("id",item.getId());
        context.startActivity(intent);
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
