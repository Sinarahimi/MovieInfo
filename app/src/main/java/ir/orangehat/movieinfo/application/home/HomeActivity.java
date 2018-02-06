package ir.orangehat.movieinfo.application.home;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Arrays;
import java.util.List;

import ir.orangehat.movieinfo.R;
import ir.orangehat.movieinfo.bussines.model.Movie;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewModelProvider.Factory factory = new HomeViewModel.Factory(getApplication(), getApplicationContext());

        HomeViewModel homeViewModel = ViewModelProviders.of(this,factory).get(HomeViewModel.class);

        homeViewModel.getMovies().observe(HomeActivity.this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(@Nullable List<Movie> movieArrayList) {
                String str = null;
                if (movieArrayList != null) {
                    str = Arrays.toString(movieArrayList.toArray());
                }
                Log.e("movies", str);
            }
        });
    }
}
