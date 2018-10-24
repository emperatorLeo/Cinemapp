package com.independenciatecnologica.cinemapp.db;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;
import android.os.AsyncTask;
import android.util.Log;

import com.independenciatecnologica.cinemapp.api.CinemappClient;
import com.independenciatecnologica.cinemapp.api.CinemappService;
import com.independenciatecnologica.cinemapp.model.MovieDetails;
import com.independenciatecnologica.cinemapp.model.MoviePopular;
import com.independenciatecnologica.cinemapp.model.MovieTopRated;
import com.independenciatecnologica.cinemapp.model.MovieUpComing;
import com.independenciatecnologica.cinemapp.model.ResultCallPopular;
import com.independenciatecnologica.cinemapp.model.ResultCallTopRated;
import com.independenciatecnologica.cinemapp.model.ResultCallUpComing;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.independenciatecnologica.cinemapp.utils.Constants.TAG;
import static com.independenciatecnologica.cinemapp.utils.Constants.apiKey;

public class Repository {

    private MovieDao dao ;
    private LiveData<List<MovieTopRated>> topRatedList;
    private LiveData<List<MovieUpComing>> upComingList;
    private LiveData<List<MoviePopular>> popularList;


/*
    public Repository(Application application){
        MovieDataBase db = MovieDataBase.getDatabase(application);
        dao = db.movieDao();
        topRatedList = dao.getTopRated();
        upComingList = dao.getUpcoming();
        popularList = dao.getPopular();
    }*/

    public Repository(Context context) {
        MovieDataBase db = MovieDataBase.getDatabase(context);
        dao = db.movieDao();
        topRatedList = dao.getTopRated();
        upComingList = dao.getUpcoming();
        popularList = dao.getPopular();
    }

    public LiveData<List<MovieTopRated>>getTopRatedList(){
        Log.d("repo","calling data ...");
        return topRatedList;
    }
    public LiveData<List<MovieUpComing>>getUpComingList(){
        return upComingList;
    }
    public LiveData<List<MoviePopular>>getPopularList(){
        return popularList;
    }

    public void inserTopRated(List<MovieTopRated> lista){

            new insertListTopRated(dao).execute(lista);

            }

    private static class insertListTopRated extends AsyncTask<List<MovieTopRated>,Void,Void> {
        private MovieDao mAsyncTask;

        insertListTopRated(MovieDao dao){
            mAsyncTask = dao;
        }

        @Override
        protected Void doInBackground(List<MovieTopRated>... lists) {
            mAsyncTask.insertListTopRated(lists[0]);
            return null;
        }
    }

    public void insertPopular(List<MoviePopular> lista){
        new insertListPopular(dao).execute(lista);
    }

    private static class insertListPopular extends AsyncTask<List<MoviePopular>,Void,Void>{
        private MovieDao mAsyncTask;

        insertListPopular(MovieDao dao){
            mAsyncTask = dao;
        }

        @Override
        protected Void doInBackground(List<MoviePopular>... lists) {
            mAsyncTask.insertListPopular(lists[0]);
            return null;
        }
    }

    public void insertUpComing(List<MovieUpComing> lista){
        new insertListUpComing(dao).execute(lista);
    }

    private static class insertListUpComing extends AsyncTask<List<MovieUpComing>,Void,Void>{
        private MovieDao mAsyncTask;

        insertListUpComing(MovieDao dao){
            mAsyncTask = dao;
        }

        @Override
        protected Void doInBackground(List<MovieUpComing>... lists) {
            mAsyncTask.insertListUpcoming(lists[0]);
            return null;
        }
    }

    public void deleteAll(){
        new deleteAllAsync(dao).execute();
    }

    private static class deleteAllAsync extends AsyncTask<Void,Void,Void>{
        private MovieDao mDao;

        deleteAllAsync(MovieDao dao){
            mDao = dao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            mDao.deleteUpComing();
            mDao.deleteTopRated();
            mDao.deletePopular();
            return null;
        }
    }

    public void callTopRatedFromApi(){
        CinemappClient client = CinemappService.builder();
        Call<ResultCallTopRated> call = client.moviesTopRated(apiKey);
        call.enqueue(new Callback<ResultCallTopRated>() {
            @Override
            public void onResponse(Call<ResultCallTopRated> call, Response<ResultCallTopRated> response) {
                Log.d("repoTopRated","Overview: "+response.body().getMovies().get(0).getOverview());
                inserTopRated(response.body().getMovies());

                }

            @Override
            public void onFailure(Call<ResultCallTopRated> call, Throwable t) {
                Log.e(TAG,"error: "+t.getMessage());
            }
        });
    }

    public void callPopularFromApi(){
        CinemappClient client = CinemappService.builder();
        Call<ResultCallPopular> call = client.moviesPopular(apiKey);
        call.enqueue(new Callback<ResultCallPopular>() {
            @Override
            public void onResponse(Call<ResultCallPopular> call, Response<ResultCallPopular> response) {
                Log.d(TAG,"calling from fragment : "+call.request().toString());

                insertPopular(response.body().getMovies());

            }

            @Override
            public void onFailure(Call<ResultCallPopular> call, Throwable t) {
                Log.e(TAG,"error: "+t.getMessage());
            }
        });
    }

    public void callUpComingFromApi(){
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
                    insertUpComing(response.body().getMovies());
                }
            }

            @Override
            public void onFailure(Call<ResultCallUpComing> call, Throwable t) {
                Log.e(TAG,"error: "+t.getMessage());
            }
        });
    }

    public LiveData<MovieDetails> getTopRatedDetails(int id){
        return dao.getTopRatedDetails(id);
    }
    public LiveData<MovieDetails>getPopularDetails(int id){
        return dao.getPopularDetails(id);
    }
    public LiveData<MovieDetails>getUpComingsDetails(int id){
        return dao.getUpcomingDetails(id);
    }
}
