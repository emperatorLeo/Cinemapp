package com.independenciatecnologica.cinemapp.model;

import com.google.gson.annotations.SerializedName;

public class Movies {

    @SerializedName("id")
    private String id;
    @SerializedName("vote_average")
    private String voteAverage;
    @SerializedName("title")
    private String title;
    @SerializedName("poster_path")
    private String poster_path;
    @SerializedName("release_date")
    private String releaseDate;

    public String getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(String voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String release_date) {
        this.releaseDate = release_date;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
