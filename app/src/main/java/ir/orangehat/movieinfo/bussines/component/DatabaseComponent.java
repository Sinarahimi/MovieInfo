package ir.orangehat.movieinfo.bussines.component;

import javax.inject.Singleton;

import dagger.Component;
import ir.orangehat.movieinfo.bussines.module.ContextModule;
import ir.orangehat.movieinfo.bussines.persistance.database.BaseDatabaseHelper;

@Singleton
@Component(modules = ContextModule.class)
public interface DatabaseComponent {

    BaseDatabaseHelper provideDataBaseHelper();
}
