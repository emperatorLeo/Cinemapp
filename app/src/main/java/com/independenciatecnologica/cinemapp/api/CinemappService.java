package com.independenciatecnologica.cinemapp.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CinemappService {

    public static CinemappClient builder(){
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        CinemappClient client = retrofit.create(CinemappClient.class);
        return client;

    }



}
