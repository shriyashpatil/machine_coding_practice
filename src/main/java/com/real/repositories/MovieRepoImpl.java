package com.real.repositories;

import com.real.commons.ErrorMessage;
import com.real.exceptions.MovieNotFoundException;
import com.real.models.MovieModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Set;

public class MovieRepoImpl implements  MovieRepo{

    static MovieRepo movieRepo;

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieRepoImpl.class);
    private final HashMap<Integer, MovieModel> movieDb = new HashMap<>();

    private final HashMap<String,Integer> titleAndIdMap = new HashMap<>();

    private MovieRepoImpl(){ }

    @Override
    public boolean saveAll(Set<MovieModel> movies) {

        movies.iterator().forEachRemaining(value->{

            movieDb.put(value.getMovieId(),value);

            titleAndIdMap.put(value.getMovieTitle(),value.getMovieId());

        });

        return true;
    }

    @Override
    public MovieModel findMovieByTitle(String Title) {


        try{

            if(titleAndIdMap.containsKey(Title)) return movieDb.get(titleAndIdMap.get(Title));

            else throw new MovieNotFoundException(ErrorMessage.MOVIE_NOT_FOUND);

        }catch(MovieNotFoundException me){

            LOGGER.info(me.getMessage());

        }

        return null;

    }



    public static MovieRepo getInstance(){

        if(movieRepo==null) movieRepo = new MovieRepoImpl();

        return movieRepo;
    }


}
