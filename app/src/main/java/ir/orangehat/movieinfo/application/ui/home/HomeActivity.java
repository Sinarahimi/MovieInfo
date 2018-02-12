package ir.orangehat.movieinfo.application.ui.home;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.InfiniteScrollAdapter;
import com.yarolegovich.discretescrollview.transform.Pivot;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import java.util.ArrayList;

import ir.orangehat.movieinfo.R;
import ir.orangehat.movieinfo.application.BaseActivity;
import ir.orangehat.movieinfo.bussines.model.Movie;

public class HomeActivity extends BaseActivity {

    private DiscreteScrollView discreteScrollView;
    private HomeAdapter homeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        discreteScrollView = findViewById(R.id.discreteScrollView);
        discreteScrollView.setOffscreenItems(5);
        discreteScrollView.setItemTransformer(new ScaleTransformer.Builder()
                .setMaxScale(1f)
                .setMinScale(0.9f)
                .setPivotX(Pivot.X.CENTER) // CENTER is a default one
                .setPivotY(Pivot.Y.BOTTOM) // CENTER is a default one
                .build());

        HomeViewModel homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);

        homeViewModel.getMovies().observe(HomeActivity.this, movieList -> {
            if (movieList != null) {
                ArrayList<Movie> movieArrayList = new ArrayList<>(movieList);
                homeAdapter = new HomeAdapter(HomeActivity.this, movieArrayList);
                InfiniteScrollAdapter wrapper = InfiniteScrollAdapter.wrap(homeAdapter);
                discreteScrollView.setAdapter(wrapper);
            }
        });
    }
}
