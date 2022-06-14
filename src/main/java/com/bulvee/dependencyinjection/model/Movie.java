package com.bulvee.dependencyinjection.model;

import java.time.LocalDate;
import java.util.Date;

public class Movie {

    private String name;
    private Date releaseDate;
    private ReleaseCategory releaseCategory;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public ReleaseCategory getReleaseCategory() {
        return releaseCategory;
    }

    public void setReleaseCategory(ReleaseCategory releaseCategory) {
        this.releaseCategory = releaseCategory;
    }
}

