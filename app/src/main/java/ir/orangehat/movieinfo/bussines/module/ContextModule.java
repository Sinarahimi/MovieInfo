package ir.orangehat.movieinfo.bussines.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    private Context context;

    public ContextModule(Context context){
        this.context= context;
    }

    @Provides
    @Singleton
    Context provideContext(){
        return context;
    }

}
