package com.example.movies.data;

import com.example.movies.domain.MovieResponse;
import com.example.movies.domain.ReviewResponse;
import com.example.movies.domain.Videos;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("movie?token=1XVZKX1-PX64MG2-K778G8J-KSBCHBF&field=rating.kp&search=4-10&sortField=votes.kp&sortType=-1")
    Single<MovieResponse> loadMovies(@Query("page") int page);

    @GET("movie?token=1XVZKX1-PX64MG2-K778G8J-KSBCHBF&field=id")
    Single<Videos> loadTrailers(@Query("search") int id);

    @GET("review?token=1XVZKX1-PX64MG2-K778G8J-KSBCHBF&field=movieId")
    Single<ReviewResponse> loadReviews(@Query("search")int id);

}
