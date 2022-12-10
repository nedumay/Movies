package com.example.movies.ui.FavouriteActivity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.movies.data.MovieDao;
import com.example.movies.data.MovieDataBase;
import com.example.movies.domain.Movie;

import java.util.List;

public class FavouriteViewModel extends AndroidViewModel {

    private final MovieDao movieDao;

    public FavouriteViewModel(@NonNull Application application) {
        super(application);
        movieDao = MovieDataBase.getInstance(application).movieDao();
    }

    public LiveData<List<Movie>> getMovie(){
        return movieDao.getAllFavouriteMovies();
    }
}
