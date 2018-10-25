package com.independenciatecnologica.cinemapp.api;

import com.independenciatecnologica.cinemapp.model.MovieDetails;
import com.independenciatecnologica.cinemapp.model.ResultCallPopular;
import com.independenciatecnologica.cinemapp.model.ResultCallSeries;
import com.independenciatecnologica.cinemapp.model.ResultCallTopRated;
import com.independenciatecnologica.cinemapp.model.ResultCallUpComing;
import com.independenciatecnologica.cinemapp.model.SeriesDetails;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CinemappClient {

   @GET("/3/movie/top_rated")
   Call<ResultCallTopRated> moviesTopRated(@Query("api_key")String apiKey);

   @GET("/3/movie/popular")
   Call<ResultCallPopular> moviesPopular(@Query("api_key")String apiKey);

   @GET("/3/movie/upcoming")
   Call<ResultCallUpComing> moviesUpComing(@Query("api_key")String apiKey);

   @GET("/3/search/movie")
   Call<ResultCallPopular> search(@Query("query")String query,
                                  @Query("api_key")String apiKey);

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
