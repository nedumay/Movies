package com.example.movies.data.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.movies.domain.Movie;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;

@Dao
public interface MovieDao {

    //Запрос всех фильмов
    @Query("SELECT * FROM favourite_movies")
    LiveData<List<Movie>> getAllFavouriteMovies();
    //Запрос одного фильма по id
    @Query("SELECT * FROM favourite_movies WHERE id = :movieId")
    LiveData<Movie> getFavouriteMovie(int movieId);
    //Вставка объекта в базу данных
    @Insert
    Completable insertMovie(Movie movie);
    //Удаление объекта из базы данных
    @Query("DELETE FROM favourite_movies WHERE id =:movieId")
    Completable removeMovie(int movieId);

}
