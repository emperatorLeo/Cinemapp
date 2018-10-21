package com.independenciatecnologica.cinemapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultCallPopular {
    @SerializedName("results")
    private List<MoviePopular> movies;

    public List<MoviePopular> getMovies() {
        return movies;
    }

    public void setMovies(List<MoviePopular> movies) {
        this.movies = movies;
    }
}
