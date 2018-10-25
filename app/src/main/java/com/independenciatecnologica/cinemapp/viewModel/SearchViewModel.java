package com.independenciatecnologica.cinemapp.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.widget.SearchView;

import com.independenciatecnologica.cinemapp.db.Repository;
import com.independenciatecnologica.cinemapp.model.MoviePopular;

import java.util.List;

public class SearchViewModel extends AndroidViewModel {
    private Repository repository;
    public SearchViewModel(Application app){
        super(app);
        repository = new Repository(app);
    }

    public void setSearch(String query){
        repository.callSearch(query);
    }

    public LiveData<List<MoviePopular>> getSearch(){
       return repository.getSearchList();
    }


}
