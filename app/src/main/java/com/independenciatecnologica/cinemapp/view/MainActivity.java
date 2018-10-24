package com.independenciatecnologica.cinemapp.view;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.MenuItem;

import com.independenciatecnologica.cinemapp.R;

import com.independenciatecnologica.cinemapp.databinding.ActivityMainBinding;
import com.independenciatecnologica.cinemapp.viewModel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {
    private String TAG = "LeoDev";
    private FragmentManager manager;
    private FragmentTransaction transaction;
    public SearchView searchView;
    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

           initBinding();

    }

    private void initBinding(){
        getSupportActionBar().hide();
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        binding.setLifecycleOwner(this);
        binding.setViewModel(viewModel);
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.bigContainer,new ContainerMovieFragment());
        transaction.addToBackStack(null);
        transaction.commit();

        /** in case when I want use bottomNavigation*/

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

    }
}



