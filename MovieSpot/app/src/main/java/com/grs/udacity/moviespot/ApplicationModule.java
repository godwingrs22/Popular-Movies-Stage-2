package com.grs.udacity.moviespot;

import android.app.Application;

import com.grs.udacity.moviespot.data.DataModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by GodwinRoseSamuel on 14-Jan-16.
 */
@Module(
        includes = DataModule.class,
        injects = {
                MovieSpotApplication.class
        },
        library = true
)
public final class ApplicationModule {
    private final MovieSpotApplication application;

    public ApplicationModule(MovieSpotApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return application;
    }

}

