package com.grs.udacity.moviespot.data.repository;


import com.grs.udacity.moviespot.data.api.MoviesApi;
import com.grs.udacity.moviespot.data.provider.MoviesContract;
import com.grs.udacity.moviespot.model.Genre;
import com.squareup.sqlbrite.BriteContentResolver;

import java.util.Map;

import rx.Observable;
import rx.schedulers.Schedulers;
/**
 * Created by GodwinRoseSamuel on 20-Jan-16.
 */
final class GenresRepositoryImpl implements GenresRepository {

    private final MoviesApi mMoviesApi;
    private final BriteContentResolver mBriteContentResolver;

    public GenresRepositoryImpl(MoviesApi moviesApi, BriteContentResolver briteContentResolver) {
        mMoviesApi = moviesApi;
        mBriteContentResolver = briteContentResolver;
    }

    @Override
    public Observable<Map<Integer, Genre>> genres() {
        return mBriteContentResolver.createQuery(MoviesContract.Genres.CONTENT_URI, Genre.PROJECTION, null, null, null, true)
                .map(Genre.PROJECTION_MAP)
                .subscribeOn(Schedulers.io());
    }
}
