package com.independenciatecnologica.cinemapp.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.independenciatecnologica.cinemapp.db.Repository;
import com.independenciatecnologica.cinemapp.model.MovieUpComing;

import java.util.List;

public class MoviesUpComingViewModel extends AndroidViewModel {
    private Repository repository;

    public MoviesUpComingViewModel(Application app){
        super(app);
     repository = new Repository(app);
    }

    public void callUpComing(){
        repository.callUpComingFromApi();
    }

    public LiveData<List<MovieUpComing>> getUpComingList(){
        return repository.getUpComingList();
    }


}
