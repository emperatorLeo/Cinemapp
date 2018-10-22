package com.independenciatecnologica.cinemapp.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.independenciatecnologica.cinemapp.db.Repository;
import com.independenciatecnologica.cinemapp.model.MoviePopular;

import java.util.List;

public class MoviesPopularViewModel extends AndroidViewModel {
    private Repository repository;
    private MutableLiveData<Integer> loading;

    public MoviesPopularViewModel(Application app){
        super(app);
        repository = new Repository(app);
    }

    public void callPopular(){
        repository.callPopularFromApi();
    }

    public MutableLiveData<Integer>getLoading(){
        if(loading==null){
            loading = new MutableLiveData<>();
            loading.setValue(0);
        }
        return loading;
    }
    

    public LiveData<List<MoviePopular>> getPopularList(){
       return repository.getPopularList();
    }


}
