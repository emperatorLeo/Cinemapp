package com.independenciatecnologica.cinemapp.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.independenciatecnologica.cinemapp.R;
import com.independenciatecnologica.cinemapp.adapter.RecyclerMovieAdapter;
import com.independenciatecnologica.cinemapp.adapter.TopRatedAdapter;
import com.independenciatecnologica.cinemapp.api.CinemappClient;
import com.independenciatecnologica.cinemapp.api.CinemappService;
import com.independenciatecnologica.cinemapp.databinding.FragmentMovieTopRatedBinding;
import com.independenciatecnologica.cinemapp.model.MovieTopRated;
import com.independenciatecnologica.cinemapp.model.Movies;
import com.independenciatecnologica.cinemapp.model.ResultCallMovie;
import com.independenciatecnologica.cinemapp.model.ResultCallTopRated;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.independenciatecnologica.cinemapp.utils.Constants.TAG;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.independenciatecnologica.cinemapp.utils.Constants.apiKey;

public class MovieTopRatedFragment extends Fragment {
    private View view;
    private FragmentMovieTopRatedBinding binding;
    private TopRatedAdapter adapter;
    private List<MovieTopRated> lista = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_movie_top_rated,container,false);
        binding.topRatedProgresBar.setVisibility(View.VISIBLE);
        call();
        return binding.getRoot();
    }

    private void call(){
        CinemappClient client = CinemappService.builder();
        Call<ResultCallTopRated> call = client.moviesTopRated(apiKey);
        call.enqueue(new Callback<ResultCallTopRated>() {
            @Override
            public void onResponse(Call<ResultCallTopRated> call, Response<ResultCallTopRated> response) {
                Log.d("TopRated","calling from TopRated fragment : "+call.request().toString());

                    feed(response.body().getMovies());
                    Log.d("TopRated","size"+response.body().getMovies().size());


            }

            @Override
            public void onFailure(Call<ResultCallTopRated> call, Throwable t) {
                Log.e(TAG,"error: "+t.getMessage());
            }
        });
        }

     private List<MovieTopRated> feed(List<MovieTopRated> items){

         if(items!=null && !items.isEmpty()) {
            binding.topRatedProgresBar.setVisibility(View.GONE);
            lista.addAll(items);
            adapter = new TopRatedAdapter(lista);
            binding.topRatedList.setAdapter(adapter);
            binding.topRatedList.setLayoutManager(new LinearLayoutManager(getActivity()));
        }else{ Log.d(TAG,"list fragment is empty");}
        return lista;
     }
}
