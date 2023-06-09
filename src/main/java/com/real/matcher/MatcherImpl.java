package com.real.matcher;


import java.util.List;

import com.real.services.CastService;
import com.real.services.MovieMatcherService;
import com.real.services.MovieService;
import com.real.strategies.AmazonInstantMatcher;
import com.real.strategies.GooglePlayMatcher;
import com.real.strategies.VuduMatcher;
import com.real.strategies.XboxMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MatcherImpl implements Matcher {

  private static final Logger LOGGER = LoggerFactory.getLogger(MatcherImpl.class);

  MovieService movieService;

  CastService castService;

  public MatcherImpl(CsvStream movieDb, CsvStream actorAndDirectorDb) {
    LOGGER.info("importing database");

    movieService = MovieService.getInstance();

    movieService.saveMovies(movieDb);

    castService = CastService.getInstance();

    castService.saveCasts(actorAndDirectorDb);

    // TODO implement me
    LOGGER.info("database imported");
  }

  @Override
  public List<IdMapping> match(DatabaseType databaseType, CsvStream externalDb) {
    // TODO implement me

    MovieMatcherService movieMatcherService;

    if(databaseType == Matcher.DatabaseType.XBOX){

      movieMatcherService = new MovieMatcherService(new XboxMatcher());

    }
    else if (databaseType == Matcher.DatabaseType.AMAZON_INSTANT){

      movieMatcherService = new MovieMatcherService(new AmazonInstantMatcher());

    }
    else if ( databaseType == Matcher.DatabaseType.VUDU ){

      movieMatcherService = new MovieMatcherService(new VuduMatcher());

    }
    else if( databaseType == Matcher.DatabaseType.GOOGLE_PLAY){

      movieMatcherService = new MovieMatcherService(new GooglePlayMatcher());

    }else{

      /// default
      movieMatcherService = new MovieMatcherService(new XboxMatcher());

    }

    return movieMatcherService.matchMovie(externalDb);

  }

}
