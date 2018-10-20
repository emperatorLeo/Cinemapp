package com.independenciatecnologica.cinemapp.view;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

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
    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

           initBinding();
           Calls();
        }

    private void initBinding(){
        getSupportActionBar().hide();
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.bigContainer,new ContainerMovieFragment());
        transaction.addToBackStack(null);
        transaction.commit();

   /*
        binding.bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                transaction = manager.beginTransaction();
                switch (menuItem.getItemId()){
                    case R.id.action_movies:
                    Log.d(TAG,"Nav ItemSelected: movies");

                    transaction.replace(R.id.bigContainer,new ContainerMovieFragment());
                    transaction.addToBackStack(null);
                    transaction.commit();
                    break;

                    case R.id.action_series:

                    transaction.replace(R.id.bigContainer,new ContainerSeriesFragment());
                    transaction.addToBackStack(null);
                    transaction.commit();
                        Log.d(TAG,"Nav ItemSelected: series");
                    break;
                }
                return true;
            }
        });
        binding.bottomNavigation.setSelectedItemId(R.id.action_movies);*/
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
