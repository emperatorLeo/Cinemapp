package com.independenciatecnologica.cinemapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultCallSeries {

    @SerializedName("results")
    private List<Series>seriesList;

    public List<Series> getSeriesList() {
        return seriesList;
    }

    public void setSeriesList(List<Series> seriesList) {
        this.seriesList = seriesList;
    }
}
