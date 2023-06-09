package com.real.services;

import com.real.matcher.Matcher;
import com.real.models.MovieModel;
import com.real.repositories.MovieRepo;
import com.real.repositories.MovieRepoImpl;


import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class MovieService {

    MovieRepo movieRepo;

    static MovieService movieService = null;

    private MovieService(){

        movieRepo = MovieRepoImpl.getInstance();

    }

    public boolean saveMovies(Matcher.CsvStream movieData){

        Stream<String> movieDataRows = movieData.getDataRows();

        Set<MovieModel> movies = new HashSet<>();

        movieDataRows.iterator().forEachRemaining(value->{

            MovieModel movieModel = new MovieModel();

            String [] row = value.split(",");
            movieModel.setMovieId(Integer.parseInt(row[0]));
            movieModel.setMovieTitle(row[1]);
            movieModel.setYear(row[2]);

            movies.add(movieModel);

        });


        return  movieRepo.saveAll(movies);

    }





    public static MovieService getInstance(){

        if(movieService==null) movieService = new MovieService();

        return movieService;
    }

}
