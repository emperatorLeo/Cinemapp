package com.independenciatecnologica.cinemapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultCallUpComing {

    @SerializedName("results")
    private List<MovieUpComing> movies;

    public List<MovieUpComing> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieUpComing> movies) {
        this.movies = movies;
    }
}
