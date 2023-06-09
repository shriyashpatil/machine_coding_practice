package com.real.repositories;

import com.real.models.CastModel;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CastRepoImpl implements  CastRepo{

    private final HashMap<Integer, Set<CastModel>> castDb = new HashMap<>();

    static CastRepo castRepo=null;

    private CastRepoImpl(){}

    @Override
    public boolean saveAll(Set<CastModel> castsSet) {

        castsSet.iterator().forEachRemaining(value->{

            Set<CastModel> casts;

            CastModel castModel = new CastModel();

            castModel.setMovieId(value.getMovieId());
            castModel.setCastName(value.getCastName());
            castModel.setCastType(value.getCastType());

            if(castDb.containsKey(value.getMovieId())){

                casts = castDb.get(value.getMovieId());

            }else{

                casts = new HashSet<>();

            }

            casts.add(castModel);

            castDb.put(value.getMovieId(),casts);

        });

        return true;
    }


    public static CastRepo getInstance(){

        if(castRepo==null) castRepo = new CastRepoImpl();

        return castRepo;

    }

}
