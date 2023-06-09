package com.real.services;

import com.real.matcher.Matcher;
import com.real.strategies.MovieMatcherStrategy;

import java.util.List;

public class MovieMatcherService {


    MovieMatcherStrategy movieMatcherStrategy;

    public MovieMatcherService(MovieMatcherStrategy movieMatcherStrategy){

        this.movieMatcherStrategy = movieMatcherStrategy;

    }

    public List<Matcher.IdMapping> matchMovie(Matcher.CsvStream finderData){

        return movieMatcherStrategy.matchMovie(finderData);

    }



}
