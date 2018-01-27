package ir.orangehat.movieinfo.bussines.repository;

import ir.orangehat.movieinfo.bussines.networking.RetrofitHelper;

/**
 * BaseRepository
 */

public class BaseRepository {

    private RetrofitHelper retrofitHelper;

    public BaseRepository(){
        this.retrofitHelper = new RetrofitHelper();
    }

    public RetrofitHelper getRetrofitHelper(){
        return retrofitHelper;
    }
}
