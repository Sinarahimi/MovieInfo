package ir.orangehat.movieinfo.bussines.persistance.database.dao;

import android.arch.persistence.room.Insert;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * BaseDao
 */

public interface BaseDao<T> {

    @Insert(onConflict = REPLACE)
    void insert(T t);
}
