package com.albo.challenge.services;

import com.albo.challenge.dto.request.HeroRequest;
import com.albo.challenge.models.HeroesEntity;

import java.util.List;


public interface HeroesService {
    Boolean add(HeroRequest request);

    Boolean delete(String shortName);

    List<HeroesEntity> all();
}
