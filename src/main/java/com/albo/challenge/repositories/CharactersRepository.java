package com.albo.challenge.repositories;

import com.albo.challenge.models.CharactersEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CharactersRepository implements PanacheRepository<CharactersEntity> {
}