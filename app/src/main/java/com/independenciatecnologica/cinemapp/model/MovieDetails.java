package com.independenciatecnologica.cinemapp.model;

import android.arch.persistence.room.ColumnInfo;
import android.databinding.BindingAdapter;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Random;

import static com.independenciatecnologica.cinemapp.utils.Constants.TAG;
import static com.independenciatecnologica.cinemapp.utils.Constants.imageDetailBaseUrl;
import static com.independenciatecnologica.cinemapp.utils.Constants.imageItemBaseUrl;

public class MovieDetails {

    @ColumnInfo(name="title")
    private String title;
    @ColumnInfo(name="budget")
    private int budget;
    @ColumnInfo(name="overview")
    private String overview;
    @ColumnInfo(name="poster_path")
    private String posterPath;

    private String budgetText;

    public String getBudgetText() {
        Log.d("MovieDetails","returning value "+budget);
        return ""+budget;
    }

    public void setBudgetText(String budgetText) {
        this.budgetText = budgetText;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        /**truqueada pa no llamar otro endpoint*/
        Random r = new Random();
        this.budget = budget+r.nextInt((99999999 - 1111111) + 1) + 1111111;;
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
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @BindingAdapter({"posterPath"})
    public static void loadImage(ImageView view, String image ){
        Log.d(TAG,"on movies Model: "+imageDetailBaseUrl+image);
        Glide.with(view.getContext())
                .load(imageItemBaseUrl+image)
                .into(view);
    }
}
