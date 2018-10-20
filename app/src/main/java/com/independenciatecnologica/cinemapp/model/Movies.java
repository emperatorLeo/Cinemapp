package com.independenciatecnologica.cinemapp.model;

import android.databinding.BindingAdapter;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.SerializedName;
import static com.independenciatecnologica.cinemapp.utils.Constants.imageItemBaseUrl;
import static com.independenciatecnologica.cinemapp.utils.Constants.TAG;
public class Movies {

    @SerializedName("id")
    private String id;
    @SerializedName("vote_average")
    private String voteAverage;
    @SerializedName("title")
    private String title;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("release_date")
    private String releaseDate;

    public Movies(String id,String voteAverage,String title,String posterPath,String releaseDate){
        this.id = id;
        this.voteAverage = voteAverage;
        this.title = title;
        this.posterPath = posterPath;
        this.releaseDate = releaseDate;

    }

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

    public String getPosterPath() {
        return posterPath;
    }

    public void setPoster_path(String poster_path) {
        this.posterPath = poster_path;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @BindingAdapter({"posterPath"})
    public static void loadImage(ImageView view, String image ){
        Log.d(TAG,"on movies Model: "+imageItemBaseUrl+image);
        Glide.with(view.getContext())
                .load(imageItemBaseUrl+image)
                .into(view);
    }
}
