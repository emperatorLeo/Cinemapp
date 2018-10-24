package com.independenciatecnologica.cinemapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import com.independenciatecnologica.cinemapp.R;
import com.independenciatecnologica.cinemapp.databinding.ItemTopRatedBinding;
import com.independenciatecnologica.cinemapp.handlers.TopRatedClickListener;
import com.independenciatecnologica.cinemapp.model.MovieTopRated;
import com.independenciatecnologica.cinemapp.view.DetailsActivity;
import com.independenciatecnologica.cinemapp.view.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class TopRatedAdapter  extends RecyclerView.Adapter<TopRatedAdapter.MovieHolder> implements TopRatedClickListener {
    private List<MovieTopRated> listItem = new ArrayList<>();
    private LayoutInflater inflater ;
    private Context context;

    public TopRatedAdapter(Context context){
       inflater = LayoutInflater.from(context);
       this.context = context;
    }

    public void setInfo(List<MovieTopRated> list){
        this.listItem.addAll(list);
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       // LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        ItemTopRatedBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.item_top_rated,viewGroup,false);
        return new MovieHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder movieHolder, int i) {
            MovieTopRated model = listItem.get(i);
            movieHolder.bind(model);
            movieHolder.binding.setListener(this);
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    @Override
    public void detailsTopRated(MovieTopRated item) {
        Intent intent = new Intent(context,DetailsActivity.class);
        intent.putExtra("table","topRated");
        intent.putExtra("id",item.getId());
        context.startActivity(intent);

       // Toast.makeText(context,"item id: "+item.getId(),Toast.LENGTH_LONG).show();
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
