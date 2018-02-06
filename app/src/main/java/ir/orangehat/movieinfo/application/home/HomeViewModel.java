package ir.orangehat.movieinfo.application.home;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.annotation.NonNull;

import java.util.List;

import ir.orangehat.movieinfo.bussines.model.Movie;
import ir.orangehat.movieinfo.bussines.repository.MovieRepository;

/**
 * HomeViewModel
 */

class HomeViewModel extends AndroidViewModel {

    private MovieRepository movieRepository;

    HomeViewModel(@NonNull Application application, Context context) {
        super(application);
        movieRepository = new MovieRepository(context);
    }

    LiveData<List<Movie>> getMovies() {
        return movieRepository.getMovies();
    }

    static class Factory implements ViewModelProvider.Factory {
        private final Context context;
        private final Application application;

        public Factory(Application application, Context context) {
            this.application = application;
            this.context = context;
        }

        @SuppressWarnings("unchecked")
        @Override
        public HomeViewModel create(Class modelClass) {
            return new HomeViewModel(application, context);
        }
    }
}
