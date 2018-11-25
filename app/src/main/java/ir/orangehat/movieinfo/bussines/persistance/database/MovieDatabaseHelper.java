package ir.orangehat.movieinfo.bussines.persistance.database;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import java.util.List;

import ir.orangehat.movieinfo.bussines.model.Movie;
import ir.orangehat.movieinfo.bussines.persistance.database.dao.MovieDao;

/**
 * MovieDatabaseHelper
 */

public class MovieDatabaseHelper extends BaseDatabaseHelper {

    private MovieDao movieDao;

    public MovieDatabaseHelper(Context context) {
        super(context);
        movieDao = appDatabase.getMovieDao();
    }

    public LiveData<List<Movie>> getAll() {
        return movieDao.getAll();
    }

    public void save(List<Movie> movies) {
        movieDao.insert(movies);
    }
}
