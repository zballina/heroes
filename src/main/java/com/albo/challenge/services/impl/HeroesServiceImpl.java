package com.albo.challenge.services.impl;

import com.albo.challenge.dto.request.HeroRequest;
import com.albo.challenge.models.HeroesEntity;
import com.albo.challenge.repositories.HeroesRepository;
import com.albo.challenge.services.HeroesService;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;


@ApplicationScoped
public class HeroesServiceImpl implements HeroesService {

    private static final Logger LOG = Logger.getLogger(HeroesServiceImpl.class);

    @Inject
    HeroesRepository heroesRepository;

    @Override
    public Boolean add(HeroRequest request) {
        try {
            heroesRepository.persist(HeroesEntity.builder()
                    .shortName(request.getShortName())
                    .name(request.getName())
                    .build());
            return true;
        } catch (Exception ex) {
            LOG.error(ex.getMessage());
            return false;
        }
    }

    @Override
    public Boolean delete(String shortName) {
        try {
            heroesRepository.delete("shortName", shortName);
            return true;
        } catch (Exception ex) {
            LOG.error(ex.getMessage());
            return false;
        }
    }

    @Override
    public List<HeroesEntity> all() {
        return heroesRepository.listAll();
    }
}
