package com.grs.udacity.moviespot.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.grs.udacity.moviespot.MovieSpotApplication;
import com.grs.udacity.moviespot.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Created by GodwinRoseSamuel on 26-Jan-16.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Nullable @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @CallSuper
    @Override protected void onDestroy() {
        super.onDestroy();
        MovieSpotApplication.get(this).getRefWatcher().watch(this);
    }

    @CallSuper
    @Override public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
        setupToolbar();
    }

    @Nullable
    public final Toolbar getToolbar() {
        return mToolbar;
    }

    private void setupToolbar() {
        if (mToolbar == null) {
            Timber.w("Didn't find a toolbar");
            return;
        }

        ViewCompat.setElevation(mToolbar, getResources().getDimension(R.dimen.toolbar_elevation));
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar == null) return;
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setHomeButtonEnabled(false);
    }
}
