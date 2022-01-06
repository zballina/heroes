package com.albo.challenge.repositories;

import com.albo.challenge.models.HeroesEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HeroesRepository implements PanacheRepositoryBase<HeroesEntity, String> {
}