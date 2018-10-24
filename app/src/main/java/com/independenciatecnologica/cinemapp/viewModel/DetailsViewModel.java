package com.independenciatecnologica.cinemapp.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.independenciatecnologica.cinemapp.db.Repository;
import com.independenciatecnologica.cinemapp.model.MovieDetails;

public class DetailsViewModel extends AndroidViewModel {
    private MutableLiveData<Integer> loader;
    private LiveData<MovieDetails> details;
    private Repository repository;
    private MutableLiveData<String> title = new MutableLiveData<>(),overview = new MutableLiveData<>(),budget=new MutableLiveData<>();

    public DetailsViewModel(Application app){
        super(app);
        repository = new Repository(app);

    }

    public MutableLiveData<Integer> getLoader() {

        if(loader==null){
            loader = new MutableLiveData<>();
            loader.setValue(0);
            }
        return loader;
    }

    public MutableLiveData<String> getTitle() {
        return title;
    }

    public void setTitle(MutableLiveData<String> title) {
        this.title = title;
    }

    public MutableLiveData<String> getOverview() {
        return overview;
    }

    public void setOverview(MutableLiveData<String> overview) {
        this.overview = overview;
    }

    public MutableLiveData<String> getBudget() {
        return budget;
    }

    public void setBudget(MutableLiveData<String> budget) {
        this.budget = budget;
    }

    public LiveData<MovieDetails> getTopRatedDetails(int id){
            this.details = repository.getTopRatedDetails(id);
            if(loader == null) {
                loader = new MutableLiveData<>();

                loader.setValue(8);
            }
            loader.setValue(8);
            return details;
    }
    public LiveData<MovieDetails> getPopularDetails(int id){
        this.details = repository.getPopularDetails(id);
        if(loader == null) {
            loader = new MutableLiveData<>();

            loader.setValue(8);
        }
        loader.setValue(8);
        return details;
    }
    public LiveData<MovieDetails> getUpcomingDetails(int id){
        this.details = repository.getUpComingsDetails(id);
        if(loader == null) {
            loader = new MutableLiveData<>();

            loader.setValue(8);
        }
        loader.setValue(8);
        return details;
    }








}
