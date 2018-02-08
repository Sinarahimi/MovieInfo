package ir.orangehat.movieinfo.application.ui.home;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.yarolegovich.discretescrollview.DiscreteScrollView;

import java.util.Arrays;

import ir.orangehat.movieinfo.R;

public class HomeActivity extends AppCompatActivity {

    private DiscreteScrollView discreteScrollView;
    private HomeAdapter homeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        discreteScrollView = findViewById(R.id.discreteScrollView);
        discreteScrollView.setOffscreenItems(7);

        HomeViewModel homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);

        homeViewModel.getMovies().observe(HomeActivity.this, movieArrayList -> {
            String str = null;
            if (movieArrayList != null) {
                str = Arrays.toString(movieArrayList.toArray());
            }
            Log.e("movies", str);
        });
    }
}
