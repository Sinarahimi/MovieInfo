package ir.orangehat.movieinfo.bussines.persistance.database;

import android.arch.lifecycle.LiveData;

import java.util.ArrayList;

import ir.orangehat.movieinfo.bussines.model.Movie;
import ir.orangehat.movieinfo.bussines.persistance.database.dao.MovieDao;

/**
 * MovieDatabaseHelper
 */

public class MovieDatabaseHelper extends BaseDatabaseHelper<Movie> {

    private MovieDao movieDao;

    public MovieDatabaseHelper() {

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
