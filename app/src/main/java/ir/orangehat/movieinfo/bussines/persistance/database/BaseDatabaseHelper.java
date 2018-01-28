package ir.orangehat.movieinfo.bussines.persistance.database;

import android.arch.lifecycle.LiveData;

import java.util.ArrayList;

/**
 * BaseDatabaseHelper
 */

abstract class BaseDatabaseHelper<T> {

    abstract LiveData<ArrayList<T>> getAll();

    abstract void Save(T t);
}
