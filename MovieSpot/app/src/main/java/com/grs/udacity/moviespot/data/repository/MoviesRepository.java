package com.grs.udacity.moviespot.data.repository;

import com.grs.udacity.moviespot.data.api.Sort;
import com.grs.udacity.moviespot.model.Movie;
import com.grs.udacity.moviespot.model.Review;
import com.grs.udacity.moviespot.model.Video;

import java.util.List;
import java.util.Set;

import rx.Observable;

/**
 * Created by GodwinRoseSamuel on 20-Jan-16.
 */
public interface MoviesRepository {

    Observable<List<Movie>> discoverMovies(Sort sort, int page);

    Observable<List<Movie>> savedMovies();

    Observable<Set<Long>> savedMovieIds();

    void saveMovie(Movie movie);

    void deleteMovie(Movie movie);

    Observable<List<Video>> videos(long movieId);

    Observable<List<Review>> reviews(long movieId);

}
