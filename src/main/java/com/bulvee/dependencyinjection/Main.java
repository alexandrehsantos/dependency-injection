package com.bulvee.dependencyinjection;

import com.bulvee.dependencyinjection.bean.MovieRegisterService;
import com.bulvee.dependencyinjection.model.Movie;
import com.bulvee.dependencyinjection.util.cdi.WeldContext;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        MovieRegisterService service = WeldContext.INTANCE.getBean(MovieRegisterService.class);

        JFrame frame = new JFrame();

        String movieName = JOptionPane.showInputDialog(frame, "Enter the movie name");
        String movieReleaseDate = JOptionPane.showInputDialog(frame, "Input the movie release date. Formato MM/dd/yyyy");

        SimpleDateFormat dateFormater = new SimpleDateFormat("MM/dd/yyyy");

        Date movieReleaseDateFormatted = null;

        try {
            movieReleaseDateFormatted = dateFormater.parse(movieReleaseDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Movie movie = new Movie();
        movie.setName(movieName);
        movie.setReleaseDate(movieReleaseDateFormatted);

        service.save(movie);

    }

}
