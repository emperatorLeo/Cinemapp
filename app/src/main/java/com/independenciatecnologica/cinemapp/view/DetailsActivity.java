package com.independenciatecnologica.cinemapp.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.independenciatecnologica.cinemapp.R;
import com.independenciatecnologica.cinemapp.databinding.ActivityDetailsBinding;
import com.independenciatecnologica.cinemapp.model.MovieDetails;
import com.independenciatecnologica.cinemapp.viewModel.DetailsViewModel;

public class DetailsActivity extends AppCompatActivity {
 private DetailsViewModel viewModel;
 private  ActivityDetailsBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int id = getIntent().getIntExtra("id",0);
        String table = getIntent().getStringExtra("table");
        binding = DataBindingUtil.setContentView(this,R.layout.activity_details);
        viewModel = ViewModelProviders.of(this).get(DetailsViewModel.class);
        binding.setViewModel(viewModel);
        selectTable(table,id);

    }

    private void selectTable(String table,int id){

        switch (table){
            case "topRated":
            viewModel.getTopRatedDetails(id).observe(this, new Observer<MovieDetails>() {
                @Override
                public void onChanged(@Nullable MovieDetails movieDetails) {
                    if(movieDetails!=null) {
                        Log.d("DetailsActivit", "is empty:" + movieDetails.getOverview());
                        binding.setModel(movieDetails);
                    }
                }
            });
            break;
            case "popular":
                viewModel.getPopularDetails(id).observe(this, new Observer<MovieDetails>() {
                    @Override
                    public void onChanged(@Nullable MovieDetails movieDetails) {
                        if(movieDetails!=null) {
                            Log.d("DetailsActivit", "is empty:" + movieDetails.getOverview());
                            binding.setModel(movieDetails);
                        }
                    }
                });
                break;
            case "upcoming":
                viewModel.getUpcomingDetails(id).observe(this, new Observer<MovieDetails>() {
                    @Override
                    public void onChanged(@Nullable MovieDetails movieDetails) {
                        if(movieDetails!=null) {
                            Log.d("DetailsActivit", "is empty:" + movieDetails.getOverview());
                            binding.setModel(movieDetails);
                        }
                    }
                });
                break;

        }
    }
}
