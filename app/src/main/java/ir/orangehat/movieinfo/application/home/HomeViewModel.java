package ir.orangehat.movieinfo.application.home;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.support.annotation.NonNull;

import java.util.List;

import ir.orangehat.movieinfo.bussines.model.Movie;
import ir.orangehat.movieinfo.bussines.repository.MovieRepository;

/**
 * HomeViewModel
 */

public class HomeViewModel extends AndroidViewModel {

    private MovieRepository movieRepository;

    public HomeViewModel(@NonNull Application application, Context context, LifecycleOwner lifecycleOwner) {
        super(application);
        movieRepository = new MovieRepository(lifecycleOwner, context);
    }

    LiveData<List<Movie>> getMovies() {
        return movieRepository.getMovies();
    }
}
