package com.independenciatecnologica.cinemapp.model;

import android.databinding.BindingAdapter;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import static com.independenciatecnologica.cinemapp.utils.Constants.TAG;
import static com.independenciatecnologica.cinemapp.utils.Constants.imageDetailBaseUrl;
import static com.independenciatecnologica.cinemapp.utils.Constants.imageItemBaseUrl;

public class MovieDetails {
    @SerializedName("name")
    private String name;
    @SerializedName("budget")
    private int budget;
    @SerializedName("genres")
    private List<Genres> genresList;
    @SerializedName("original_language")
    private String lenguage;
    @SerializedName("overview")
    private String overview;
    @SerializedName("poster_path")
    private String posterPath;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public List<Genres> getGenresList() {
        return genresList;
    }

    public void setGenresList(List<Genres> genresList) {
        this.genresList = genresList;
    }

    public String getLenguage() {
        return lenguage;
    }

    public void setLenguage(String lenguage) {
        this.lenguage = lenguage;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }
    @BindingAdapter({"posterPath"})
    public static void loadImage(ImageView view, String image ){
        Log.d(TAG,"on movies Model: "+imageDetailBaseUrl+image);
        Glide.with(view.getContext())
                .load(imageItemBaseUrl+image)
                .into(view);
    }
}
