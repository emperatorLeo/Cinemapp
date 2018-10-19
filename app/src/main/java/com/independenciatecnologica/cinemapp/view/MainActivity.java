package com.independenciatecnologica.cinemapp.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.independenciatecnologica.cinemapp.R;
import com.independenciatecnologica.cinemapp.api.CinemappClient;
import com.independenciatecnologica.cinemapp.api.CinemappService;
import com.independenciatecnologica.cinemapp.databinding.ActivityMainBinding;
import com.independenciatecnologica.cinemapp.model.ResultCallMovie;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.independenciatecnologica.cinemapp.utils.Constants.apiKey;
public class MainActivity extends AppCompatActivity {
private String TAG = "LeoDev";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
           initBinding();
           Calls();
        }

    private void initBinding(){
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setLifecycleOwner(this);
    }

    private void Calls(){
        CinemappClient client = CinemappService.builder();
        Call<ResultCallMovie> call = client.moviesTopRated(apiKey);
        call.enqueue(new Callback<ResultCallMovie>() {
            @Override
            public void onResponse(Call<ResultCallMovie> call, Response<ResultCallMovie> response) {
                Log.d(TAG,"call: "+call.request().toString());
                Log.d(TAG,"Title: "+response.body().getMovies().get(0).getTitle());
                Log.d(TAG,"size: "+response.body().getMovies().size());
            }

            @Override
            public void onFailure(Call<ResultCallMovie> call, Throwable t) {
                Log.e(TAG,"error: "+t.getMessage());
            }
        });
    }

}
