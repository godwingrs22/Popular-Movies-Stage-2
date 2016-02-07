package com.grs.udacity.moviespot.data.repository;

import android.content.ContentResolver;

import com.grs.udacity.moviespot.data.api.MoviesApi;
import com.squareup.sqlbrite.BriteContentResolver;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by GodwinRoseSamuel on 20-Jan-16.
 */
@Module(complete = false, library = true)
public final class RepositoryModule {

    @Singleton
    @Provides
    public GenresRepository providesGenresRepository(MoviesApi moviesApi, BriteContentResolver contentResolver) {
        return new GenresRepositoryImpl(moviesApi, contentResolver);
    }

    @Singleton
    @Provides
    public MoviesRepository providesMoviesRepository(MoviesApi moviesApi, ContentResolver contentResolver,
                                                     BriteContentResolver briteContentResolver, GenresRepository repository) {
        return new MoviesRepositoryImpl(moviesApi, contentResolver, briteContentResolver, repository);
    }

}
