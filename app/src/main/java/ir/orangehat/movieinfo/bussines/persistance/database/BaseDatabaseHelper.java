package ir.orangehat.movieinfo.bussines.persistance.database;

import android.arch.lifecycle.LiveData;

import java.util.ArrayList;

import ir.orangehat.movieinfo.bussines.model.Movie;

/**
 * BaseDatabaseHelper
 */

abstract class BaseDatabaseHelper<T> {

    abstract LiveData<ArrayList<Movie>> getAll();

    abstract void Save(T t);
}
