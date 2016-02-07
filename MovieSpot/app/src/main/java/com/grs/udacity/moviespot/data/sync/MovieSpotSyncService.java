package com.grs.udacity.moviespot.data.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import timber.log.Timber;
/**
 * Created by GodwinRoseSamuel on 26-Jan-16.
 */
public class MovieSpotSyncService extends Service {
    private static final Object sSyncAdapterLock = new Object();
    private static MovieSpotSyncAdapter sMovieSpotSyncAdapter = null;

    @Override
    public void onCreate() {
        Timber.d("onCreate");
        synchronized (sSyncAdapterLock) {
            if (sMovieSpotSyncAdapter == null) {
                sMovieSpotSyncAdapter = new MovieSpotSyncAdapter(getApplicationContext(), true);
            }
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return sMovieSpotSyncAdapter.getSyncAdapterBinder();
    }
}