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
import com.independenciatecnologica.cinemapp.adapter.PopularAdapter;
import com.independenciatecnologica.cinemapp.adapter.RecyclerMovieAdapter;
import com.independenciatecnologica.cinemapp.api.CinemappClient;
import com.independenciatecnologica.cinemapp.api.CinemappService;
import com.independenciatecnologica.cinemapp.databinding.FragmentMoviePopularBinding;
import com.independenciatecnologica.cinemapp.model.MoviePopular;
import com.independenciatecnologica.cinemapp.model.Movies;
import com.independenciatecnologica.cinemapp.model.ResultCallMovie;
import com.independenciatecnologica.cinemapp.model.ResultCallPopular;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.independenciatecnologica.cinemapp.utils.Constants.TAG;
import static com.independenciatecnologica.cinemapp.utils.Constants.apiKey;

public class MoviePopularFragment extends Fragment {
   private View view;
   private FragmentMoviePopularBinding binding ;
   private List<MoviePopular> lista = new ArrayList<>();
   private PopularAdapter adapter;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_movie_popular,container,false);
        binding.popularProgresBar.setVisibility(View.VISIBLE);
        call();
        return binding.getRoot();
    }

    private void call(){
        CinemappClient client = CinemappService.builder();
        Call<ResultCallPopular> call = client.moviesPopular(apiKey);
        call.enqueue(new Callback<ResultCallPopular>() {
            @Override
            public void onResponse(Call<ResultCallPopular> call, Response<ResultCallPopular> response) {
                Log.d(TAG,"calling from fragment : "+call.request().toString());

                    feed(response.body().getMovies());

            }

            @Override
            public void onFailure(Call<ResultCallPopular> call, Throwable t) {
                Log.e(TAG,"error: "+t.getMessage());
            }
        });
    }

    private List<MoviePopular> feed(List<MoviePopular> items){

        if(items!=null && !items.isEmpty()) {
            binding.popularProgresBar.setVisibility(View.GONE);
            lista.addAll(items);
            adapter = new PopularAdapter(lista);
            binding.popularList.setAdapter(adapter);
            binding.popularList.setLayoutManager(new LinearLayoutManager(getActivity()));
        }else{ Log.d(TAG,"list fragment is empty");}
        return lista;
    }
}
