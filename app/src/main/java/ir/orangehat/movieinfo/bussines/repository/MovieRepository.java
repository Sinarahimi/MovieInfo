package ir.orangehat.movieinfo.bussines.repository;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.util.Log;

import java.util.List;

import ir.orangehat.movieinfo.bussines.model.Movie;
import ir.orangehat.movieinfo.bussines.model.SearchResult;
import ir.orangehat.movieinfo.bussines.networking.api.MovieApi;
import ir.orangehat.movieinfo.bussines.persistance.database.MovieDatabaseHelper;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
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
        Observable<SearchResult> resultObservable = movieApi.getMovieList();
        resultObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<SearchResult>() {
            @Override
            public void call(SearchResult searchResult) {
                if (!searchResult.isResponse()) {
                    Log.i("Repository", "not respond");
                } else {
                    movieDatabaseHelper.save(searchResult.getSearch());
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Log.i("Repository", throwable.getMessage());
            }
        });

        return movieDatabaseHelper.getAll();
    }
}
