package com.independenciatecnologica.cinemapp.model;

import com.google.gson.annotations.SerializedName;

public class Series {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("first_air_date")
    private String firstDate;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("vote_count")
    private String voteCount;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(String firstDate) {
        this.firstDate = firstDate;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(String voteCount) {
        this.voteCount = voteCount;
    }

}
