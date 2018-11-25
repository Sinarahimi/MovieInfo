package ir.orangehat.movieinfo.application.ui.home;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import ir.orangehat.movieinfo.R;
import ir.orangehat.movieinfo.bussines.model.Movie;

/**
 * HomeAdapter
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Movie> movies;

    public HomeAdapter(Context context, ArrayList<Movie> movies) {

        this.context = context;
        this.movies = movies;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie movie = movies.get(position);
        Picasso.with(context)
                .load(movie.getPoster())
                .placeholder(R.drawable.ic_batman)
                .error(R.drawable.ic_batman)
                .into(holder.imageViewPoster);
        holder.textViewTitle.setText(movie.getTitle());
        holder.textViewYear.setText(movie.getYear());
        holder.buttonImdb.setOnClickListener(view -> {
            String imdbUrl = "http://www.imdb.com/title/" + movie.getImdbID();
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(imdbUrl));
            context.startActivity(intent);
        });

        holder.imageViewPoster.setOnClickListener(view -> {

        });
    }

    @Override
    public int getItemCount() {
        return movies == null ? 0 : movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageViewPoster;
        private TextView textViewTitle;
        private TextView textViewYear;
        private Button buttonImdb;

        public ViewHolder(View itemView) {
            super(itemView);
            imageViewPoster = itemView.findViewById(R.id.imageViewPoster);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewYear = itemView.findViewById(R.id.textViewYear);
            buttonImdb = itemView.findViewById(R.id.buttonImdb);
        }
    }
}
