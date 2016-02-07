package com.grs.udacity.moviespot.ui.activity;

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;

import com.grs.udacity.moviespot.R;
import com.grs.udacity.moviespot.model.Movie;
import com.grs.udacity.moviespot.ui.fragment.MovieFragment;

/**
 * Created by GodwinRoseSamuel on 26-Jan-16.
 */
public final class MovieDetailsActivity extends BaseActivity {
    public static final String EXTRA_MOVIE = "com.grs.udacity.moviespot.extras.EXTRA_MOVIE";

    private static final String MOVIE_FRAGMENT_TAG = "fragment_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        if (mToolbar != null) {
            ViewCompat.setElevation(mToolbar, getResources().getDimension(R.dimen.toolbar_elevation));
            mToolbar.setNavigationOnClickListener(view -> finish());

            ActionBar ab = getSupportActionBar();
            if (ab != null) {
                ab.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);
                ab.setDisplayHomeAsUpEnabled(true);
                ab.setDisplayShowHomeEnabled(true);
            }
        }

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);

        if (savedInstanceState == null) {
            MovieFragment fragment = MovieFragment.newInstance(movie);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.movie_details_container, fragment, MOVIE_FRAGMENT_TAG)
                    .commit();
        }
    }

}