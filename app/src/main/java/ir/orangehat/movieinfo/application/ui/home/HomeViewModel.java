package ir.orangehat.movieinfo.application.ui.home;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import ir.orangehat.movieinfo.bussines.model.Movie;
import ir.orangehat.movieinfo.bussines.repository.MovieRepository;

/**
 * HomeViewModel
 */

class HomeViewModel extends AndroidViewModel {

    private MovieRepository movieRepository;

    HomeViewModel(@NonNull Application application) {
        super(application);
        movieRepository = new MovieRepository(application.getApplicationContext());
    }

    LiveData<List<Movie>> getMovies() {
        return movieRepository.getMovies();
    }
}
