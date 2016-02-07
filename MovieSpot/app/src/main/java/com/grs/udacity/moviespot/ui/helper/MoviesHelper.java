package com.grs.udacity.moviespot.ui.helper;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;

import com.grs.udacity.moviespot.R;
import com.grs.udacity.moviespot.data.repository.MoviesRepository;
import com.grs.udacity.moviespot.model.Movie;
import com.grs.udacity.moviespot.model.Video;
import com.grs.udacity.moviespot.utils.PrefUtils;

import rx.Observable;
import rx.subjects.PublishSubject;
import timber.log.Timber;

/**
 * Created by GodwinRoseSamuel on 23-Dec-15.
 */
public class MoviesHelper {

    private static final PublishSubject<FavoredEvent> FAVORED_SUBJECT = PublishSubject.create();

    private final Activity mActivity;
    private final MoviesRepository mRepository;

    public MoviesHelper(Activity activity, MoviesRepository moviesRepository) {
        mActivity = activity;
        mRepository = moviesRepository;
    }

    public Observable<FavoredEvent> getFavoredObservable() {
        return FAVORED_SUBJECT.asObservable();
    }

    public void setMovieFavored(Movie movie, boolean favored) {
        movie.setFavored(favored);
        if (favored) {
            mRepository.saveMovie(movie);
            PrefUtils.addToFavorites(mActivity, movie.getId());
        } else {
            mRepository.deleteMovie(movie);
            PrefUtils.removeFromFavorites(mActivity, movie.getId());
        }
        FAVORED_SUBJECT.onNext(new FavoredEvent(movie.getId(), favored));
    }

    public void playVideo(Video video) {
        if (video.getSite().equals(Video.SITE_YOUTUBE))
            mActivity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + video.getKey())));
        else
            Timber.w("Unsupported video format");
    }

    public void shareTrailer(int messageTemplateResId, Video video) {
        mActivity.startActivity(Intent.createChooser(
                createShareIntent(messageTemplateResId, video.getName(), video.getKey()),
                mActivity.getString(R.string.title_share_trailer)));
    }

    public Intent createShareIntent(int messageTemplateResId, String title, String key) {
        ShareCompat.IntentBuilder builder = ShareCompat.IntentBuilder.from(mActivity)
                .setType("text/plain")
                .setText(mActivity.getString(messageTemplateResId, title, " http://www.youtube.com/watch?v=" + key));
        return builder.getIntent();
    }

    public static class FavoredEvent {
        public long movieId;
        public boolean favored;

        private FavoredEvent(long movieId, boolean favored) {
            this.movieId = movieId;
            this.favored = favored;
        }
    }
}
