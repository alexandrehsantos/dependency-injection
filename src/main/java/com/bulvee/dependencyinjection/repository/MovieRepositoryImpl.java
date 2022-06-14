package com.bulvee.dependencyinjection.repository;

import com.bulvee.dependencyinjection.model.Movie;
import com.thoughtworks.xstream.XStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class MovieRepositoryImpl implements MovieRepository {


    @Override
    public void save(Movie movie) {

        XStream xStream = new XStream();
        xStream.alias("movie", Movie.class);

        OutputStream out = null;

        try{
            out = new FileOutputStream(movie.getName() + ".xml");
            xStream.toXML(movie, out);
        }catch (FileNotFoundException e){
            throw new RuntimeException("Erro ao salvar o arquivo", e);
        }

    }
}
