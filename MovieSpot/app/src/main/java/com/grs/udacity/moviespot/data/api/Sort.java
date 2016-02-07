package com.grs.udacity.moviespot.data.api;

import java.io.Serializable;

/**
 * Created by GodwinRoseSamuel on 28-Dec-15.
 */
public enum Sort implements Serializable {

    POPULARITY("popularity.desc"),
    VOTE_AVERAGE("vote_average.desc"),
    VOTE_COUNT("vote_count.desc");

    private final String value;

    Sort(String value) {
        this.value = value;
    }

    @Override public String toString() {
        return value;
    }

    public static Sort fromString(String value) {
        if (value != null) {
            for (Sort sort : Sort.values()) {
                if (value.equalsIgnoreCase(sort.value)) {
                    return sort;
                }
            }
        }
//        throw new IllegalArgumentException("No constant with text " + value + " found");
        return null;
    }
}
