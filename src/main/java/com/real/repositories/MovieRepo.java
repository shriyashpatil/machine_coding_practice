package com.real.repositories;

import com.real.models.MovieModel;


import java.util.Set;

public interface MovieRepo {


    boolean saveAll(Set<MovieModel> movies);

    MovieModel findMovieByTitle(String Title);


}
