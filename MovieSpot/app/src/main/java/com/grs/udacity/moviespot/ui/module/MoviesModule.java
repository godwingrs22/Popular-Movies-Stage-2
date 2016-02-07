package com.grs.udacity.moviespot.ui.module;
import com.grs.udacity.moviespot.ApplicationModule;
import com.grs.udacity.moviespot.ui.fragment.FavoredMoviesFragment;
import com.grs.udacity.moviespot.ui.fragment.MovieFragment;
import com.grs.udacity.moviespot.ui.fragment.SortedMoviesFragment;

import dagger.Module;

/**
 * Created by GodwinRoseSamuel on 19-Jan-16.
 */
@Module(
        injects = {
                SortedMoviesFragment.class,
                FavoredMoviesFragment.class,
                MovieFragment.class
        },
        addsTo = ApplicationModule.class
)
public final class MoviesModule {}
