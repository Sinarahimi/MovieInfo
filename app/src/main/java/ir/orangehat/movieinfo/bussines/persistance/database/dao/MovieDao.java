package ir.orangehat.movieinfo.bussines.persistance.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

import ir.orangehat.movieinfo.bussines.model.Movie;

/**
 * MovieDao
 */

@Dao
public interface MovieDao extends BaseDao<Movie> {

    @Query("select * from Movie")
    LiveData<List<Movie>> getAll();
}

