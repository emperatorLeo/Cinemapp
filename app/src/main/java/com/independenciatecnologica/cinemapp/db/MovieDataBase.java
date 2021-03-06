package com.independenciatecnologica.cinemapp.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import com.independenciatecnologica.cinemapp.model.MoviePopular;
import com.independenciatecnologica.cinemapp.model.MovieTopRated;
import com.independenciatecnologica.cinemapp.model.MovieUpComing;

@Database(entities = {MovieTopRated.class,MovieUpComing.class,MoviePopular.class},version = 2)
public abstract class MovieDataBase extends RoomDatabase {

    public abstract MovieDao movieDao();

    private static volatile MovieDataBase INSTANCE;

    private static Migration MIGRATION_1_2  = new Migration(1,2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE table_top_rated ADD COLUMN budget INTEGER NOT NULL DEFAULT 0");
            database.execSQL("ALTER TABLE table_top_rated ADD COLUMN overview TEXT");
            database.execSQL("ALTER TABLE table_upcoming ADD COLUMN budget INTEGER NOT NULL DEFAULT 0");
            database.execSQL("ALTER TABLE table_upcoming ADD COLUMN overview TEXT");
            database.execSQL("ALTER TABLE table_popular ADD COLUMN budget INTEGER NOT NULL DEFAULT 0");
            database.execSQL("ALTER TABLE table_popular ADD COLUMN overview TEXT");
            }
    };

    static MovieDataBase getDatabase (final Context context){
        if (INSTANCE == null){
            synchronized (MovieDataBase.class){
                if(INSTANCE==null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MovieDataBase.class,"Movie_database")
                            .addCallback(sRoomCallback)
                            .fallbackToDestructiveMigration()
                            .addMigrations(MIGRATION_1_2)
                            .build();
                }
            }
        }
        if(MovieDataBase.INSTANCE.mDatabase == null)Log.d("MovieDB","DataBase doesn't exist!");
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomCallback =
            new RoomDatabase.Callback(){
                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                    //new DeleteAll(INSTANCE).execute();
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
