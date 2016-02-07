package com.grs.udacity.moviespot.data.provider;

import android.app.Application;
import android.content.ContentResolver;

import com.squareup.sqlbrite.BriteContentResolver;
import com.squareup.sqlbrite.SqlBrite;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import timber.log.Timber;
/**
 * Created by GodwinRoseSamuel on 17-Jan-16.
 */

@Module(
        injects = {
                MoviesProvider.class
        },
        complete = false,
        library = true
)
public final class ProviderModule {

    @Provides
    @Singleton
    SqlBrite provideSqlBrite() {
        return SqlBrite.create(message -> Timber.tag("Database").v(message));
    }

    @Provides
    @Singleton ContentResolver provideContentResolver(Application application) {
        return application.getContentResolver();
    }

    @Provides
    @Singleton
    BriteContentResolver provideBrideContentResolver(SqlBrite sqlBrite, ContentResolver contentResolver) {
        return sqlBrite.wrapContentProvider(contentResolver);
    }

}
