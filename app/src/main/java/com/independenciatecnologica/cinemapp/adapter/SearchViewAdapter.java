package com.independenciatecnologica.cinemapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.independenciatecnologica.cinemapp.R;
import com.independenciatecnologica.cinemapp.databinding.ItemPopularBinding;
import com.independenciatecnologica.cinemapp.model.MoviePopular;

import java.util.ArrayList;
import java.util.List;

public class SearchViewAdapter extends RecyclerView.Adapter<SearchViewAdapter.MovieHolder> {
    /*  implements Filterable */

    private List<MoviePopular> toCopy ;
    private List<MoviePopular> listItem ;
    private LayoutInflater inflater;
    private Context context;

    public SearchViewAdapter(Context context){
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.listItem = new ArrayList<>();
    }
    public void setInfo(List<MoviePopular> list){
        this.listItem.clear();
        this.listItem.addAll(list);
        notifyDataSetChanged();

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
/*
    @Override
    public Filter getFilter() {
        return filter;
    }

    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            Log.d("Adapter","string: "+constraint);
            List<MoviePopular> filteredList = new ArrayList<>();
            if(constraint == null || constraint.length()==0){
                filteredList.addAll(toCopy);
            }else{
                String pattern = constraint.toString().toLowerCase().trim();
                for(MoviePopular item : toCopy){
                    if(item.getTitle().toLowerCase().contains(pattern)){
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;

        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            if (listItem != null) {
                listItem.clear();
                listItem.addAll((List)results.values);
                notifyDataSetChanged();
            }
        }
    };*/
}
