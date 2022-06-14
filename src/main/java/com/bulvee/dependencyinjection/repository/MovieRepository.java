package com.bulvee.dependencyinjection.repository;

import com.bulvee.dependencyinjection.model.Movie;

import java.util.List;

public interface MovieRepository {

    void save(Movie movie);
}
