package ir.orangehat.movieinfo.bussines.persistance.database.dao;

import android.arch.persistence.room.Insert;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * BaseDao
 */

public interface BaseDao<T> {

    @Insert(onConflict = REPLACE)
    void insert(T t);

    @Insert(onConflict = REPLACE)
    void insert(List<T> t);
}
