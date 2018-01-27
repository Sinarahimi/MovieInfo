package ir.orangehat.movieinfo.bussines.persistance.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.ArrayList;

import ir.orangehat.movieinfo.bussines.model.Movie;

/**
 * MovieDao
 */

@Dao
public interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ArrayList<Movie> movieArrayList);

    @Query("select * from Movie")
    LiveData<ArrayList<Movie>> getAll();
}

