package com.independenciatecnologica.cinemapp.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import com.independenciatecnologica.cinemapp.model.MoviePopular;
import com.independenciatecnologica.cinemapp.model.MovieTopRated;
import com.independenciatecnologica.cinemapp.model.MovieUpComing;

@Database(entities = {MovieTopRated.class,MovieUpComing.class,MoviePopular.class},version = 1)

public abstract class MovieDataBase extends RoomDatabase {

    public abstract MovieDao movieDao();

    private static volatile MovieDataBase INSTANCE;

    static MovieDataBase getDatabase (final Context context){
        if (INSTANCE == null){
            synchronized (MovieDataBase.class){
                if(INSTANCE==null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MovieDataBase.class,"Movie_database")
                            .addCallback(sRoomCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomCallback =
            new RoomDatabase.Callback(){
                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                    new DeleteAll(INSTANCE).execute();
                }
            };
    private static class DeleteAll extends AsyncTask<Void,Void,Void> {
        private final MovieDao dao;

        DeleteAll(MovieDataBase db){
            dao = db.movieDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            Log.d("DB","deleting all");
            dao.deletePopular();
            dao.deleteTopRated();
            dao.deleteUpComing();
            return null;
        }
    }
}
