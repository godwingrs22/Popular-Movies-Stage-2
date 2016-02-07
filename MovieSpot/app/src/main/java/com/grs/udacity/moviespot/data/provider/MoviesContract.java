package com.grs.udacity.moviespot.data.provider;
import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;


/**
 * Created by GodwinRoseSamuel on 16-Jan-16.
 */
public final class MoviesContract {

    public static final String QUERY_PARAMETER_DISTINCT = "distinct";

    public interface GenresColumns {
        String GENRE_ID = "genre_id";
        String GENRE_NAME = "genre_name";
    }

    public interface MoviesColumns {
        String MOVIE_ID = "movie_id";
        String MOVIE_TITLE = "movie_title";
        String MOVIE_OVERVIEW = "movie_overview";
        String MOVIE_POPULARITY = "movie_popularity";
        String MOVIE_GENRE_IDS = "movie_genre_ids"; //This is a comma-separated list of genre ids.
        String MOVIE_VOTE_COUNT = "movie_vote_count";
        String MOVIE_VOTE_AVERAGE = "movie_vote_average";
        String MOVIE_RELEASE_DATE = "movie_release_date";
        String MOVIE_FAVORED = "movie_favored";
        String MOVIE_POSTER_PATH = "movie_poster_path";
        String MOVIE_BACKDROP_PATH = "movie_backdrop_path";
    }

    public static final String CONTENT_AUTHORITY = "com.grs.udacity.moviespot.app";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    private static final String PATH_GENRE = "genres";
    private static final String PATH_MOVIE = "movies";

    /**
     * Genres represent Movie classifications. A movie can have many genres.
     */
    public static class Genres implements GenresColumns, BaseColumns {
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_GENRE).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_GENRE;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_GENRE;

        /**
         * Build {@link Uri} that references all genres.
         */
        public static Uri buildGenresUri() {
            return CONTENT_URI;
        }

        /** Build a {@link Uri} that references a given genre. */
        public static Uri buildGenreUri(String genreId) {
            return CONTENT_URI.buildUpon().appendPath(genreId).build();
        }
    }

    /**
     * Each movie has zero or more {@link Genres}.
     */
    public static class Movies implements MoviesColumns, BaseColumns {
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_MOVIE).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_MOVIE;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_MOVIE;

        /** Default "ORDER BY" clause. */
        public static final String DEFAULT_SORT = BaseColumns._ID + " DESC";

        /** Build {@link Uri} for requested {@link #MOVIE_ID}. */
        public static Uri buildMovieUri(String movieId) {
            return CONTENT_URI.buildUpon().appendPath(movieId).build();
        }

        /**
         * Build {@link Uri} that references any {@link Genres} associated with
         * the requested {@link #MOVIE_ID}.
         */
        public static Uri buildGenresDirUri(String movieId) {
            return CONTENT_URI.buildUpon().appendPath(movieId).appendPath(PATH_GENRE).build();
        }

        /** Read {@link #MOVIE_ID} from {@link Movies} {@link Uri}. */
        public static String getMovieId(Uri uri) {
            return uri.getPathSegments().get(1);
        }
    }

    private MoviesContract() {
        throw new AssertionError("No instances.");
    }
}
