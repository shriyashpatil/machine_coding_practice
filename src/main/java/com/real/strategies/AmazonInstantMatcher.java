package com.real.strategies;

import com.real.matcher.Matcher;
import com.real.repositories.MovieRepo;
import com.real.repositories.MovieRepoImpl;

import java.util.List;

public class AmazonInstantMatcher implements  MovieMatcherStrategy{

    MovieRepo movieRepo;

    public AmazonInstantMatcher(){

        movieRepo = MovieRepoImpl.getInstance();

    }

    @Override
    public List<Matcher.IdMapping> matchMovie(Matcher.CsvStream finderData) {
        return null;
    }
}
