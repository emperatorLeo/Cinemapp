package com.independenciatecnologica.cinemapp.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.provider.ContactsContract;
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
import com.independenciatecnologica.cinemapp.adapter.UpComingAdapter;
import com.independenciatecnologica.cinemapp.api.CinemappClient;
import com.independenciatecnologica.cinemapp.api.CinemappService;
import com.independenciatecnologica.cinemapp.databinding.FragmentMovieUpcomingBinding;
import com.independenciatecnologica.cinemapp.model.MovieUpComing;
import com.independenciatecnologica.cinemapp.model.Movies;
import com.independenciatecnologica.cinemapp.model.ResultCallMovie;
import com.independenciatecnologica.cinemapp.model.ResultCallUpComing;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.independenciatecnologica.cinemapp.utils.Constants.TAG;
import static com.independenciatecnologica.cinemapp.utils.Constants.apiKey;

public class MovieUpComingFragment extends Fragment {

    private FragmentMovieUpcomingBinding binding;
    private List<MovieUpComing> lista = new ArrayList<>();
    private UpComingAdapter adapter;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_movie_upcoming,container,false);
        binding.upComingProgresBar.setVisibility(View.VISIBLE);
        call();
        return binding.getRoot();
    }

    private void call(){
        CinemappClient client = CinemappService.builder();
        Call<ResultCallUpComing> call = client.moviesUpComing(apiKey);
        call.enqueue(new Callback<ResultCallUpComing>() {
            @Override
            public void onResponse(Call<ResultCallUpComing> call, Response<ResultCallUpComing> response) {
                Log.d(TAG,"calling from fragment : "+call.request().toString());

                if(response == null || response.body().getMovies().isEmpty()){
                    Log.d(TAG,"calling from fragment : is null");
                }else{
                    Log.d(TAG,"is feeding");
                    feed(response.body().getMovies());
                }
            }

            @Override
            public void onFailure(Call<ResultCallUpComing> call, Throwable t) {
                Log.e(TAG,"error: "+t.getMessage());
            }
        });
    }

    private List<MovieUpComing> feed(List<MovieUpComing> items){
         binding.upComingProgresBar.setVisibility(View.GONE);
        if(items!=null && !items.isEmpty()) {
            lista.addAll(items);
            adapter = new UpComingAdapter(lista);
            binding.upComingList.setAdapter(adapter);
            binding.upComingList.setLayoutManager(new LinearLayoutManager(getActivity()));
        }else{ Log.d(TAG,"list fragment is empty");}
        return lista;
    }


}
