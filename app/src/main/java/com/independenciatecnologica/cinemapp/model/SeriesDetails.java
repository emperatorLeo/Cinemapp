package com.independenciatecnologica.cinemapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SeriesDetails {

    @SerializedName("name")
    private String name;
    @SerializedName("genres")
    private List<Genres> genresList;
    @SerializedName("status")
    private String status;
    @SerializedName("number_of_episodes")
    private int episodes;
    @SerializedName("number_of_seasons")
    private int seasons;
    @SerializedName("poster_path")
    private String poster;

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Genres> getGenresList() {
        return genresList;
    }

    public void setGenresList(List<Genres> genresList) {
        this.genresList = genresList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }
}
