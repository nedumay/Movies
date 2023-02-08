package com.example.movies.data;

import com.example.movies.domain.MovieResponse;
import com.example.movies.domain.ReviewResponse;
import com.example.movies.domain.Videos;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("movie?token=35WEVJ0-8CFMKB4-K55PSNA-4N4V4J0&field=rating.kp&search=4-10&sortField=votes.kp&sortType=-1&limit=40")
    Single<MovieResponse> loadMovies(@Query("page") int page);

    @GET("movie?token=35WEVJ0-8CFMKB4-K55PSNA-4N4V4J0&field=id")
    Single<Videos> loadTrailers(@Query("search") int id);

    @GET("review?token=35WEVJ0-8CFMKB4-K55PSNA-4N4V4J0&field=movieId")
    Single<ReviewResponse> loadReviews(@Query("search")int id);

}
