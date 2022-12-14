package com.example.movies.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResponse {

    @SerializedName("docs")
    private List<Movie> movies;

    public MovieResponse(List<Movie> movies) {
        movies = movies;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    @Override
    public String toString() {
        return "MovieResponse{" +
                "movies=" + movies +
                '}';
    }
}
