package com.example.movies.ui.FavouriteActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.movies.R;
import com.example.movies.domain.Movie;
import com.example.movies.ui.DetailActivity.MovieDetailActivity;
import com.example.movies.ui.Main.adapter.MovieItemDiffCallback;
import com.example.movies.ui.Main.adapter.MoviesAdapter;

import java.util.List;

public class FavouriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);

        FavouriteViewModel favouriteViewModel = new ViewModelProvider(this).get(
                FavouriteViewModel.class
        );

        RecyclerView recyclerViewFavourite = findViewById(R.id.recyclerViewMoviesFav);
        MoviesAdapter moviesAdapter = new MoviesAdapter(new MovieItemDiffCallback());
        recyclerViewFavourite.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerViewFavourite.setAdapter(moviesAdapter);
        moviesAdapter.setOnClickListener(new MoviesAdapter.OnClickListener() {
            @Override
            public void onClick(Movie movie) {
                Intent intent = MovieDetailActivity.newIntent(
                        FavouriteActivity.this,
                        movie
                );
                startActivity(intent);
            }
        });

        favouriteViewModel.getMovie().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                moviesAdapter.submitList(movies);
            }
        });
    }

    public static Intent newIntent(Context context){
         return new Intent(context, FavouriteActivity.class);
    }

}