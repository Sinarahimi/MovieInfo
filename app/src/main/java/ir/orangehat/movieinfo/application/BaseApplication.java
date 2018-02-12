package ir.orangehat.movieinfo.application;

import android.app.Application;

import ir.orangehat.movieinfo.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * BaseApplication
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Dosis_Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
