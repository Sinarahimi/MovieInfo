package ir.orangehat.movieinfo.bussines.persistance.database;

import android.content.Context;

/**
 * Base databaseHelper
 */

public class BaseDatabaseHelper {

    AppDatabase appDatabase;

    BaseDatabaseHelper(Context context) {
        appDatabase = AppDatabase.getInstance(context);
    }
}
