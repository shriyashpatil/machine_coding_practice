package com.real.strategies;

import com.real.matcher.Matcher;
import com.real.models.MovieModel;
import com.real.repositories.MovieRepo;
import com.real.repositories.MovieRepoImpl;

import java.util.*;
import java.util.stream.Stream;

public class XboxMatcher implements MovieMatcherStrategy{

    MovieRepo movieRepo;

    HashSet<String> ids = new HashSet<>();

    public XboxMatcher(){

        movieRepo = MovieRepoImpl.getInstance();

    }

    @Override
    public List<Matcher.IdMapping> matchMovie(Matcher.CsvStream finderData) {

        Stream<String> finderDataRows = finderData.getDataRows();

        List<Matcher.IdMapping> returnList = new ArrayList<>();

        finderDataRows.iterator().forEachRemaining(value->{

            String [] row = value.split(",");

            String title = row[3];
            String mediaId = row[2];

            MovieModel movieModel1 = movieRepo.findMovieByTitle(title);

            if(movieModel1!=null){

                int internalId = movieModel1.getMovieId();

                String checkId = internalId + mediaId;

                if(!ids.contains(checkId)){

                    ids.add(checkId);

                    Matcher.IdMapping idMapping = new Matcher.IdMapping(internalId, mediaId);

                    returnList.add(idMapping);

                }

            }

        });

        return returnList;

    }
}
