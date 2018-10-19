package com.independenciatecnologica.cinemapp.api;

import com.independenciatecnologica.cinemapp.model.MovieDetails;
import com.independenciatecnologica.cinemapp.model.ResultCallMovie;
import com.independenciatecnologica.cinemapp.model.ResultCallSeries;
import com.independenciatecnologica.cinemapp.model.SeriesDetails;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CinemappClient {

   @GET("/3/movie/top_rated")
   Call<ResultCallMovie> moviesTopRated(@Query("api_key")String apiKey);

   @GET("/3/movie/popular")
   Call<ResultCallMovie> moviesPopular(@Query("api_key")String apiKey);

   @GET("/3/movie/upcoming")
   Call<ResultCallMovie> moviesUpComing(@Query("api_key")String apiKey);

   @GET("/3/movie/{movie_id}")
   Call<MovieDetails> moviesDetails(@Path("movie_id")String id);

   @GET("/3/tv/latest")
   Call<ResultCallSeries>seriesLatest(@Query("api_key")String apiKey);

   @GET("/3/tv/popular")
   Call<ResultCallSeries>seriesPopular(@Query("api_key")String apiKey);

   @GET("/3/tv/top_rated")
   Call<ResultCallSeries>seriesTopRated(@Query("api_key")String apiKey);

   @GET("/3tv/{tv_id}")
   Call<SeriesDetails> seriesDetails(@Path("tv_id")String id);




}
