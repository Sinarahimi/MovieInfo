package ir.orangehat.movieinfo.bussines.persistance.database;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import java.util.ArrayList;

import ir.orangehat.movieinfo.bussines.model.Movie;
import ir.orangehat.movieinfo.bussines.persistance.database.dao.MovieDao;

/**
 * MovieDatabaseHelper
 */

public class MovieDatabaseHelper extends BaseDatabaseHelper<Movie> {

    private MovieDao movieDao;

    public MovieDatabaseHelper(Context context) {
        AppDatabase appDatabase = AppDatabase.getInstance(context);
        movieDao = appDatabase.getMovieDao();
    }

    @Override
    public LiveData<ArrayList<Movie>> getAll() {
        return movieDao.getAll();
    }

    @Override
    public void Save(Movie movie) {
        movieDao.insert(movie);
    }
}
