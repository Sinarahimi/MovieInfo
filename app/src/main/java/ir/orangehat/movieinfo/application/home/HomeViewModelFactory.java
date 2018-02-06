package ir.orangehat.movieinfo.application.home;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

/**
 * HomeViewModelFactory
 */

public class HomeViewModelFactory implements ViewModelProvider.Factory {

    private HomeViewModel homeViewModel;

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return null;
    }
}
