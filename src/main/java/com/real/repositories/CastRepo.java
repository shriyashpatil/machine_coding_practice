package com.real.repositories;

import com.real.models.CastModel;

import java.util.Set;

public interface CastRepo {

     boolean saveAll(Set<CastModel> castsSet);
}
