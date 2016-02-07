package com.grs.udacity.moviespot.data.repository;

import com.grs.udacity.moviespot.model.Genre;

import java.util.Map;

import rx.Observable;


/**
 * Created by GodwinRoseSamuel on 20-Jan-16.
 */
public interface GenresRepository {

    Observable<Map<Integer, Genre>> genres();

}
