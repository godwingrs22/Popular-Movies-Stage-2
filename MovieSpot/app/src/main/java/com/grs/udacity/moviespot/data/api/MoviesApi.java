package com.grs.udacity.moviespot.data.api;

import com.grs.udacity.moviespot.model.Genre;
import com.grs.udacity.moviespot.model.Movie;
import com.grs.udacity.moviespot.model.Review;
import com.grs.udacity.moviespot.model.Video;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by GodwinRoseSamuel on 23-Dec-15.
 */
public interface MoviesApi {

    @GET("/genre/movie/list") Observable<Genre.Response> genres();

    @GET("/discover/movie") Observable<Movie.Response> discoverMovies(
            @Query("sort_by") Sort sort,
            @Query("page") int page);

    @GET("/discover/movie") Observable<Movie.Response> discoverMovies(
            @Query("sort_by") Sort sort,
            @Query("page") int page,
            @Query("include_adult") boolean includeAdult);

    @GET("/movie/{id}/videos") Observable<Video.Response> videos(
            @Path("id") long movieId);

    @GET("/movie/{id}/reviews") Observable<Review.Response> reviews(
            @Path("id") long movieId,
            @Query("page") int page);

}
