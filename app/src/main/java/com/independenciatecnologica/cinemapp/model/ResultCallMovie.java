package com.independenciatecnologica.cinemapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultCallMovie {
    @SerializedName("results")
    private List<Movies> movies;

    public List<Movies> getMovies() {
        return movies;
    }

    public void setMovies(List<Movies> movies) {
        this.movies = movies;
    }
}
