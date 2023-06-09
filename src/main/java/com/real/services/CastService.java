package com.real.services;

import com.real.matcher.Matcher;
import com.real.models.CastModel;

import com.real.repositories.CastRepo;
import com.real.repositories.CastRepoImpl;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class CastService {

    static CastService castService;

    CastRepo castRepo;

    private CastService(){

        castRepo = CastRepoImpl.getInstance();

    }


    public boolean saveCasts(Matcher.CsvStream castData){

        Stream<String> movieDataRows = castData.getDataRows();

        Set<CastModel> casts = new HashSet<>();

        movieDataRows.iterator().forEachRemaining(value->{

            CastModel castModel = new CastModel();

            String [] row = value.split(",");

            castModel.setMovieId(Integer.parseInt(row[0]));
            castModel.setCastName(row[1]);
            castModel.setCastType(row[2]);

            casts.add(castModel);

        });


        return  castRepo.saveAll(casts);


    }

    public static CastService getInstance(){

        if(castService==null) castService = new CastService();

        return castService;
    }

}
