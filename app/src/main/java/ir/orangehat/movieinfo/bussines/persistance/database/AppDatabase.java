package ir.orangehat.movieinfo.bussines.persistance.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import ir.orangehat.movieinfo.bussines.model.Movie;
import ir.orangehat.movieinfo.bussines.persistance.database.dao.MovieDao;

/**
 * AppDatabase
 */

@Database(entities = Movie.class, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract MovieDao getMovieList();
}
