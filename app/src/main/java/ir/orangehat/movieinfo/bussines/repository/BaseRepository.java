package ir.orangehat.movieinfo.bussines.repository;

import ir.orangehat.movieinfo.bussines.networking.RetrofitHelper;

/**
 * BaseRepository
 */

class BaseRepository {

    RetrofitHelper getRetrofitHelper() {
        return new RetrofitHelper();
    }
}
