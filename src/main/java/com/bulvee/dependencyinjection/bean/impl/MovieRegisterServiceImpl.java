package com.bulvee.dependencyinjection.bean.impl;

import com.bulvee.dependencyinjection.bean.MovieRegisterService;
import com.bulvee.dependencyinjection.model.Movie;
import com.bulvee.dependencyinjection.model.ReleaseCategory;
import com.bulvee.dependencyinjection.repository.MovieRepository;
import jakarta.inject.Inject;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class MovieRegisterServiceImpl implements MovieRegisterService {

    public static final long MONTHS = 3;
    @Inject
    private MovieRepository movieRepository;

    @Override
    public void save(Movie movie) {

        LocalDate releaseDate = LocalDate.from(Instant.ofEpochMilli(movie.getReleaseDate().getTime()).atZone(ZoneId.systemDefault()));

        LocalDate now = LocalDate.now();
        long mothesSinceReleased = ChronoUnit.MONTHS.between(releaseDate, now);

        if(mothesSinceReleased > MONTHS){
            movie.setReleaseCategory(ReleaseCategory.OLDER);
        } else {
            movie.setReleaseCategory(ReleaseCategory.NEWER);
        }

        movieRepository.save(movie);
    }
}
