package com.grs.udacity.moviespot.data.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by GodwinRoseSamuel on 26-Jan-16.
 */
public class MovieSpotAuthenticatorService extends Service {
    // Instance field that stores the authenticator object
    private MovieSpotAuthenticator mAuthenticator;

    @Override
    public void onCreate() {
        // Create a new authenticator object
        mAuthenticator = new MovieSpotAuthenticator(this);
    }

    /*
     * When the system binds to this Service to make the RPC call
     * return the authenticator's IBinder.
     */
    @Override
    public IBinder onBind(Intent intent) {
        return mAuthenticator.getIBinder();
    }
}
