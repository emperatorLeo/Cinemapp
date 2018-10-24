package com.independenciatecnologica.cinemapp.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.util.Log;
import android.view.View;

import com.independenciatecnologica.cinemapp.api.CinemappClient;
import com.independenciatecnologica.cinemapp.api.CinemappService;
import com.independenciatecnologica.cinemapp.db.Repository;
import com.independenciatecnologica.cinemapp.model.MovieTopRated;
import com.independenciatecnologica.cinemapp.model.ResultCallTopRated;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.independenciatecnologica.cinemapp.utils.Constants.TAG;
import static com.independenciatecnologica.cinemapp.utils.Constants.apiKey;

public class MoviesTopRatedViewModel extends AndroidViewModel {
    private Repository repository;
    public MutableLiveData<Integer>loading;

    public MoviesTopRatedViewModel(Application context){
           super(context);
           repository = new Repository(context);

       }


    public void callTopRated(){
           repository.callTopRatedFromApi();
       }

    public void delteAll(){
           repository.deleteAll();
       }

    public MutableLiveData<Integer> getLoading(){
           if(loading==null){
               loading = new MutableLiveData<>();
               loading.setValue(0);
           }
        Log.d("TopRatedVM","loading: "+loading.getValue());
        return loading;
    }

    /*
            public void setLoading(int mLoading){
               loading.setValue(mLoading);
            }*/
    public LiveData<List<MovieTopRated>> getTopRatedList(){
        return repository.getTopRatedList();
    }




}
