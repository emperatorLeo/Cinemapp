package com.independenciatecnologica.cinemapp.db;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.independenciatecnologica.cinemapp.model.MoviePopular;
import com.independenciatecnologica.cinemapp.model.MovieTopRated;
import com.independenciatecnologica.cinemapp.model.MovieUpComing;

import java.util.List;

public class Repository {

    private MovieDao dao ;
    private LiveData<List<MovieTopRated>> topRatedList;
    private LiveData<List<MovieUpComing>> upComingList;
    private LiveData<List<MoviePopular>> popularList;

    public Repository(Application application){
        MovieDataBase db = MovieDataBase.getDatabase(application);
        dao = db.movieDao();
        topRatedList = dao.getTopRated();
        upComingList = dao.getUpcoming();
        popularList = dao.getPopular();
    }

    public LiveData<List<MovieTopRated>>getTopRatedList(){
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

    public void inserPopular(List<MoviePopular> lista){
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

    public void inserUpComing(List<MovieUpComing> lista){
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



}
