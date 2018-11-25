package ir.orangehat.movieinfo.bussines.networking.api;

import ir.orangehat.movieinfo.bussines.model.SearchResult;
import retrofit2.Response;
import retrofit2.http.GET;
import rx.Single;

/**
 * MovieApi
 */

//http://www.omdbapi.com/?s=Batman&page=1&apikey=96099fe3
//http://www.omdbapi.com/?i=tt3896198&apikey=96099fe3

public interface MovieApi {
    @GET("/?s=Batman&page=1&apikey=96099fe3")
    Single<Response<SearchResult>> getMovieList();
}
