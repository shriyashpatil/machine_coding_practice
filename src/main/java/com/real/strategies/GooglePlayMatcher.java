package com.real.strategies;

import com.real.matcher.Matcher;
import com.real.repositories.MovieRepo;
import com.real.repositories.MovieRepoImpl;

import java.util.List;

public class GooglePlayMatcher implements MovieMatcherStrategy{

    MovieRepo movieRepo;

    public GooglePlayMatcher(){

        movieRepo = MovieRepoImpl.getInstance();

    }
    @Override
    public List<Matcher.IdMapping> matchMovie(Matcher.CsvStream finderData) {
        return null;
    }
}
