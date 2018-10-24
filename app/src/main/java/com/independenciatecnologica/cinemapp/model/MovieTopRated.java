package com.independenciatecnologica.cinemapp.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import static com.independenciatecnologica.cinemapp.utils.Constants.TAG;
import static com.independenciatecnologica.cinemapp.utils.Constants.imageItemBaseUrl;

@Entity(tableName = "table_top_rated")
public class MovieTopRated {
    @PrimaryKey
    @NonNull
    @SerializedName("id")
    @ColumnInfo(name="id")
    private int id;
    @SerializedName("title")
    @ColumnInfo(name="title")
    private String title;
    @SerializedName("vote_average")
    @ColumnInfo(name="vote_average")
    private String voteAverage;
    @SerializedName("poster_path")
    @ColumnInfo(name="poster_path")
    private String posterPath;
    @SerializedName("release_date")
    @ColumnInfo(name="release_date")
    private String releaseDate;
    @SerializedName("budget")
    @ColumnInfo(name="budget")
    private int budget;
   /* @SerializedName("genres")
    private List<Genres>genresList;*/
    @ColumnInfo(name = "overview")
    @SerializedName("overview")
    private String overview;

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        Log.d("modelTopRated","budget: "+budget);
        this.budget = budget;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(String voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @BindingAdapter({"posterPath"})
    public static void loadImage(ImageView view, String image ){
        Log.d(TAG,"on movies Model: "+imageItemBaseUrl+image);
        Glide.with(view.getContext())
                .load(imageItemBaseUrl+image)
                .into(view);
    }
}
