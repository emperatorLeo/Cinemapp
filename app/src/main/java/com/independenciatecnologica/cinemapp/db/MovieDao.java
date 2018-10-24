package com.independenciatecnologica.cinemapp.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.RoomWarnings;

import com.independenciatecnologica.cinemapp.model.MovieDetails;
import com.independenciatecnologica.cinemapp.model.MoviePopular;
import com.independenciatecnologica.cinemapp.model.MovieTopRated;
import com.independenciatecnologica.cinemapp.model.MovieUpComing;

import java.util.List;

@Dao
public interface MovieDao {

    @Insert
    void insertListPopular(List<MoviePopular> listWord);
/**/
    @Insert
    void insertListTopRated(List<MovieTopRated> listWord);

    @Insert
    void insertListUpcoming(List<MovieUpComing> listWord);

    @Query("DELETE FROM table_top_rated")
    void deleteTopRated();
    /**/
    @Query("DELETE FROM table_popular")
    void deletePopular();

    @Query("DELETE FROM table_upcoming")
    void deleteUpComing();

    @Query("SELECT * from table_popular")
    LiveData<List<MoviePopular>> getPopular();

    @Query("SELECT * from table_top_rated")
    LiveData<List<MovieTopRated>> getTopRated();
    /**/
    @Query("SELECT * from table_upcoming")
    LiveData<List<MovieUpComing>> getUpcoming();

    @Query("Select * from table_top_rated WHERE id =:id")
    LiveData<MovieDetails> getTopRatedDetails(int id);
/**/
    @Query("Select * from table_popular WHERE id =:id")
    LiveData<MovieDetails> getPopularDetails(int id);

    @Query("Select * from table_upcoming WHERE id =:id")
    LiveData<MovieDetails> getUpcomingDetails(int id);



}
