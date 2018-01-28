package ir.orangehat.movieinfo.bussines.networking.api;

import android.arch.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

import ir.orangehat.movieinfo.bussines.model.Movie;
import retrofit2.http.GET;

/**
 * MovieApi
 */

//http://www.omdbapi.com/?s=Batman&page=1&apikey=96099fe3
//http://www.omdbapi.com/?i=tt3896198&apikey=96099fe3

public interface MovieApi {
    @GET("/?s=Batman&page=1&apikey=96099fe3")
    LiveData<List<Movie>> getMovieList();
}
