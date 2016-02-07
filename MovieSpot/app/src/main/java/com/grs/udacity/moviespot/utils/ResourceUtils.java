package com.grs.udacity.moviespot.utils;

import android.content.res.Resources;
import android.support.annotation.DimenRes;
import android.support.annotation.NonNull;
import android.util.TypedValue;

import timber.log.Timber;

/**
 * Created by GodwinRoseSamuel on 19-Jan-16.
 */
public final class ResourceUtils {

    private ResourceUtils() {
        throw new AssertionError("No instances.");
    }

    public static float getFloatDimension(@NonNull Resources resources, @DimenRes int dimenRes) {
        TypedValue value = new TypedValue();
        resources.getValue(dimenRes, value, true);
        Timber.d("Value type: " + (value.type == TypedValue.TYPE_FLOAT));
        return value.getFloat();
    }
}
