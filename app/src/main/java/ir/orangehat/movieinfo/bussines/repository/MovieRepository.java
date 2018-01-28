package ir.orangehat.movieinfo.bussines.repository;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import ir.orangehat.movieinfo.bussines.model.Movie;
import ir.orangehat.movieinfo.bussines.networking.api.MovieApi;
import ir.orangehat.movieinfo.bussines.persistance.database.MovieDatabaseHelper;
import ir.orangehat.movieinfo.bussines.persistance.database.dao.MovieDao;

/**
 * MovieRepository
 */

public class MovieRepository extends BaseRepository {

    private LifecycleOwner lifecycleOwner;
    private MovieApi movieApi;
    private MovieDatabaseHelper movieDatabaseHelper;

    public MovieRepository(LifecycleOwner lifecycleOwner, Context context) {
        this.lifecycleOwner = lifecycleOwner;
        movieApi = getRetrofitHelper().getService(MovieApi.class);
        movieDatabaseHelper = new MovieDatabaseHelper(context);
    }

    public LiveData<List<Movie>> getMovies() {
        LiveData<List<Movie>> moviesLiveData = movieApi.getMovieList();
        moviesLiveData.observe(lifecycleOwner, new Observer<List<Movie>>() {
            @Override
            public void onChanged(@Nullable List<Movie> movieArrayList) {
                movieDatabaseHelper.Save(movieArrayList);
            }
        });

        return movieDatabaseHelper.getAll();
    }
}
