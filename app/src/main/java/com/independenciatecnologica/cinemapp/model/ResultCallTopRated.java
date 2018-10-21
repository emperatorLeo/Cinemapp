package com.independenciatecnologica.cinemapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultCallTopRated {

    @SerializedName("results")
    private List<MovieTopRated> movies;

    public List<MovieTopRated> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieTopRated> movies) {
        this.movies = movies;
    }
}
