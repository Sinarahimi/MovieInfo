package ir.orangehat.movieinfo.bussines.repository;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.util.Log;

import java.util.List;

import ir.orangehat.movieinfo.bussines.model.Movie;
import ir.orangehat.movieinfo.bussines.model.SearchResult;
import ir.orangehat.movieinfo.bussines.networking.api.MovieApi;
import ir.orangehat.movieinfo.bussines.persistance.database.MovieDatabaseHelper;
import retrofit2.Response;
import rx.Single;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * MovieRepository
 */

public class MovieRepository extends BaseRepository {

    private MovieApi movieApi;
    private MovieDatabaseHelper movieDatabaseHelper;

    public MovieRepository(Context context) {
        movieApi = getRetrofitHelper().getService(MovieApi.class);
        movieDatabaseHelper = new MovieDatabaseHelper(context);
    }

    public LiveData<List<Movie>> getMovies() {
        Single<Response<SearchResult>> resultObservable = movieApi.getMovieList();
        resultObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(searchResult -> {
            if (!searchResult.isSuccessful()) {
                Log.i("Repository", "not respond");
            } else {
                movieDatabaseHelper.save(searchResult.body().getSearch());
            }
        }, throwable -> Log.i("Repository", throwable.getMessage()));

        return movieDatabaseHelper.getAll();
    }
}
