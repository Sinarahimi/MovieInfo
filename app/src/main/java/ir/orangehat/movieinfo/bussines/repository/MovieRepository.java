package ir.orangehat.movieinfo.bussines.repository;

import android.arch.lifecycle.LiveData;

import java.util.ArrayList;

import ir.orangehat.movieinfo.bussines.model.Movie;
import ir.orangehat.movieinfo.bussines.networking.api.MovieApi;
import ir.orangehat.movieinfo.bussines.persistance.database.MovieDatabaseHelper;
import ir.orangehat.movieinfo.bussines.persistance.database.dao.MovieDao;

/**
 * MovieRepository
 */

public class MovieRepository extends BaseRepository {

    private MovieApi movieApi;
    private MovieDao movieDao;

    public MovieRepository() {
        movieApi = getRetrofitHelper().getService(MovieApi.class);
    }

    public LiveData<ArrayList<Movie>> getMovies() {
        LiveData<ArrayList<Movie>> listLiveData = movieApi.getMovieList();




        return getListFromTheCache();
    }

    LiveData<ArrayList<Movie>> getListFromTheCache() {
        LiveData<ArrayList<Movie>> movies;
        MovieDatabaseHelper movieDatabaseHelper = new MovieDatabaseHelper();
        movies = movieDatabaseHelper.getAll();
        return movies;
    }
}
