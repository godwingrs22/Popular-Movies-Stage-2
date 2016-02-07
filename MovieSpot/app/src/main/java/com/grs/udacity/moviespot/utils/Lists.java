package com.grs.udacity.moviespot.utils;

import java.util.Collection;

/**
 * Created by GodwinRoseSamuel on 19-Jan-16.
 */
public final class Lists {

    public static <E> boolean isEmpty(Collection<E> list) {
        return (list == null || list.size() == 0);
    }

}
